public class CheckingAccount extends Account
{
	private int numChecks;

	public CheckingAccount(double initBalance)
	{
		super(initBalance);
	}

	int getChecksWritten()
	{
		return numChecks;	
	}

	void writeCheck(double amount)
	{
		numChecks++;
		super.withdraw(amount);
	}

}
