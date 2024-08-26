

public class palindromLL {
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void addFrist(String data) {

        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;

    }

    public void addLast(String data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
    }

    public void printList() {
        Node temp = head;
        if (head == null) {
            System.out.println("node data found");
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;

        }
        System.out.println("null");
    }
    public Node reverse(Node head)
    {
        Node prev=null;
        Node curr=head;
        while (curr!=null) {
            Node nextNode=curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            
        }
        return prev;
    }

    public Node findMiddle(Node head) {
        Node hai = head;
        Node turtle = head;
        while (turtle.next != null && hai.next.next != null) {
            turtle = turtle.next;
            hai = hai.next.next;

        }

        return turtle;
    }

    public boolean palinDrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node middle = findMiddle(head);
        Node secondhalf = reverse(middle.next);

        Node frist = head;
        while (secondhalf != null) {
            if (secondhalf.data != frist.data) {
                return false;

            }
            frist = frist.next;
            secondhalf = secondhalf.next;

        }

        return true;
    }

    public static void main(String[] args) {
        palindromLL ll = new palindromLL();
        ll.addFrist("a");
        ll.addFrist("m");
        ll.addLast("a");
        ll.addLast("m");
        ll.printList();

        boolean ans=ll.palinDrome(ll.head);
        if(ans)
        {
            System.out.println("plainDrome");
        }
        else
        {
            System.out.println("not palindrome");
        }

    }

}
