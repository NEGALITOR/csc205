class blowUp
{
	static int count = 0;
	public static void main(String[] args)
	{

		if(count < 0)
		{
			System.out.println("idk");
		}
		else
		{
			count++;
			System.out.println(count);
			main(args);
		}

	}		
}
