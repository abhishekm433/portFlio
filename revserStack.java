import java.util.Stack;

public class revserStack {
    static void StackReverse(Stack<Integer> stack)
    {
        if(stack.isEmpty())
        {
            return;
        }
       int top=stack.pop();
       StackReverse(stack);
       stack.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        StackReverse(stack);
        

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
            
        }
    }
    
}
