import java.io.*;
import java.util.ArrayList;
public class ObjIn
{
	@SuppressWarnings("unchecked")
	public static void ImportObject(ArrayList<Employee> a)
	{
		String fileName = "object.out";
		try 
		{
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			a = (ArrayList<Employee>) in.readObject();
			in.close();
		}
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		for (int i = 0;  i < a.size();  i++)
			System.out.println(a.get(i));
		Execute.employees = (ArrayList<Employee>) a.clone();
    }
}
