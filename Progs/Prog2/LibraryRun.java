import java.io.*;
import java.util.*;

public class LibraryRun 
{
	public static ArrayList<LibraryBook> sorted;
	public static void main(String[] args)
	{
		LibraryInput.inputToLibrary();
		
		sorted = LibrarySort.selectionSort(LibraryInput.books);
		
		if(LibraryInput.passed)
			LibrarySearch.libraryDisplay();
		
		
		
	}

	public static void clearScreen()
	{
		System.out.println("\u001b[H\u001b[2J");
	}

}

