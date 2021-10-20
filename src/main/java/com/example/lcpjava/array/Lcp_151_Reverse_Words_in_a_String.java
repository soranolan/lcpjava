package com.example.lcpjava.array;

public class Lcp_151_Reverse_Words_in_a_String {
	
	/**
	 * time  : O(m * n)
	 * space : O(l)
	 * 
	 * StringBuilder sb <- empty StringBuilder
	 * String[] splitted <- string split with space
	 * 
	 * for int i <- splitted length minus one; if i is greatet than or equal to zero; i--
	 * 		if splitted[i] length is not equal to zero
	 * 			sb append space
	 * 			sb append splitted[i]
	 * 		end if
	 * end for
	 * 
	 * return sb to string replace first space with empty
	 * */
	public String reverseWords_1(String s) {
		StringBuilder sb = new StringBuilder();																		// S : O(l)
		String[] splitted = s.split(" ");																			// T : O(m * n)
		
		for (int i = splitted.length - 1; i >= 0; i--) {															// T : O(l)
			if (splitted[i].length() != 0) {
				sb.append(" ");																						// T : O(1)
				sb.append(splitted[i]);																				// T : O(1)
			}
		}
		
		return sb.toString().replaceFirst(" ", "");																	// T : O(1); S : O(l)
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * char[] c <- string to char array
	 * int length <- c length
	 * char[] result <- new char[length plus one]
	 * int index <- 0
	 * 
	 * for int i <- length minus one; if i is greater than or equal to zero; i--
	 * 		if c[i] is equal to space
	 * 			continue
	 * 		end if
	 * 		
	 * 		int right <- i
	 * 		while i is greater than or equal to zero && c[i] is not equal to space
	 * 			i--
	 * 		end while
	 * 		
	 * 		for int left <- i + 1; if left is lower than or equal to right; left++
	 * 			result[index] <- c[left]
	 * 			index++
	 * 		end for
	 * 		
	 * 		result[index] <- space
	 * 		index++
	 * end for
	 * 
	 * return new String(result, zero, index minus one)
	 * */
	public String reverseWords(String s) {
		char[] c = s.toCharArray();
		int length = c.length;
		char[] result = new char[length + 1];																		// S : O(n)
		int index = 0;
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			if (c[i] == ' ') { continue; }
			
			int right = i;
			while (i >= 0 && c[i] != ' ') { i--; }
			
			for (int left = i + 1; left <= right; left++) {
				result[index] = c[left];
				index++;
			}
			
			result[index] = ' ';
			index++;
		}
		
		return new String(result, 0, index - 1);
	}
	
	public static void main(String[] args) {
		Lcp_151_Reverse_Words_in_a_String lcp = new Lcp_151_Reverse_Words_in_a_String();
		String input = null;
		String output = null;
		
		// "blue is sky the"
		input = "the sky is blue";
		output = lcp.reverseWords(input);
		System.out.println(output);
		
		// "world hello"
		input = "  hello world  ";
		output = lcp.reverseWords(input);
		System.out.println(output);
		
		// "example good a"
		input = "a good   example";
		output = lcp.reverseWords(input);
		System.out.println(output);
		
		// "Alice Loves Bob"
		input = "  Bob    Loves  Alice   ";
		output = lcp.reverseWords(input);
		System.out.println(output);
		
		// "bob like even not does Alice"
		input = "Alice does not even like bob";
		output = lcp.reverseWords(input);
		System.out.println(output);
	}
	
}
