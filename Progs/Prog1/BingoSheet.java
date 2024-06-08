import java.util.*;
import java.io.*;

public class BingoSheet {
	
	int[][] sheet;
	String[][] stringSheet;
	
	BitSet checkBit = new BitSet(75);
	int[] numAlreadyUsed = new int[75];

	
	boolean hBingoWin = false;
	boolean vBingoWin = false;
	boolean dBingoWin = false;
	int counter = 0;
	
	//Bingo Sheet Constructor
	public BingoSheet() throws FileNotFoundException
	{
		sheet = new int[5][5];
		stringSheet = new String[5][5];
		fillCard();
	}
	
	
	//Starts Game
	public void playGame()
	{
		String win = "";
		System.out.println("Your Bingo Card: \n");
		printCard(sheet);
		
		boolean result = false;
		int intChosen = 0;
		
		while(result == false)
		{
			intChosen = numSelector();
			result = checkForWin();
			numAlreadyUsed[counter] = intChosen;
			counter++;
			
		}
		numCalled();
		intToString();
		
		if(hBingoWin)
			win = "Horizontal";
		else if(vBingoWin)
			win = "Vertical";
		else if(dBingoWin)
			win = "Diagonal";
		
		System.out.println("\nYou win with a " + win + " bingo after " + counter + " picks!\n");
		System.out.println("YOUR BINGO CARD : \n");
		printCard(stringSheet);
	}
	
	
	//Fills Card
	public int[][] fillCard() throws FileNotFoundException
	{
		Scanner stdin = new Scanner(new File("bingo.in"));
		
		for(int i = 0; i < sheet.length && stdin.hasNextInt(); i++)
		{
			for(int j = 0; j < sheet.length && stdin.hasNextInt(); j++)
			{
				sheet[i][j] = stdin.nextInt();
			}
		}
		return sheet;
	}
	
	
	//Checks If a Row, Column, or Diagonal Sum Equals 0
	public boolean checkForWin()
	{
		int h = 0;
		int v = 0;
		int hSum = 1;
		int vSum = 1;
		int dSumOne = 1;
		int dSumTwo = 1;
		
		while((hSum != 0) && (h < sheet.length))
		{
			hSum = rowSum(h);
			h++;
		}
		
		if(hSum == 0)
			hBingoWin = true;
		
		
		while((vSum != 0) && (v < sheet[0].length))
		{
			vSum = colSum(v);
			v++;
		}
		
		if(vSum == 0)
			vBingoWin = true;
		
		
		diagOneSum();
		diagTwoSum();
		
		if((dSumOne == 0) || (dSumTwo == 0))
			dBingoWin = true;
		
		if ((hBingoWin == true) || (vBingoWin == true) || (dBingoWin == true))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	//All Summation Methods
	public int rowSum(int i)
	{
		int hSum = 0;
		for(int j = 0; j < sheet[0].length; j++)
		{
			hSum += sheet[i][j];
		}
		return hSum;
	}
	
	
	
	public int colSum(int j)
	{
		int vSum = 0;
		for(int i = 0; i < sheet.length; i++)
		{
			vSum += sheet[i][j];
		}
		return vSum;
	}
	
	
	
	public int diagOneSum()
	{
		int dSumOne = 0;
		for (int i = 0; i < sheet.length; i++)
  		 {
			dSumOne += sheet[i][i];
  		 }
		return dSumOne;
	}
	
	
	
	public int diagTwoSum()
	{
		int dSumTwo = 0;
		for  (int i = 0; i < sheet.length; i++)
        {
			dSumTwo += sheet[i][sheet.length-i-1];
   		}
		return dSumTwo;
	}
	
	
	//Selects a Random Number
	public int numSelector()
	{
		int randomInt = (int) Math.round((Math.random() * 74 + 1));
		while(checkBit.get(randomInt) == true)
		{
			randomInt = (int) Math.round((Math.random() * 74 + 1));
		}
		checkBit.set(randomInt);
		
		
		for(int i = 0; i < sheet.length; i++)
		{
			for (int j = 0; j < sheet[0].length; j++)
			{
				if(sheet[i][j] == randomInt)
					sheet[i][j] = 0;
			}
		}
		return randomInt;
	}
	
	
	//Print out that random number and goes back to next line after 9 selections
	public void numCalled()
	{
		System.out.println("Bingo Numbers Picked At Random From Bin :");
		int j = 0;
		
		for(int i = 0; i < counter; i++)
		{
			if((j%9 != 0) || (j == 0))
			{
				System.out.printf("%8d", numAlreadyUsed[i]);
				
			}
			else
			{
				System.out.printf("\n%8d", numAlreadyUsed[i]);
				
			}
			j++;
		}
	}
	
	
	//Convert int Values from Array to Strings
	public String[][] intToString()
	{
		for(int i = 0; i < sheet.length; i++)
		{
			for(int j = 0; j < sheet[0].length; j++)
			{
				Integer num = sheet[i][j];
				stringSheet[i][j] = num.toString();
				if(stringSheet[i][j].compareTo("0") == 0)
				{
					stringSheet[i][j] = "X";
				}
			}
		}
		return stringSheet;
	}
	

	//Print Bingo Sheet Methods For Both int and String	
	public void printCard(int[][] intSheet)
	{
		int x = 0;
		System.out.println("   B    I    N    G    O  ");
		System.out.println("--------------------------");
		
		
		for (int i = 0; i < intSheet.length; i++) 
		{
			for (int j = 0; j < intSheet[i].length; j++) 
	        {
				if((x % 5 != 0) || (x ==0))
				{
					System.out.printf("|%3d ", intSheet[i][j]);
				}
				else
				{
					System.out.print("|\n--------------------------");
					System.out.printf("\n|%3d ", intSheet[i][j]);
				}
				x++;
	        }
			
	    }
		System.out.println("|");
		System.out.print("--------------------------\n\n");
		
	}
	
	public void printCard(String[][] stringSheet)
	{
		int x = 0;
		System.out.println("   B    I    N    G    O  ");
		System.out.println("--------------------------");
		
		
		for (int i = 0; i < stringSheet.length; i++) 
		{
			for (int j = 0; j < stringSheet[i].length; j++) 
	        {
				if((x % 5 != 0) || (x ==0))
				{
					System.out.printf("|%3s ", stringSheet[i][j]);
				}
				else
				{
					System.out.print("|\n--------------------------");
					System.out.printf("\n|%3s ", stringSheet[i][j]);
				}
				x++;
	        }
			
	    }
		System.out.println("|");
		System.out.print("--------------------------\n");
		
	}
	
}

