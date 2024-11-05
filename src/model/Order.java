package model;

import service.MergeSortBooks;

import java.util.Arrays;
import java.util.List;

public class Order {
    private String orderId;
    private String customerName;
    private String shippingAddress;
    private List<Book> books;
    private String status;

    // Constructor to initialize all fields, including orderId
    public Order(String orderId, String customerName, String shippingAddress, List<Book> books) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.books = books;
        this.status = "Pending Processing";
    }

    // Getters for all fields
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method to sort books by specified criteria
    public void sortBooks(String sortBy) {
        // Convert List<Book> to Book[] for sorting
        Book[] bookArray = books.toArray(new Book[0]);
        MergeSortBooks.mergeSort(bookArray, 0, bookArray.length - 1, sortBy);
        // Update the original books list after sorting
        books = Arrays.asList(bookArray);
    }

    // toString method for improved readability
    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append(String.format("Order ID: '%s', Customer Name: '%s', Status: '%s', Shipping Address: '%s', Books: [%n", orderId, customerName, status, shippingAddress));
        for (Book book : books) {
            orderDetails.append("  " + book.toString() + ",\n");
        }
        orderDetails.append("]");
        return orderDetails.toString();
    }
}
