import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
class TestClass {
    
    public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0)
		{
			int n = Integer.parseInt(br.readLine().trim());
			long[] price = new long[n];
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for(int i=0;i<n;i++)
				price[i]=Long.parseLong(st.nextToken());
			Arrays.sort(price);
			long totalCost = 0;
			while(n > 3)
			{
				long cost_first = price[0] + 2 * price[1] + price[n-1];
				long cost_second = 2 * price[0] + price[n-2] + price[n-1];
				totalCost = totalCost + Math.min(cost_first,cost_second);
				n = n - 2;
			}
			if(n==3)
				totalCost = totalCost + add(price,3);
			else if(n==2)
				totalCost = totalCost + price[1];
			else
				totalCost = totalCost + price[0];
			System.out.println(totalCost);
		}
	}
	
	public static long add(long[] price,int k)
	{
		long sum = 0;
		for(int i=0;i<k;i++)
		{
			sum = sum + price[i];
		}
		return sum;
	}
}