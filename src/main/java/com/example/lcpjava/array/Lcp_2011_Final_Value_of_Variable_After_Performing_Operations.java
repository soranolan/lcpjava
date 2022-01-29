package com.example.lcpjava.array;

public class Lcp_2011_Final_Value_of_Variable_After_Performing_Operations {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int sum <- 0
	 * 
	 * for String operation in operations
	 * 		char c <- operation charAt(1)
	 * 		
	 * 		if c is equal to '+'
	 * 			sum++
	 * 		else
	 * 			sum--
	 * 		end if
	 * end for
	 * 
	 * return sum
	 * */
	public int finalValueAfterOperations(String[] operations) {
		int sum = 0;
		
		for (String operation : operations) {																		// T : O(n)
			char c = operation.charAt(1);																			// T : O(1)
			
			if (c == '+') {
				sum++;
			} else {
				sum--;
			}
		}
		
		return sum;
	}
	
}
