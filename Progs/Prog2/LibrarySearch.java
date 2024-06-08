import java.util.*;

public class LibrarySearch 
{
	
	static Scanner stdin = new Scanner(System.in);
	static String input = "0";
	static int counter = 0;
	
	public static void libraryDisplay()
	{
		
		
		System.out.print("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n"
				+ "            THE GREAT BOOKS SEARCH PROGRAM\n"
				+ "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n"
				+ "1)  Display all book records\n"
				+ "2)  Search for a book by Title\n"
				+ "3)  Exit Search Program\n"
				+ "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n"
				+ "Please Enter Your Choice > ");
		try 
		{
			if(input == null)
				input = stdin.nextLine();
			input = stdin.nextLine();
			input.trim();
			int i = Integer.parseInt(input);
		
		
			switch(i) 
			{
				case 1:
					LibraryRun.clearScreen();
					bookRecords();
				case 2:
					searchEngine();
				case 3:
					System.out.println("\n\nGoodbye. Have a nice day. :-)");
					System.exit(2);	
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("\nYou have made an error. Please try again.");
			System.out.print("\nPlease Hit Return to Continue...");
			if(stdin.hasNextLine())
			{
				input = null;
				LibraryRun.clearScreen();
				libraryDisplay();
			}
		}
	}
	
	
	
	private static void bookRecords()
	{
		if(counter > LibraryRun.sorted.size()-1)
			counter = 0;
		int count = counter+1;
		LibraryBook book = LibraryRun.sorted.get(counter);
		
		System.out.print("Record #" + count + " :\n");

		System.out.print("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
		
		System.out.println("Title : " + book.getTitle().trim());
		
		System.out.printf("Author's Name : " + book.getAuthor().trim() + "\n");
		
		System.out.print("Copyright : " + book.getCopyright() + "\n");
		
		System.out.print("Price : " + book.getPrice() + "\n");
		
		System.out.print("Genre : " + genreConvert(book.getGenre().trim()) + "\n");
		
		System.out.print("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		
		System.out.print("\n\nPlease Hit Return to Continue or M for Menu...");
		
		if(stdin.nextLine().equals("m"))
		{
			input = "0";
			LibraryRun.clearScreen();
			libraryDisplay();
		}
		else 
		{
			counter++;
			LibraryRun.clearScreen();
			bookRecords();
		}	
	}
	
	
	public static void searchEngine() 
	{
		System.out.print("\nSearch Title > ");
		String stringIn = stdin.nextLine();
		int searchResult = binarySearch(LibraryRun.sorted, stringIn);
		
		
		if(searchResult != 1)
		{
			int count = searchResult + 1;
			
			try 
			{
				LibraryBook book = LibraryRun.sorted.get(searchResult);
				LibraryRun.clearScreen();
				
				System.out.print("Book Found in Alphabetized List in :\n\n");
				
				System.out.print("Record #" + count + " :\n");

				System.out.print("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
				
				System.out.println("Title : " + book.getTitle().trim());
				
				System.out.printf("Author's Name : " + book.getAuthor().trim() + "\n");
				
				System.out.print("Copyright : " + book.getCopyright() + "\n");
				
				System.out.print("Price : " + book.getPrice() + "\n");
				
				System.out.print("Genre : " + genreConvert(book.getGenre().trim()) + "\n");
				
				System.out.print("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				
				System.out.print("\n\nPlease Hit Return to Continue...");
				
				if(stdin.hasNextLine())
				{
					input = null;
					LibraryRun.clearScreen();
					libraryDisplay();
				}
			}
			catch (IndexOutOfBoundsException e)
			{
				System.out.print("\n\nSorry the book was not found");
				System.out.print("\nPlease Hit Return to Continue...");
				if(stdin.hasNextLine())
				{
					input = null;
					LibraryRun.clearScreen();
					libraryDisplay();
				}
			}
		}
	}
	
	
	private static int first = 0, last, middle, location;
	private static boolean found = false;
	private static int binarySearch(ArrayList<LibraryBook> arr, Object key)
	{
		last = arr.size();
		
		String searchWord = (String) key;
		
		do
		{
			middle = (first + last) / 2;
			if(searchWord.compareToIgnoreCase(arr.get(middle).getTitle().trim()) == 0)
				found = true;
			else if(searchWord.compareToIgnoreCase(arr.get(middle).getTitle().trim()) < 0)
				last = middle - 1;
			else
				first = middle + 1;
		
		}
		while((!found) && (first <= last));
		location = middle;
	
		return (found ? location : -1);
	}
	
	private static String genreConvert(String bookGenre)
	{
		switch(bookGenre)
		{
			case "f":
				return "Fiction";
			case "n":
				return "Non-Fiction";
			case "d":
				return "Drama";
			case "p":
				return "Poetry";
		}
		return null;
	}
	
	
		
}

