import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class queuecollection {
    static class queue {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        boolean isEmpty() {
            return s.isEmpty();
        }

        void add(int data) {
            while (!s.isEmpty()) {
                s2.push(s.pop());

            }
            s.push(data);

            while (!s2.isEmpty()) {
                s.push(s2.pop());
            }
        }

        int remove() {
            if (isEmpty()) {
                System.out.println("queue is Empty");
                return -1;
            }
            return s.pop();
        }

        int peek()
        {
            if(isEmpty())
            {
                System.out.println("queue is Empty");
                return -1;
            }
            return s.peek();
        }
    }


    public static void main(String[] args) {
        queue q=new queue();
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.println(q.peek());

            q.remove();
        }

    }
}
