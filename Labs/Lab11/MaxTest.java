
import java.io.*;
@SuppressWarnings("unchecked")

public class MaxTest 
{
   public static void main(String[] args) throws IOException, CloneNotSupportedException
   {
        	Stack stack1 = new Stack();
		stack1.push("Andy");
		stack1.push("Allison");
		stack1.push("Aaron");
		stack1.push("Austin");
		stack1.push("Abbey");
		stack1.push("Alex");
        	System.out.println("findMax(stack1)="+findMax(stack1)); 
        	System.out.println("stack1.findMax()="+stack1.findMax()); 
  }
  
  static String findMax(Stack stack) throws CloneNotSupportedException
  {
    Stack tmp = (Stack) stack.clone();
    String max = "";
    
    while(!tmp.isEmpty())
    {
      if(((String) tmp.top()).compareTo(max) > 0)
      {
        max = (String) tmp.top();
      }
      tmp.pop();
    }
    return max;
    
  }
}
