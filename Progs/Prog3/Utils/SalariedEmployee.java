import java.io.Serializable;

@SuppressWarnings("serial")
public class SalariedEmployee extends Employee implements Serializable
{
	double salary;
	
	public SalariedEmployee(String name,  double salary)
	{
		super(name, (salary/52)/40);
		this.salary = this.wage*52*40;
	}

	@Override
	public double computePay(int hours) 
	{
		return salary/52;
	}
	
	@Override
	public String toString()
	{
		this.salary = this.wage*52*40;
		String strWage = Utilities.toDollars(salary);
		
		int length = 40 - strWage.length();
		String strName = Utilities.pad(name, length);
		String str = strName + strWage + "/year";
		
		return str;		
	}

}
