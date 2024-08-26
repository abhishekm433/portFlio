public class stack {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class StackStruct {
        static Node head = null;

        static boolean isEmpty() {
            return head == null;
        }

        static void push(int data) {
            Node newnode = new Node(data);
            if (isEmpty()) {
                head = newnode;
                return;

            }
            newnode.next = head;
            head = newnode;

        }

        public int pop() {
            if (isEmpty()) {
                return -1;

            }
            int data = head.data;
            head = head.next;
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;

        }
    }

    public static void main(String[] args) {
        StackStruct stack = new StackStruct();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();

        }

    }

}
