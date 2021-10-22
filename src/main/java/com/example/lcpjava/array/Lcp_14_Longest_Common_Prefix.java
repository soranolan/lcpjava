package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_14_Longest_Common_Prefix {
	
	/**
	 * time  : O(n * m * l)
	 * space : O(1)
	 * 
	 * String prefix <- array[0]
	 * 
	 * for int i <- 1; if i is lower than array length; i++
	 * 		while array[i] index of prefix is not equal to zero
	 * 			prefix <- prefix substring from zero to prefix length minus one
	 * 		end while
	 * end for
	 * 
	 * return prefix
	 * */
	public String longestCommonPrefix_1(String[] strs) {
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {																		// T : O(n)
			while (strs[i].indexOf(prefix) != 0) {																	// T : O(m * l)
				prefix = prefix.substring(0, prefix.length() - 1);													// T : O(l)
			}
		}
		return prefix;
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(1)
	 * 
	 * for int i <- 0; if i is lower than array[0] length; i++
	 * 		char c <- array[0] charAt(i)
	 * 		for int j <- 1; if j is lower than array length; j++
	 * 			if i is greater than or equal to array[j] length || c is not equal to array[j] charAt(i)
	 * 				return array[0] substring zero to i
	 * 			end if
	 * 		end for
	 * end for
	 * 
	 * return array[0]
	 * */
	public String longestCommonPrefix_2(String[] strs) {
		String first = strs[0];
		for (int i = 0; i < first.length(); i++) {																	// T : O(m)
			char c = first.charAt(i);
			for (int j = 1; j < strs.length; j++) {																	// T : O(n)
				if (i >= strs[j].length() || c != strs[j].charAt(i)) {
					return first.substring(0, i);																	// T : O(m)
				}
			}
		}
		return first;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * sort array
	 * StringBuilder sb <- empty StringBuilder
	 * char[] first <- array[0] to char array
	 * char[] last <- array[array length minus one] to char array
	 * int i <- 0
	 * 
	 * while i is lower than first length && i is lower than last length
	 * 		if first[i] is equal to last[i]
	 * 			sb append first[i]
	 * 		else
	 * 			return sb to string
	 * 		end if
	 * 		i++
	 * end while
	 * 
	 * return sb to string
	 * */
	public String longestCommonPrefix_3(String[] strs) {
		Arrays.sort(strs);																							// T : O(n log n)
		StringBuilder sb = new StringBuilder();																		// S : O(n)
		char[] first = strs[0].toCharArray();
		char[] last = strs[strs.length - 1].toCharArray();
		int i = 0;
		
		while (i < first.length && i < last.length) {																// T : O(m)
			if (first[i] == last[i]) {
				sb.append(first[i]);																				// T : O(1)
			} else {
				return sb.toString();
			}
			i++;
		}
		
		return sb.toString();
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(n)
	 * 
	 * StringBuilder sb <- empty StringBuilder
	 * String shortest <- array[0]
	 * for string in array
	 * 		if shortest length is greater than string length
	 * 			shortest <- string
	 * 		end if
	 * end for
	 * 
	 * for int i <- 0; if i is lower than shortest length; i++
	 * 		boolean isSame <- false
	 * 		char current <- shortest charAt(i)
	 * 		for string in array
	 * 			if string charAt(i) is not equal to current
	 * 				isSame <- false
	 * 				break
	 * 			end if
	 * 		end for
	 * 		if isSame is true
	 * 			sb append current
	 * 		else
	 * 			break
	 * 		end if
	 * end for
	 * 
	 * return sb to string
	 * */
	public String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder();																		// S : O(n)
		String shortest = strs[0];
		for (String str : strs) {																					// T : O(n)
			if (shortest.length() > str.length()) { shortest = str; }
		}
		
		for (int i = 0; i < shortest.length(); i++) {																// T : O(m)
			boolean isSame = false;
			char current = shortest.charAt(i);
			for (String str : strs) {																				// T : O(n)
				if (str.charAt(i) != current) {
					isSame = false;
					break;
				}
				isSame = true;
			}
			if (isSame) {
				sb.append(current);
			} else {
				break;
			}
		}
		
		return sb.toString();
	}
	
}
