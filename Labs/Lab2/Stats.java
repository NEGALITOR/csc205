import java.util.*;
public class Stats
{
	private static final int MAX_SIZE = 100;
	public static void main(String[] args)
	{
        	int[] List = new int[MAX_SIZE];		
		int numItems;

        	numItems = fillUp (List);
		
        	System.out.println("\n\10\7" + " The range of your " + numItems + " items is : " + range (List, numItems));

        	System.out.println("\n\10\7" + " The mean of your " + numItems + " items is  :  " + mean (List, numItems));
	}
	
	public static int fillUp(int[] arr)
	{
		Scanner stdin = new Scanner(System.in);
                System.out.println("Please Input Your Values (Enter a 0 to Stop) :");
		int index = 0;
		int val = -1;
	
		while(val != 0)
		{
			val = stdin.nextInt();
			arr[index] = val;
			index++;
		}
		return index-1;
	}

	public static int range(int[] arr, int numItems)
	{
		int high = arr[0];
		int low = arr[0];
		for(int i = 0; i < numItems; i++)
		{
			if(high < arr[i])
			{
				high = arr[i];
			}
			if(low > arr[i])
			{
				low = arr[i];
			}
		}
		return high - low;
	}

	public static double mean(int[] arr, int numItems)
	{
		double total = 0;
		for(int i = 0; i < numItems; i++)
		{
			total += arr[i];
		}
		return total/numItems; 
	}


}
