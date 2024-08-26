public class queueclass {
    static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class queue {
        node head = null;
        node tail = null;

        boolean isEmpty() {
            return head == null && tail == null;
        }

        void add(int data) {
            node newnode = new node(data);
            if (isEmpty()) {
                tail = head = newnode;
            }

            tail.next = newnode;
            tail = newnode;

        }

        int remove()
        {
            if(isEmpty())
            {
                System.out.println("Queue is Empty");
                return -1;
            }
            int data=head.data;
            head=head.next;
            return data;
        }
        int peek()
        {
            if(isEmpty())
            {
                System.out.println("queue not data found");
                return -1;
            }
            return head.data;

        }
    }
    public static void main(String[] args) {
        
     queue q=new queue();
     q.add(0);
     q.add(2);
     q.add(3);
     System.out.println(q.peek());
     System.out.println(q.remove());
     System.out.println(q.peek());
    }
}