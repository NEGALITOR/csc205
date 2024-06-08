public class TestEmployee
{
	public static void main(String[] args)
	{
		Date birthDate = new Date(1980,4,8);
		Date hireDate = new Date();

		Employee morrisBrown = new Employee("Brown", "Morris", birthDate, 40000, hireDate);

		System.out.println(morrisBrown.toString());
	}
}
