package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lcp_22_Generate_Parentheses {
	
	/**
	 * time  : O((4 ^ n) * n)
	 * space : O((4 ^ n) * n)
	 * 
	 * Brute Force
	 * 
	 * 
	 * List<String> result <- new ArrayList
	 * 
	 * generate(zero, new char[2 multiply n], result)
	 * 
	 * return result
	 * */
	public List<String> generateParenthesis_1(int n) {
		List<String> result = new ArrayList<>();
		generate(0, new char[2 * n], result);
		return result;
	}
	
	/**
	 * if index is equal to parentheses length
	 * 		if is valid parentheses
	 * 			result add(new String(parentheses))
	 * 		end if
	 * else
	 * 		parentheses[index] <- '('
	 * 		generate(index plus one, parentheses, result)
	 * 		parentheses[index] <- ')'
	 * 		generate(index plus one, parentheses, result)
	 * end if
	 * */
	public void generate(int index, char[] parentheses, List<String> result) {
		if (index == parentheses.length) {
			if (valid(parentheses)) {
				result.add(new String(parentheses));
			}
		} else {
			parentheses[index] = '(';
			generate(index + 1, parentheses, result);
			parentheses[index] = ')';
			generate(index + 1, parentheses, result);
		}
	}
	
	/**
	 * int balance <- 0
	 * 
	 * for char c in parentheses
	 * 		if c is equal to '('
	 * 			balance++
	 * 		else
	 * 			balance--
	 * 		end if
	 * 		
	 * 		if balance is lower than zero
	 * 			return false
	 * 		end if
	 * end for
	 * 
	 * return if balance is equal to zero
	 * */
	public boolean valid(char[] parentheses) {
		int balance = 0;
		
		for (char c : parentheses) {																				// T : O(n)
			if (c == '(') {
				balance++;
			} else {
				balance--;
			}
			if (balance < 0) { return false; }
		}
		
		return (balance == 0);
	}
	
	/**
	 * time  : O((4 ^ n) / 《n)
	 * space : O((4 ^ n) / 《n)
	 * 
	 * Backtracking
	 * 
	 * 
	 * List<Stromg> result <- new ArrayList
	 * 
	 * backtrack(zero, zero, n, new StringBuilder, result)
	 * 
	 * return result
	 * */
	public List<String> generateParenthesis_2(int n) {
		List<String> result = new ArrayList<>();
		backtrack(0, 0, n, new StringBuilder(), result);
		return result;
	}
	
	/**
	 * if sb length is equal to n multiply two
	 * 		result add(sb to string)
	 * 		return
	 * end if
	 * 
	 * if open is lower than n
	 * 		sb append("(")
	 * 		backtrack(open plus one, close, n, sb, result)
	 * 		sb deleteCharAt(sb length minus one)
	 * end if
	 * 
	 * if close is lower than open
	 * 		sb append(")")
	 * 		backtrack(open, close plus one, n, sb, result)
	 * 		sb deleteCharAt(sb length minus one)
	 * end if
	 * */
	public void backtrack(int open, int close, int n, StringBuilder sb, List<String> result) {
		if (sb.length() == n * 2) {
			result.add(sb.toString());
			return;
		}
		
		if (open < n) {
			sb.append("(");
			backtrack(open + 1, close, n, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
		
		if (close < open) {
			sb.append(")");
			backtrack(open, close + 1, n, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	/**
	 * https://leetcode.com/problems/generate-parentheses/discuss/10369/Clean-Python-DP-Solution
	 * 
	 * n = 1
	 * 		()		1 pair
	 * n = 2
	 * 		()()	0 pair inside + n - 1 pair afterward
	 * 				0					1
	 * 		(())	1 pair inside + n - 2 pair afterward
	 * 				1					0
	 * n = 3
	 * 		(()())	0 pair inside + 1 pair afterward
	 * 		()()()	0 pair inside + 2 pair afterward
	 * 		()(())	1 pair inside + 0 pair afterward
	 * 		(())()	1 pair inside + 1 pair afterward
	 * 		((()))	2 pair inside + 0 pair afterward
	 * 
	 * (0 ~ n - 1) pair inside + (n - 1 ~ 0) pair afterward
	 * */
	/**
	 * time  : O(n ^ 2)
	 * space : O(n ^ 2)
	 * 
	 * List<List<String>> dp <- new ArrayList<List<String>>(n plus one)
	 * fill dp with new ArrayList
	 * 
	 * dp set(zero, "")
	 * 
	 * for int total <- 0; if total is lower than or equal to n; total++
	 * 		for int insidePair <- 0; if insidePair is lower than total; insidePair++
	 * 			List<String> temp <- dp get(total)
	 * 			
	 * 			for String inside in dp get(insidePair)
	 * 				for String afterward in dp get(total minus one minus insidePair)
	 * 					StringBuilder sb <- new StringBuilder
	 * 					sb append("(") append(inside) append(")") append(afterward)
	 * 					temp add(sb to string)
	 * 				end for
	 * 			end for
	 * 			
	 * 			dp set(total, temp)
	 * 		end for
	 * end for
	 * 
	 * return dp get(n)
	 * */
	public List<String> generateParenthesis_3(int n) {
		List<List<String>> dp = new ArrayList<List<String>>(n + 1);
		for (int i = 0; i < n + 1; i++) { dp.add(new ArrayList<>()); }
		dp.set(0, Arrays.asList(new String[] { "" }));
		
		for (int total = 0; total <= n; total++) {																	// T : O(n)
			for (int insidePair = 0; insidePair < total; insidePair++) {											// T : O(n)
				List<String> temp = dp.get(total);
				
				for (String inside : dp.get(insidePair)) {
					for (String afterward : dp.get(total - 1 - insidePair)) {
						StringBuilder sb = new StringBuilder();
						sb.append("(").append(inside).append(")").append(afterward);
						temp.add(sb.toString());
					}
				}
				
				dp.set(total, temp);
			}
		}
		
		return dp.get(n);
	}
	
	/**
	 * time  : O((4 ^ n) / 《n)
	 * space : O((4 ^ n) / 《n)
	 * 
	 * Closure Number
	 * 
	 * 
	 * List<String> result <- new ArrayList
	 * 
	 * if n is equal to zero
	 * 		result add("")
	 * else
	 * 		for int insidePair <- 0; if insidePair is lower than n; insidePair++
	 * 			for String inside in generateParenthesis(insidePair)
	 * 				for String afterward in generateParenthesis(n minus one minus insidePair)
	 * 					result add("(" concatenate inside concatenate ")" concatenate afterward)
	 * 				end for
	 * 			end for
	 * 		end for
	 * end 
	 * 
	 * return result
	 * */
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		
		if (n == 0) {
			result.add("");
		} else {
			for (int insidePair = 0; insidePair < n; insidePair++) {
				for (String inside : generateParenthesis(insidePair)) {
					for (String afterward : generateParenthesis(n - 1 - insidePair)) {
						result.add("(" + inside + ")" + afterward);
					}
				}
			}
		}
		
		return result;
	}
	
}
