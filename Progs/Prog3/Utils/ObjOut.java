import java.io.*;
import java.util.ArrayList;
public class ObjOut
{
	public static void ExportObject(ArrayList<Employee> a)
	{
		String fileName = "object.out";
		try 
		{
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(a);
			out.close();
		}
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
