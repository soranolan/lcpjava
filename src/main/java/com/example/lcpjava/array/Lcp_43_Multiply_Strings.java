package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_43_Multiply_Strings {
	
	/**
	 * time  : O(Min(m, n) * (m + n))
	 * space : O(m + n)
	 * 
	 * https://leetcode.com/problems/multiply-strings/discuss/1563536/C%2B%2B-Simple-Solution-w-Explanation-and-Images-or-School-%2B-Optimized-Multiplication
	 * 
	 * 
	 * if num1 is equal to string zero || num2 is equal to string zero
	 * 		return string zero
	 * end if
	 * 
	 * int n1 <- num1 length
	 * int n2 <- num2 length
	 * 
	 * if n1 is lower than n2
	 * 		return multiply(num2, num1)
	 * end if
	 * 
	 * String result <- empty string
	 * int padding <- 0
	 * 
	 * for int i <- n2 minus one; if i is greater than or equal to zero; i--
	 * 		String number <- multiplyDigit(num1, num2 charAt(i), padding)
	 * 		result <- addString(number, result)
	 * 		padding++
	 * end for
	 * 
	 * return result
	 * */
	public String multiply_1(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) { return "0"; }
		
		int n1 = num1.length();																						// m
		int n2 = num2.length();																						// n
		if (n1 < n2) { return multiply_1(num2, num1); }
		
		String result = "";
		int padding = 0;
		
		for (int i = n2 - 1; i >= 0; i--) {																			// T : O(n)
			String number = multiplyDigit(num1, num2.charAt(i), padding++);
			result = addString(number, result);
		}
		
		return result;
	}
	
	/**
	 * StringBuilder sb <- new StringBuilder
	 * 
	 * for int i <- 0; if i is lower than padding; i++
	 * 		sb append("0")
	 * end for
	 * 
	 * int carry <- 0
	 * 
	 * for int i <- num1 length minus one; if i is greater than or equal to zero; i--
	 * 		int sum <- (num1 char to int) times (char2 to int) plus carry
	 * 		carry <- sum divide by ten
	 * 		sb append(sum modulo ten)
	 * end for
	 * 
	 * if carry is not equal to zero
	 * 		sb append(carry)
	 * end if
	 * 
	 * sb reverse
	 * 
	 * return sb to string
	 * */
	public String multiplyDigit(String num1, char char2, int padding) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < padding; i++) {																			// T : O(n)
			sb.append("0");																							// T : O(1)
		}
		
		int carry = 0;
		
		for (int i = num1.length() - 1; i >= 0; i--) {																// T : O(m)
			int sum = (num1.charAt(i) - '0') * (char2 - '0') + carry;
			carry = sum / 10;
			sb.append(sum % 10);																					// T : O(1)
		}
		
		if (carry != 0) { sb.append(carry); }																		// T : O(1)
		
		sb.reverse();																								// T : O(m + 1)
		
		return sb.toString();
	}
	
	/**
	 * int nLength <- number length
	 * int rLength <- result length
	 * 
	 * if nLength is lower than rLength
	 * 		return addString(result, number)
	 * end if
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * int n <- nLength minus one
	 * int r <- rLength minus one
	 * int digit <- 0
	 * int carry <- 0
	 * 
	 * while n is greater than or equal to zero
	 * 		digit <- if r is greater than or equal to zero then result charAt(r) to int else zero
	 * 		int sum <- (number charAt(n) to int) plus digit plus carry
	 * 		carry <- sum divide by ten
	 * 		sb append(sum modulo ten)
	 * 		
	 * 		n--
	 * 		r--
	 * end while
	 * 
	 * if carry is not equal to zero
	 * 		sb append(carry)
	 * end if
	 * 
	 * sb reverse
	 * 
	 * return sb to string
	 * */
	public String addString(String number, String result) {
		int nLength = number.length();
		int rLength = result.length();
		if (nLength < rLength) { return addString(result, number); }
		
		StringBuilder sb = new StringBuilder();
		int n = nLength - 1;
		int r = rLength - 1;
		int digit = 0;
		int carry = 0;
		
		while (n >= 0) {
			digit = (r >= 0) ? result.charAt(r) - '0' : 0;
			int sum = (number.charAt(n) - '0') + digit + carry;
			carry = sum / 10;
			sb.append(sum % 10);
			
			n--;
			r--;
		}
		
		if (carry != 0) { sb.append(carry); }
		
		sb.reverse();
		
		return sb.toString();
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(n + m)
	 * 
	 * if num1 is equal to string zero || num2 is equal to string zero
	 * 		return string zero
	 * end if
	 * 
	 * int n <- num1 length
	 * int m <- num2 length
	 * char[] cArr <- new char[n plus m]
	 * 
	 * fill cArr with char zero
	 * 
	 * for int i <- n minus one; if i is greater than or equal to zero; i--
	 * 		for int j <- m minus one; if j is greater than or equal to zero; j--
	 * 			int sum <- (cArr[i plus j plus one] to int) plus (num1 charAt(i) to int) times (num2 charAt(j) to int)
	 * 			cArr[i plus j plus one] <- (sum modulo ten to char)
	 * 			cArr[i plus j] <- cArr[i plus j] divide by ten
	 * 		end for
	 * end for
	 * 
	 * String result <- new String(cArr)
	 * 
	 * if cArr[0] is equal to char zero
	 * 		return result substring from one
	 * end if
	 * 
	 * return result
	 * */
	public String multiply_2(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) { return "0"; }
		
		int n = num1.length();
		int m = num2.length();
		char[] cArr = new char[n + m];																				// S : O(n + m)
		Arrays.fill(cArr, '0');																						// T : O(n + m)
		
		for (int i = n - 1; i >= 0; i--) {																			// T : O(n)
			for (int j = m - 1; j >= 0; j--) {																		// T : O(m)
				int sum = (cArr[i + j + 1] - '0') + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				cArr[i + j + 1] = (char) (sum % 10 + '0');
				cArr[i + j] += sum / 10;
			}
		}
		
		String result = new String(cArr);																			// S : O(n + m)
		if (cArr[0] == '0') { return result.substring(1); }															// S : O(n + m - 1)
		return result;
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(n + m)
	 * 
	 * if num1 is equal to string zero || num2 is equal to string zero
	 * 		return string zero
	 * end if
	 * 
	 * int n <- num1 length
	 * int m <- num2 length
	 * int s <- n plus m
	 * int[] n1Arr <- num1 to reverse int array
	 * int[] n2Arr <- num2 to reverse int array
	 * int[] sumArr <- new int[s plus one]
	 * 
	 * for int i <- 0; if i is lower than n; i++
	 * 		for int j <- 0; if j is lower than m; j++
	 * 			sumArr[i plus j] <- sumArr[i plus j] + n1Arr[i] times n2Arr[j]
	 * 		end for
	 * end for
	 * 
	 * for int i <- 0; if i is lower than s; i++
	 * 		sumArr[i plus one] <- sumArr[i plus one] + sumArr[i] divide by ten
	 * 		sumArr[i] <- sumArr[i] modulo ten
	 * end for
	 * 
	 * int start <- s
	 * while start is greater than zero && sumArr[start] is equal to zero
	 * 		start--
	 * end while
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * while start is greater than or equal to zero
	 * 		sb append(sumArr[start] to char)
	 * 		start--
	 * end while
	 * 
	 * return sb to string
	 * */
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) { return "0"; }
		
		int n = num1.length();
		int m = num2.length();
		int s = n + m;
		int[] n1Arr = toReverseIntArray(num1);																		// S : O(n)
		int[] n2Arr = toReverseIntArray(num2);																		// S : O(m)
		int[] sumArr = new int[s + 1];																				// S : O(n + m + 1)
		
		for (int i = 0; i < n; i++) {																				// T : O(n)
			for (int j = 0; j < m; j++) {																			// T : O(m)
				sumArr[i + j] += n1Arr[i] * n2Arr[j];
			}
		}
		
		for (int i = 0; i < s; i++) {																				// T : O(n + m)
			sumArr[i + 1] += sumArr[i] / 10;
			sumArr[i] %= 10;
		}
		
		int start = s;
		while (start > 0 && sumArr[start] == 0) { start--; }
		
		StringBuilder sb = new StringBuilder();
		while (start >= 0) {																						// S : O(n + m)
			sb.append((char) (sumArr[start] + '0'));																// T : O(1)
			start--;
		}
		
		return sb.toString();
	}
	
	/**
	 * int length <- number length
	 * int[] arr <- new int[length]
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		arr[length minus i minus one] <- number charAt(i) to int
	 * end for
	 * 
	 * return arr
	 * */
	public int[] toReverseIntArray(String number) {
		int length = number.length();
		int[] arr = new int[length];
		
		for (int i = 0; i < length; i++) {
			arr[length - i - 1] = number.charAt(i) - '0';
		}
		
		return arr;
	}
	
}
