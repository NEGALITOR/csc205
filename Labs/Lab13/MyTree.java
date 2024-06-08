public class MyTree
{
  public static void main(String[] args) throws CloneNotSupportedException
  {
    BinarySearchTree t = new BinarySearchTree();
    
    t.insert(new KeyedItem("M"));

    t.insert(new KeyedItem("J"));
    t.insert(new KeyedItem("D"));
    t.insert(new KeyedItem("L"));
    t.insert(new KeyedItem("F"));
    
    t.insert(new KeyedItem("W"));
    t.insert(new KeyedItem("S"));
    t.insert(new KeyedItem("Z"));
    t.insert(new KeyedItem("T"));
    
    t.delete("M");
    
    System.out.println("Inorder: ");
    t.inorder();
    
    System.out.println("\nPreorder: ");
    t.preorder();
    
    System.out.println("\nPostorder: ");
    t.postorder();
    
    BinarySearchTree t2 = (BinarySearchTree) t.clone();
    
     if (t.duplicateCheck(t2))
       System.out.println("\nThey're Duplicates");
     else
       System.out.println("\nThey're Not Duplicates");
    
  }
}