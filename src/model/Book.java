package model;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private int quantity;
    private double price; // Optional, if you want to include price information

    public Book(String bookId, String title, String author, int quantity, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Book ID: '%s', Title: '%s', Author: '%s', Quantity: %d, Price: $%.2f", bookId, title, author, quantity, price);
    }
}

