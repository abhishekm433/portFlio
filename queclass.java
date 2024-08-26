public class queclass {
    static class Queue {
        int arr[];
        int rear = -1;
        int front = 0;
        int size;

        Queue(int n) {
            arr = new int[n];
            this.size = n;
        }

        public boolean isEmpty() {
            return rear < front;
        }

        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int removedData = arr[front];
            front++;
            if (isEmpty()) {
                // Reset pointers when the queue is empty
                front = 0;
                rear = -1;
            }
            return removedData;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(10);

        q.add(2);
        q.add(3);
        q.add(5);

        System.out.println(q.remove()); // 2
        System.out.println(q.peek());   // 3
    }
}
