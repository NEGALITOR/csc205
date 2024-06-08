import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class LibraryInput 
{
	
	public static ArrayList<LibraryBook> books =  new ArrayList<LibraryBook>();
	public static boolean passed = false;
	
	public static void inputToLibrary()
	{	
		String bt = "";
		String an = "";
		int cp = 0;
		double bp = 0;
		String ng = "";
		
		LibraryRun.clearScreen();
		Scanner stdin = new Scanner(System.in);
		
		
		System.out.println("                    THE BOOK SEARCH PROGRAM\n----------------------------------------------------------------\n");
		System.out.println("     What file is your book data stored in?\n");
		
		while(!passed)
		{
			try 
			{
				findFilesWithType();
			}
			catch(IOException e)
			{
				System.out.println("** Can\'t open input file.  Try again. **");
			}
			
			String fileName =  stdin.nextLine();
			Path path = Paths.get(fileName);
			
			
			try
			{
				Scanner fStdin = new Scanner(new File(fileName)).useDelimiter(";");
				
				int lines = 0;
				
				try 
				{
					lines = (int) Files.lines(path).count();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				
				while(books.size() < lines)
				{
					bt = fStdin.next();
					an = fStdin.next();
					cp = fStdin.nextInt();
					bp = fStdin.nextDouble();
					ng = fStdin.next();
					
					LibraryBook book = new LibraryBook(bt, an, cp, bp, ng);
					
					books.add(book);
				}
	
				
	            passed = true;
					
			}
			catch(FileNotFoundException e)
			{
				passed = false;
				System.out.println("\n** Can\'t open input file.  Try again. **\n");
				
			}
		}

		if(passed)
		{
			System.out.println("\nA total of " + books.size() + " books have been input & sorted by title.");
			
			
			System.out.println("\nPlease hit Return to coninue...");
			if(stdin.hasNextLine())
			{
				LibraryRun.clearScreen();
			}
		}
		
		
		
	}
	
	public static void findFilesWithType() throws IOException
	{
		Runtime rt = Runtime.getRuntime();
		String[] commands = {"/bin/bash", "-c", "find . -type f -name \"*.dat\""};
		Process proc = rt.exec(commands);

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		System.out.println("     Here are the files in the current directory : \n");

		String s = null;
		while ((s = stdInput.readLine()) != null) 
		{
			s = s.replaceAll("[^a-zA-Z0-9.]", ""); 
			s = s.replaceFirst(".", "");
			System.out.print(s + " ");
		}
			
		System.out.println();
		System.out.print("\n     Filename : ");
	}
	
	
}

