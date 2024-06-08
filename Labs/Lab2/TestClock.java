import java.util.*;

public class TestClock
{

	public static void main(String[] args)
	{
		int hours, minutes, seconds;
		
		Clock dvr = new Clock();
		System.out.println(dvr);

		Scanner stdin = new Scanner(System.in);
		System.out.println("\nWhat time would you like to set your DVR to?\n\n");
		System.out.println("Hours: ");
		hours = stdin.nextInt();
		//System.out.println(hours);

		System.out.println("Minutes: ");
		minutes = stdin.nextInt();
		//System.out.println(minutes);

		System.out.println("Seconds: ");
		seconds = stdin.nextInt();
		//System.out.println(seconds);

		System.out.println(dvr);
		
		dvr.reset();
		System.out.println(dvr);
		
		dvr.reset(hours, minutes, seconds);
		System.out.println(dvr);

		
		System.out.println("The time is now: " + dvr);
		System.out.println("\n\nAdvancing the time!\n\n");
		dvr.advance();
		System.out.println("The time is now: " + dvr);

	}
}
