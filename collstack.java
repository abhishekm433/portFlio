import java.util.*;

public class collstack {
    public static void pushAtBottom(int data, Stack<Integer> stack) {
        // If the stack is empty, push the data and return
        if (stack.isEmpty()) {
            stack.push(data);
            System.out.println("emptyCondition: " + stack.peek());
            return;
        }

        // Pop the top element and store it
        int top = stack.pop();
        System.out.println("top: " + top);

        // Recursively call pushAtBottom
        pushAtBottom(data, stack);

        // After recursion, push the stored top element back onto the stack
        stack.push(top);
        System.out.println("pushAtend: " + stack.peek());
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Initial Stack: " + stack);
        pushAtBottom(4, stack);

        System.out.println("Stack after pushAtBottom(4): " + stack);

        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.peek());
            stack.pop();
        }
    }
}
