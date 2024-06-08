public class Clock {
	
	private int hours, minutes, seconds;

	public Clock(int hrIn, int minIn, int secIn)
	{
		hours = hrIn;
		minutes = minIn;
		seconds = secIn;
	}

	public Clock()
	{
		hours = 0;
		minutes = 0;
		seconds = 0;
	}

	public void reset()
	{
		hours = 0;
                minutes = 0;
                seconds = 0;
	}

	public void reset(int hrIn, int minIn, int secIn)
	{
		hours = hrIn;
		minutes = minIn;
		seconds = secIn;
	}

	public void advance()
	{
		seconds++;
		if(seconds > 59)
		{
			minutes++;
			seconds = 0;
		}
		if(minutes > 59)
		{
			hours++;
			minutes = 0;
		}
		if(hours > 23)
		{
			hours = 0;
		}
	}

	public String toString()
	{
		String hr = hours + ":";
		String min = minutes + ":";
		String sec = seconds + "";
		String time = "";

		if(seconds < 10)
		{
			sec =  "0" + seconds;
		}
		
		if(minutes < 10)
		{
			min = "0" + minutes + ":";
		}

		if(hours < 10)
		{
			hr = "0" + hours + ":";
		}

		time = hr + min + sec;


		return time;
	}

}
