public class Person
{
	private String name;
	private int id;
	private static int personCount = 0;

	// constructor
	public Person()
	{
		this.name = "N/A";
		this.id = -1;
		personCount++;
	}
	
	public Person(String pname)
	{
		name = pname;
		personCount++;
		id = 100 + personCount;
	}

	public String  toString()
	{
		return "name: " + name + "  id: " + id + "  (Person count: " + personCount + ")";
	}

	// static/class method
	public void reset(int pId, String pName)
	{
		id = pId;
		name = pName;
	}
	
	public int getID()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}
	
	public static int getCount()
	{
		return personCount;
	}


  
}
