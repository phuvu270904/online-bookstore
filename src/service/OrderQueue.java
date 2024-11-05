package service;

import model.Order;
import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    private Queue<Order> queue = new LinkedList<>();

    public void enqueue(Order order) {
        queue.add(order);
        System.out.println("\nEnqueued Order: " + order);
    }

    public Order dequeue() {
        if (!queue.isEmpty()) {
            Order processedOrder = queue.poll();
            System.out.println("\nDequeued Order: " + processedOrder);
            return processedOrder;
        }
        System.out.println("Queue is empty.");
        return null;
    }

    public Order peek() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        System.out.println("Queue is empty.");
        return null;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
