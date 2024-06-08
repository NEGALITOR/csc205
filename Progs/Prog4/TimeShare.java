import java.util.*;
import java.io.*;
import java.awt.*;

public class TimeShare {
	public static void main(String[] args) throws CloneNotSupportedException
	{
		//String[] arr = new String[] {"C:/Users/tahat/Desktop/jobs1.dat"};
		
		Queue queue = new Queue();
		readFile(args, queue);
		
		if(!queue.isEmpty())
		{
            menuConstruct();
            jobsCheck(queue);
        }
		
	}
	
	public static void menuConstruct()
	{
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println();
		System.out.println("     Job Control Analysis: Summary Report\n");
		System.out.println("job id arrival start   run     wait    turnaround\n" +
		        		   "        time    time    time    time    time      \n" +
		        		   "------ ------ -----   ----    ----    ----------\n" );
	}
	
	public static void readFile(String[] inputFile, Queue queueIn) 
	{
		String jobName = "";
		int arrivalTime = 0;
		int runTime = 0;
		
		if (inputFile.length < 1) 
		{
		    System.out.println("Invalid files. Please try again...");
		} 
		else 
		{
		    try 
		    {
		        for (int i = 0; i < inputFile.length; i++) 
		        {
		            String inputFileName = inputFile[i];
		            
		            Scanner stdin = new Scanner(new File(inputFileName));
		            
		            while (stdin.hasNext()) 
		            {
		                Scanner dStdin = new Scanner(stdin.nextLine()).useDelimiter("\t");
		                jobName = dStdin.next();
		                arrivalTime = dStdin.nextInt();
		                runTime = dStdin.nextInt();
		
		                queueIn.enqueue(new Job(jobName, arrivalTime, runTime));
		            }
		        }
		    } 
		    catch (IOException e) 
		    { 
		        System.out.println(e.getMessage());
		    }
		}
	}
	
	public static void jobsCheck(Queue queueIn){

        int clockTime = -1;
        int waitTime = 0;
        int turnTime = 0;
        int idleTime = 0;
        int count = 0;
        int jobCount = 0;
        int cpuUsageTime = 0;

        while(!queueIn.isEmpty())
        {
            Job job = ((Job)queueIn.front());

            if(job.startTime == -1 && clockTime == -1)
            {
                job.startTime = 1;
                clockTime = 1;
                waitTime = 0;
                turnTime = job.runTime + waitTime;
                job.turnTime = turnTime;
                
                while( count < job.runTime)
                {
                    clockTime += 1;
                    cpuUsageTime +=1;
                    count ++;
                }
                
                count = 0;
                System.out.println(queueIn.dequeue());
                jobCount += 1;
                
            }
            else
            {
                if(clockTime < job.arrivalTime)
                {
                    while(clockTime < job.arrivalTime)
                    {
                        clockTime += 1;
                        idleTime += 1;
                    }
                    
                }
                else
                {
                    job.startTime = clockTime;
                    job.waitTime = job.startTime - job.arrivalTime;
                    waitTime += job.waitTime;
                    turnTime = job.runTime + job.waitTime;
                    job.turnTime = turnTime;
                    
                    while(count < job.runTime)
                    {
                        clockTime += 1;
                        cpuUsageTime +=1;
                        count++;
                    }

                    count = 0;
                    System.out.println(queueIn.dequeue());
                    jobCount += 1;
                }
            }
        }

        System.out.printf("\n     Average Wait Time => %.2f\n", (double)waitTime/jobCount);
        System.out.printf("             CPU Usage => %.2f\n", (double)cpuUsageTime);
        System.out.printf("              CPU Idle => %.2f\n", (double)idleTime);
        System.out.printf("         CPU Usage (%s) => %.2f%s\n", "%", (double)((double)cpuUsageTime/(cpuUsageTime + idleTime) * 100),"%");
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println();
    }


	
}
