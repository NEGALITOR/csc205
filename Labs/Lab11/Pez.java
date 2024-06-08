
class Pez
{
  static Stack pezStack = new Stack();
  public static void main(String[] args) throws CloneNotSupportedException
  {
    addPez();
    removeGreen();
    print();
  }


  static void addPez()
  {
    pezStack.push("yellow");
    pezStack.push("red");
    pezStack.push("green");
    pezStack.push("green");
    pezStack.push("yellow");
    pezStack.push("yellow");
    pezStack.push("red");
    pezStack.push("green");
  }
  
  static void removeGreen() throws CloneNotSupportedException
  {
    Stack tmp = new Stack();
    String curr = "";
    
    while(!pezStack.isEmpty())
    {
      curr = (String) pezStack.pop();
      if(!curr.equals("green"))
        tmp.push(curr);
    }
    
    while(!tmp.isEmpty())
    {
      pezStack.push(tmp.pop());
    }
  
  }
  
  static void print() throws CloneNotSupportedException
  {
    Stack tmp = (Stack) pezStack.clone();
    while(!tmp.isEmpty())
    {
      System.out.println(tmp.pop());
    }
      
    
    
  }
}