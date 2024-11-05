package service;

import model.Order;

public class OrderSearch {
    public static Order linearSearch(Order[] orders, String searchQuery) {
        for (Order order : orders) {
            if (order.getOrderId().equalsIgnoreCase(searchQuery) ||
                    order.getCustomerName().equalsIgnoreCase(searchQuery)) {
                System.out.println("Order found: " + order);
                return order;
            }
        }
        System.out.println("Order not found for query: " + searchQuery);
        return null;
    }
}
