
import java.util.*;

@SuppressWarnings("unchecked")
public class JCFStack
{
   public static void main(String[] args) throws CloneNotSupportedException
   {
     Scanner stdin = new Scanner(System.in);
   
        	Stack stack1 = new Stack();
		stack1.push(new Integer(27));
		stack1.push(new Integer(0));
		stack1.push(new Integer(-3));
		stack1.push(new Integer(-18));
		stack1.push(new Integer(99));
 	       printStack (stack1); 
    
    System.out.print("key value = ");
    Integer x = Integer.valueOf(stdin.next());
    if(stack1.search(x) != -1)
    {
      System.out.println("key value found at position " + stack1.search(x));
    }
    else
    {
      System.out.println("key value not found");
    }
    
    
       

  }

  private static void printStack (Stack s) throws CloneNotSupportedException
  {
        Stack tempStack = (Stack) (s.clone());
        if (! tempStack.isEmpty())
                System.out.println("*** Printing Out Stack:  ");

        while (! tempStack.isEmpty())
        {
               System.out.println(tempStack.peek());
               tempStack.pop();
        }
  }
  
  
}
