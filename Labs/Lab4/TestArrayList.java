import java.util.*;
public class TestArrayList
{
	public static void main(String[] args)
	{
		ArrayList<String> arr = new ArrayList<String>(10);
		
		arr.add("Python");
		arr.add("Java");
                arr.add("Java");
                arr.add("Java");
                arr.add("Java");
                arr.add("Java");
		arr.add("C++");
		arr.add("C++");
                arr.add("C++");
                arr.add("C++");

		printArrayList(arr);
		delete(arr, "Java");
		printArrayList(arr);
		System.out.println(count(arr, "C++"));
	
    	}

   	private static void printArrayList(ArrayList<String> myArrayList)
    	{
		// Pre  : myArrayList has been initialized
		// Post : The elements of Vector v are printed to the screen on separate lines
		for(String i : myArrayList)
		{
			System.out.println(i);
		}
	
	
	
    	}

    	private static void delete(ArrayList<String> myArrayList, Object key)
    	{
		// Pre  : myArrayList has been initialized
		// Post : All copies of key are removed from myArrayList
		System.out.println("\n");

		int index = myArrayList.indexOf(key);
		while(index >= 0)
		{
			myArrayList.remove(index);
			index = myArrayList.indexOf(key);

		}


    	}

    	private static int count(ArrayList<String> myArrayList, Object key)
    	{
		// Pre  : myArrayList has been initialized
		// Post : number of occurrences of key is computed and returned
		int count = 0;
                for(String i : myArrayList)
                {
			if(i.equals(key))
				count++;

		}
	
		return count;	
    	}
}
