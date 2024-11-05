package service;
import java.util.Stack;
import model.Order;

public class CompletedOrdersStack {
    private Stack<Order> stack = new Stack<>();

    public void push(Order order) {
        stack.push(order);
        System.out.println("\nOrder added to completed stack: " + order);
    }

    public Order pop() {
        Order order = stack.pop();
        System.out.println("\nOrder removed from completed stack: " + order);
        return order;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
