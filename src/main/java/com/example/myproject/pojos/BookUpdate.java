package com.example.myproject.pojos;

public class BookUpdate {
    private Integer id;
    private String title;
    private String author;
    private String pubDate;
    private float price;
    private String genre;
    private String isbn;
    private int quantity;

    public BookUpdate() {
    }

    public BookUpdate(Integer id, String title, String author, String pubDate, float price, String genre, String isbn, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
        this.price = price;
        this.genre = genre;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
