import model.Order;
import model.Book;
import service.CompletedOrdersStack;
import service.OrderQueue;
import service.OrderSearch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("001", "The Great Gatsby", "F. Scott Fitzgerald", 2, 10.99);
        Book book2 = new Book("002", "To Kill a Mockingbird", "Harper Lee", 1, 8.99);
        Book book3 = new Book("003", "1984", "George Orwell", 3, 12.99);
        Book book4 = new Book("004", "A Game of Thrones", "George R.R. Martin", 3, 12.99);
        Book book5 = new Book("005", "Brave New World", "Aldous Huxley", 1, 15.99);
        Book book6 = new Book("006", "Moby Dick", "Herman Melville", 1, 9.99);

        // Create different lists of books for each order
        List<Book> bookList1 = Arrays.asList(book1, book2);
        List<Book> bookList2 = Arrays.asList(book3, book4);
        List<Book> bookList3 = Arrays.asList(book5, book6);
        List<Book> bookList4 = Arrays.asList(book1, book3, book5);
        List<Book> bookList5 = Arrays.asList(book2, book4, book6);

        // Create orders with different book lists
        Order order1 = new Order("001", "Alice", "123 Maple St", bookList1);
        Order order2 = new Order("002", "Bob", "456 Oak Ave", bookList2);
        Order order3 = new Order("003", "Charlie", "789 Pine Rd", bookList3);
        Order order4 = new Order("004", "David", "101 Elm St", bookList4);
        Order order5 = new Order("005", "Eve", "202 Birch Rd", bookList5);

        // Initialize the order processing queue
        OrderQueue orderQueue = new OrderQueue();
        orderQueue.enqueue(order1);
        orderQueue.enqueue(order2);
        orderQueue.enqueue(order3);
        orderQueue.enqueue(order4);
        orderQueue.enqueue(order5);
        System.out.println("_________________________________________________________________________");

        // Confirm the availability of books and sort based on user choice
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose a sorting option for books in each order: (1) Title, (2) Author");
        int choice = scanner.nextInt();
        String sortBy = (choice == 1) ? "title" : "author";

        // Process each order in the queue
        CompletedOrdersStack completedOrdersStack = new CompletedOrdersStack();
        while (!orderQueue.isEmpty()) {
            Order currentOrder = orderQueue.peek();
            System.out.println("\nNext Order to be Processed:");
            System.out.println(currentOrder);

            currentOrder.setStatus("Processing");
            System.out.println("\nOrder Status Updated to Processing:");
            System.out.println(currentOrder);

            currentOrder = orderQueue.dequeue();
            currentOrder.sortBooks(sortBy);
            System.out.println("\nProcessing Order (After Sorting):");
            System.out.println(currentOrder);

            // Set status to "Processed Successfully" after processing
            currentOrder.setStatus("Processed Successfully");
            completedOrdersStack.push(currentOrder);
            System.out.println("_________________________________________________________________________");
        }

        // Demonstrate sorting of multiple orders by customer name
        Order[] orders = { order1, order2, order3, order4, order5 };

        // Search for an order by customer name
        Scanner scannerSearch = new Scanner(System.in);
        System.out.print("\nEnter the order ID or customer name to search for an order: ");
        String searchQuery = scannerSearch.nextLine();

        System.out.println("\nSearching for order:");
        OrderSearch.linearSearch(orders, searchQuery);

        Scanner scannerRemoveCompleted = new Scanner(System.in);
        System.out.println("\nWould you like to remove all Completed Orders: (1) Yes, (2) No");
        int decision = scannerRemoveCompleted.nextInt();
        if (decision == 1) {
            System.out.println("\nRemove all Completed Orders:");
            while (!completedOrdersStack.isEmpty()) {
                completedOrdersStack.pop();
            }
        }
    }
}
