package com.example.myproject.services;

import com.example.myproject.pojos.Book;
import com.example.myproject.pojos.BookUpdate;
import io.helidon.config.Config;
import io.helidon.http.Status;
import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class BookService implements HttpService {

    private final AtomicReference<String> greeting = new AtomicReference<>();
    private Map<Integer, Book> books = new HashMap<>();

    public BookService() {
        this(Config.global().get("app"));
        this.books.put(1, new Book("The Art of Programming", "John Smith", "2023-01-15", 49.99F, "Computer Science", "9780123456789", 10));
        this.books.put(2, new Book("The Power of Words", "Emily Johnson", "2022-11-30", 29.99F, "Self-Help", "9789876543210", 5));
        this.books.put(3, new Book("A Journey Through Time", "David Thompson", "2023-03-22", 19.99F, "Fantasy", "9786543210987", 8));
        this.books.put(4, new Book("The Hidden Secrets", "Sarah Roberts", "2023-02-10", 14.99F, "Mystery", "9783210987654", 12));
        this.books.put(5, new Book("The Science of Nature", "Michael Anderson", "2023-04-18", 24.99F, "Science", "9785432109876", 3));
    }

    public BookService(Config appConfig) {
        greeting.set(appConfig.get("greeting").asString().orElse("Ciao"));
    }

    @Override
    public void routing(HttpRules httpRules) {
        httpRules
                .get("/", this::getBooks)
                .post("/", this::addBook)
                .put("/", this::updateBook)
                .delete("/", this::deleteBook);
    }

    private void getBooks(ServerRequest request, ServerResponse response) {
        response.send(books);
    }

    private void addBook(ServerRequest request, ServerResponse response) {
        Book post = request.content().as(Book.class);
        if(!books.containsValue(post)) {
            Integer last = 0;
            for (Integer key : books.keySet()) {
                last = key;
            }
            books.put(last + 1, post);
            response.status(Status.CREATED_201).send(post);
        } else {
            response.status(Status.CONFLICT_409).send("Duplicate Record!");
        }
    }

    private void updateBook(ServerRequest request, ServerResponse response) {
        BookUpdate upd = request.content().as(BookUpdate.class);

        if (books.replace(upd.getId(), new Book(upd.getTitle(), upd.getAuthor(), upd.getPubDate(), upd.getPrice(), upd.getGenre(), upd.getIsbn(), upd.getQuantity())) != null) {
            response.status(Status.OK_200).send(books);
        } else {
            response.status(Status.CONFLICT_409).send("Id(" + upd.getId() + ") not found!");
        }
    }

    private void deleteBook(ServerRequest request, ServerResponse response) {
        BookUpdate del = request.content().as(BookUpdate.class);

        if (books.remove(del.getId()) != null) {
            response.status(Status.OK_200).send(books);
        } else {
            response.status(Status.CONFLICT_409).send("Id(" + del.getId() + ") not found!");
        }
    }
}
