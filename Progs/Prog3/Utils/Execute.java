import java.util.*;

public class Execute
{
	static ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public static void main(String[] args)
	{
		menuConstruct();
		
		
	}
	
	static void menuConstruct()
	{
		Print.clearScreen();
		Print.Line(35, (char) 45);
		System.out.println("|Commands: n - New employee       |");
		System.out.println("|          c - Compute paychecks  |");
		System.out.println("|          r - Raise wages        |");
		System.out.println("|          p - Print records      |");
		System.out.println("|          u - Upload data        |");
		System.out.println("|          d - Download data      |");
		System.out.println("|          q - Quit               |");
		Print.Line(35, (char) 45);
		System.out.print("Enter command: ");
		menuAnalyzer();
	}
	
	static void menuAnalyzer()
	{
		Scanner stdin = new Scanner(System.in);
		String input = stdin.nextLine().toLowerCase().trim();
		switch(input)
		{
			case "q":
				System.exit(0);
			case "n":
				System.out.print("Enter the name of new employee: ");
				String name = stdin.nextLine();
				while(name.trim() == "")
				{
					System.out.print("Name Invalid!\n\nEnter the name of new employee: ");
					name = stdin.nextLine();
				}
				
				System.out.print("Hourly (h) or salaried (s): ");
				String type = stdin.nextLine().toLowerCase().trim();
				double wage = 0;
				
				/*if(type == "h") 
				{
					System.out.println("Enter hourly wage: ");
					wage = stdin.nextDouble();
					employees.add(new HourlyEmployee(name, wage));
				}
				else if(type == "s")
				{
					System.out.println("Enter annual salary: ");
					wage = stdin.nextDouble();
					employees.add(new SalariedEmployee(name, wage));
				}*/
				boolean loop = true;
				boolean repeat = true;
				while (loop)
				{
					switch(type)
					{
						case "h":
							
							while(repeat)
							{
								repeat = false;
								try 
								{
									System.out.print("Enter hourly wage: ");
									wage = stdin.nextDouble();
								}
								catch(InputMismatchException e)
								{
									System.out.println("Name Invalid!");
									stdin.nextLine();
									repeat = true;
								}
							}
							stdin.nextLine();
							employees.add(new HourlyEmployee(name, wage));
							menuConstruct();
					
					
							
						case "s":
							
							while(repeat)
							{
								repeat = false;
								try 
								{
									System.out.print("Enter annual salary: ");
									wage = stdin.nextDouble();
									
								}
								catch(InputMismatchException e)
								{
									System.out.println("Name Invalid!");
									stdin.nextLine();
									repeat = true;
								}
							}
							
							
							stdin.nextLine();
							employees.add(new SalariedEmployee(name, wage));
							menuConstruct();
							
						default:
							System.out.println("Input was not h or s; please try again.");
							System.out.println("\nHourly (h) or salaried (s): ");
							type = stdin.nextLine().toLowerCase().trim();
					}
				
				}
				
				
			case "c":						
				for(int i = 0; i < employees.size(); i++)
				{
					System.out.print("Enter number of hours worked by " + employees.get(i).getName() + ": ");
					int hours = stdin.nextInt();
					stdin.nextLine();
					System.out.println("Pay: " + Utilities.toDollars(employees.get(i).computePay(hours)));
					
				}
				System.out.println("\nPress Enter to Continue...");
				stdin.nextLine();
				menuConstruct();
				
			case "r":
				System.out.print("Enter percentage increase: ");
				double p = stdin.nextDouble();
				stdin.nextLine();
				
				for(int i = 0; i < employees.size(); i++)
				{
					employees.get(i).wage = ((p * employees.get(i).wage) / 100) + employees.get(i).wage;
				}
				
				System.out.println("\nNew Wages\n------------");
				print();
				System.out.println("\nPress Enter to Continue...");
				stdin.nextLine();
				menuConstruct();
				
			case "p": 
				System.out.println("\nRecords\n---------");
				print();
				System.out.println("\nPress Enter to Continue...");
				stdin.nextLine();
				menuConstruct();
				
			case "d":
				ObjOut.ExportObject(employees);
				System.out.println("Completed! Press Enter to Continue...");
				stdin.nextLine();
				menuConstruct();
				
				
			case "u":
				ObjIn.ImportObject(employees);
				System.out.println("Completed! Press Enter to Continue...");
				stdin.nextLine();
				menuConstruct();
				
				
			default:
				System.out.println("Command was not recognized; please try again...");
				stdin.nextLine();
				menuConstruct();
				
		}
		
	}
	
	static void print() 
	{
		for(int i = 0; i < employees.size(); i++)
		{   
		    System.out.println(employees.get(i).toString());
		}  
	}
	
	
	
}