import java.util.*;

public class LibrarySort 
{
	public static ArrayList<LibraryBook> selectionSort(ArrayList<LibraryBook> bookList)
	{
		int minIndex, i, j;
		int numBooks = bookList.size();
		LibraryBook temp;
		
		for( i = 0; i < numBooks - 2; i++)
		{
			minIndex = i;
			for( j = i; j < numBooks; j++)
			{
				
				
				if(bookList.get(j).getTitle().compareToIgnoreCase(bookList.get(minIndex).getTitle()) < 0)
				{
					minIndex = j;
				}
				
				
			}	
			
			if(minIndex != i) 
			{
				temp = bookList.get(i);
				bookList.set(i, bookList.get(minIndex));
				bookList.set(minIndex, temp);	
			}
			
			
		}
		return bookList;
	}
}

