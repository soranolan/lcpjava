package com.example.lcpjava.array;

public class Lcp_640_Solve_the_Equation {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int number <- 0
	 * int xSum <- 0
	 * int nSum <- 0
	 * int xSign <- 1
	 * int nSign <- minus one
	 * boolean isCharZero <- false
	 * boolean isRightSide <- false
	 * 
	 * for char c in equation to char array
	 * 		if c is digit
	 * 			number <- number times ten plus c minus char zero
	 * 			isCharZero <- if c is equal to char zero then true else false
	 * 		else if c is equal to char x
	 * 			if number is equal to zero && c is not char zero
	 * 				number <- 1
	 * 			end if
	 * 			
	 * 			xSum <- xSum plus number times xSign
	 * 			
	 * 			number <- zero
	 * 			isCharZero <- false
	 * 		else if c is equal to char plus
	 * 			nSum <- nSum plus number times nSign
	 * 			
	 * 			number <- zero
	 * 			isCharZero <- false
	 * 			xSign <- if is equation right side then minus one else one
	 * 			nSign <- if is equation right side then one else minus one
	 * 		else if c is equal to char minus
	 * 			nSum <- nSum plus number times nSign
	 * 			
	 * 			number <- zero
	 * 			isCharZero <- false
	 * 			xSign <- if is equation right side then one else minus one
	 * 			nSign <- if is equation right side then minus one else one
	 * 		else if c is equal to char equal
	 * 			nSum <- nSum plus number times nSign
	 * 			
	 * 			number <- zero
	 * 			isCharZero <- false
	 * 			xSign <- minus one
	 * 			nSign <- one
	 * 			isRightSide <- true
	 * 		end if
	 * end for
	 * 
	 * nSum <- nSum plus number times nSign
	 * 
	 * if xSum is equal to zero && nSum is equal to zero
	 * 		return "Infinite solutions"
	 * end if
	 * 
	 * if xSum is equal to zero && nSum is not equal to zero
	 * 		return "No solution"
	 * end if
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * sb append("x=")
	 * 
	 * if nSum modulo xSum is equal to zero
	 * 		sb append(nSum divided by xSum)
	 * else
	 * 		sb append(double nSum divided by double xSum)
	 * end if
	 * 
	 * return sb to string
	 * */
	public String solveEquation(String equation) {
		int number = 0;
		int xSum = 0;
		int nSum = 0;
		int xSign = 1;																								// x at left side
		int nSign = -1;																								// number at right side
		boolean isCharZero = false;
		boolean isRightSide = false;
		
		for (char c : equation.toCharArray()) {
			if (Character.isDigit(c)) {
				number = number * 10 + c - '0';
				isCharZero = (c == '0') ? true : false;
			} else if (c == 'x') {
				if (number == 0 && !isCharZero) { number = 1; }														// x + x , 0x = 0
				xSum += number * xSign;
				
				number = 0;
				isCharZero = false;
			} else if (c == '+') {
				nSum += number * nSign;
				
				number = 0;
				isCharZero = false;
				xSign = isRightSide ? -1 : 1;
				nSign = isRightSide ? 1 : -1;
			} else if (c == '-') {
				nSum += number * nSign;
				
				number = 0;
				isCharZero = false;
				xSign = isRightSide ? 1 : -1;
				nSign = isRightSide ? -1 : 1;
			} else if (c == '=') {
				nSum += number * nSign;
				
				number = 0;
				isCharZero = false;
				xSign = -1;
				nSign = 1;
				isRightSide = true;
			}
		}
		
		nSum += number * nSign;																						// for last number like +2 in "2x+3x-6x=x+2"
		
		if (xSum == 0 && nSum == 0) { return "Infinite solutions"; }
		if (xSum == 0 && nSum != 0) { return "No solution"; }
		
		StringBuilder sb = new StringBuilder();
		sb.append("x=");
		
		if (nSum % xSum == 0) {
			sb.append(nSum / xSum);
		} else {
			sb.append((double) nSum / (double) xSum);
		}
		
		return sb.toString();
	}
	
}
