
@SuppressWarnings("unchecked")

public class Links
{
	public static void main(String[] args)
	{
     Node pos1 = null;
     Node pos2 = null;
     pos1 = new Node(new Integer(13));
     pos1.setNext(new Node(new Integer(15), null));
     pos2 = new Node(new Integer(11), null);
		 pos2.setNext(pos1);
		 printList(pos2);
      System.out.println(findMax(pos1));
	}

	private static void printList(Node head)
	{
		if (head != null)
		{
			System.out.println(head.getItem());
			printList(head.getNext());
		}
	}
 
 
 
   private static int count(Node head)
   {
     if (head != null)
     {
       return 1 + count(head.getNext());
     }
     else
     {
       return 0;
     }
     
   }
   
   private static Object findMax(Node head)
   {
     Object currMax = head.getItem();
     Node curr = head;
       
     while (head != null)
     {
       if (((Comparable)curr.getItem()).compareTo(currMax) > 0)
         currMax = curr.getItem();
       curr = curr.getNext();
       
     }
     return currMax;
     
   }
}
