class mySums
{
  public static void main(String[] args)
	{
	  System.out.println(recurSum(4));
	  System.out.println(mySumI(4));
	}
 
  static double recurSum(int n)
  {
    if(n < 1)
    {
      return 0;
    }
    else
    {
      return recurSum(n-1) + (Math.pow(2,n) + 1);
      
    }
  }
 
 static double mySumI(int n)
  {
    double sum = 0;
    
    while (n > 0)
    {
      sum = sum + (Math.pow(2,n) + 1);
      n--;
    }
    
    return sum;
  }
 
 
}
