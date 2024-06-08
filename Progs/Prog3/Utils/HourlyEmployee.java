import java.io.Serializable;

@SuppressWarnings("serial")
public class HourlyEmployee extends Employee implements Serializable
{

	public HourlyEmployee(String name, double wage) 
	{
		super(name, wage);
	}

	@Override
	public double computePay(int hours) 
	{
		double pay = 0;
		
		if(hours < 0)
		{
			System.out.println("Cannot work");
		}
		else if(hours <= 40)
		{
			pay = this.wage * hours;
		}
		else if(hours > 40)
		{
			pay = (this.wage * 40) + (this.wage * (hours - 40)* 1.5);
		}
		
		return pay;
	}
	
	@Override
	public String toString() 
	{
		String strWage = Utilities.toDollars(this.wage);
		
		int length = 40 - strWage.length();
		String strName = Utilities.pad(name, length);
		String str = strName + strWage + "/hour";
		
		return str;
	}


}
