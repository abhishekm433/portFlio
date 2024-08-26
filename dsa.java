

class dsa {
    class Node
    {
        String data;
        Node next;
        Node(String str)
        {
            this.data=str;
            this.next=null;
        }
    }
    public Node head;
    public void addFrist(String data)
    {
        Node newnode=new Node(data);
        if(head==null)
        {
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
        
    }
    public void addLast(String data)
    {
        Node newnode=new Node(data);
        if(head==null)
        {
            head=newnode;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            
            temp=temp.next;
        }
        temp.next=newnode;
        

    }
    public void printList()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public Node deln(Node head,int val)
{
    if(head==null)
    {
        return head;
    }
    int size=0;
    Node curr=head;
    while(curr!=null)
    {
        size++;
       curr=curr.next;
        
        
    }
    int Loc=size-val;
    if(val==size)
    {
        return head.next;
    }
 
    Node prev=head;
    for(int i=1;i<Loc;i++)
    {
        prev=prev.next;
    }
    prev.next=prev.next.next;
    return head;
}
    public static void main(String[] args) {
      dsa list=new dsa();
      list.addFrist("1");
      list.addFrist("0");
      list.addLast("2");
      list.printList();
      list.head=list.deln(list.head,2);
      list.printList();
    }
}