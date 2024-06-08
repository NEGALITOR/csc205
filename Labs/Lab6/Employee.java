public class Employee extends Person
{
	private double salary;
	private Date employmentDate;

	public Employee(String lName, String fName, Date bDate, double sal, Date eDate)
	{
		super(lName, fName, bDate);
		salary = sal;
		employmentDate = eDate;
	}

	public String toString()
	{
		return "name = " + super.getLastName() + ", " 
			+ super.getFirstName() + "\nsalary = " + salary 
			+ "\nbirth = " + super.getBirthDate() + "\nhired = " 
			+ employmentDate;	
	}
	

}
