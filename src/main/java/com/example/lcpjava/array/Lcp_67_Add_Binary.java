package com.example.lcpjava.array;

public class Lcp_67_Add_Binary {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int lengthA <- a length
	 * int lengthB <- b length
	 * int carry <- 0
	 * StringBuilder sb <- empty StringBuilder
	 * 
	 * while lengthA is greater than zero || lengthB is greater than zero
	 * 		int sum <- carry;
	 * 		if lengthA is greater than zero
	 * 			sum <- sum plus a charAt(lengthA minus one) minus '0'
	 * 			lengthA--
	 * 		end if
	 * 		
	 * 		if lengthB is greater than zero
	 * 			sum <- sum plus b charAt(lengthB minus one) minus '0'
	 * 			lengthB--
	 * 		end if
	 * 		
	 * 		sb append sum mod two
	 * 		carry <- sum divide two
	 * end while
	 * 
	 * if carry is greater than zero
	 * 		sb append carry
	 * end if
	 * 
	 * return sb reverse then convert to string
	 * */
	public String addBinary(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		
		while (lengthA > 0 || lengthB > 0) {																		// T : O(n)
			int sum = carry;
			
			if (lengthA > 0) {
				sum += a.charAt(lengthA - 1) - '0';																	// T : O(1)
				lengthA--;
			}
			
			if (lengthB > 0) {
				sum += b.charAt(lengthB - 1) - '0';																	// T : O(1)
				lengthB--;
			}
			
			sb.append(sum % 2);																						// T : O(1); S : O(n)
			carry = sum / 2;
		}
		
		if (carry != 0) { sb.append(carry); }																		// T : O(1)
		
		return sb.reverse().toString();																				// T : O(n)
	}
	
}
