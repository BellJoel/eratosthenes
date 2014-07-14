package euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class P50 {

	public static void main(String[] args) {
		List<Long> primes = eSieve(1000000);
		
		Long max = 1L;
		
		for( int i = 0; i < primes.size(); i++ )
		{
			Long sum = primes.get(i);
			for( int j = i+1; j < primes.size(); j++)
			{
				sum += primes.get(j);
				
				if( sum > 1000000 )
					break;
				
				if( !primes.contains(sum) )
				{
					continue;
				}					
				
				if( j-i+1 > max )
				{
					max = j-i+1L;
					System.out.println("New Max: " + max + "; " + sum);
				}
			}
		}			
	}
	
	public static List<Long> eSieve(int n) {
		Boolean[] isPrime = new Boolean[n+1];
		
		for( int i = 2; i <= n; i++ )
			isPrime[i] = true;
		
		for( int i = 2; i*i <= n; i++ )
		{
			if(isPrime[i])
			{
				for( int j = i; i*j <= n; j++)
				{
					isPrime[i*j] = false;
				}
			}
		}
				
		List<Long> primes = new ArrayList<Long>();
		for( int i = 2; i <= n; i++ )
		{
			if( isPrime[i] )
				primes.add(new Long(i));
		}
		
		return primes;
	}
}
