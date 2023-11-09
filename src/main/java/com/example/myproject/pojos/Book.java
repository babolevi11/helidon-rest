package com.example.myproject.pojos;

import java.util.Objects;

public class Book {
    //private long id;
    private String title;
    private String author;
    private String pubDate;
    private float price;
    private String genre;
    private String isbn;
    private int quantity;

    public Book() {}

    public Book(String title, String author, String pubDate, float price, String genre, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
        this.price = price;
        this.genre = genre;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(pubDate, book.pubDate) && Objects.equals(genre, book.genre) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pubDate, genre, isbn);
    }

    //public long getId() { return id; }

    //public void setId(long id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
