import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Employee implements Serializable
{
	
	String name;
	double wage;
	
	public Employee(String name, double wage) 
	{
		this.name = name;
		this.wage = wage;
	}

	public abstract double computePay(int hours);
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public double getHourlyWage()
	{
		return wage;
	}
	
	public void setHourlyPay(double wage)
	{
		this.wage = wage;
	}
	
	public void raiseWage(double percent) 
	{
		this.wage = (percent*this.wage/100) + this.wage;
	}
	
}
