package com.example.lcpjava.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lcp_202_Happy_Number {
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * 
	 * 02 > 04 > 16 > 37 > 58 > 89 > 145 > 42 > 20 > 04
	 * 03 > 09 > 81 > 65 > 61 > 37 > 58 > 89 > 145 > 42 > 20 > 04
	 * 04 > 16 > 37 > 58 > 89 > 145 > 42 > 20 > 04
	 * 05 > 25 > 29 > 85 > 89 > 145 > 42 > 20 > 04
	 * 06 > 36 > 45 > 41 > 17 > 50 > 25 > 29 > 85 > 89 > 145 > 42 > 20 > 04
	 * 08 > 64 > 52 > 25 > 29 > 85 > 89 > 145 > 42 > 20 > 04
	 * 09 > 81 > 65 > 61 > 37 > 58 > 89 > 145 > 42 > 20 > 04
	 * unhappy [ 2, 3, 4, 5, 6, 8, 9, 16, 17, 20, 25, 29, 36, 37, 41, 42, 45, 50, 52, 58, 61, 64, 65, 81, 85, 89, 145 ]
	 * 
	 * 
	 * int target <- n
	 * int sum <- 0
	 * 
	 * while target is greater than or equal to zero
	 * 		if target is equal to zero
	 * 			if sum is equal to one or seven
	 * 				return true
	 * 			end if
	 * 			
	 * 			if sum is unhappy number
	 * 				return false
	 * 			end if
	 * 			
	 * 			target <- sum
	 * 			sum <- zero
	 * 			continue
	 * 		end if
	 * 		
	 * 		int digit <- target modulo ten
	 * 		sum <- sum plus (digit power two)
	 * 		
	 * 		target <- target divide ten
	 * end while
	 * 
	 * return false
	 * */
	public static Set<Integer> unhappy = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 8, 9, 16, 17, 20, 25, 29, 36, 37, 41, 42, 45, 50, 52, 58, 61, 64, 65, 81, 85, 89, 145));
	public boolean isHappy_1(int n) {
		int target = n;
		int sum = 0;
		
		while (target >= 0) {																						// T : O(log n)
			if (target == 0) {
				if (sum == 1 || sum == 7) { return true; }
				if (unhappy.contains(sum)) { return false; }														// T : O(1)
				target = sum;
				sum = 0;
				continue;
			}
			int digit = target % 10;
			sum = sum + digit * digit;
			target = target / 10;
		}
		
		return false;
	}
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * 
	 * while n is not equal to one && unhappy does not contain n
	 * 		n <- getNext(n)
	 * end while
	 * 
	 * return if n is equal to one
	 * */
	public boolean isHappy_2(int n) {
		while (n != 1 && !unhappy.contains(n)) { n = getNext(n); }
		return n == 1;
	}
	
	/**
	 * time  : O(log n)
	 * space : O(log n)
	 * 
	 * Detect Cycle in a linked list
	 * 
	 * 
	 * Set<Integer> visited <- new HashSet
	 * 
	 * while n is not equal to one && visited does not contain n
	 * 		visited add(n)
	 * 		n <- getNext(n)
	 * end while
	 * 
	 * return if n is equal to one
	 * */
	public boolean isHappy_3(int n) {
		Set<Integer> visited = new HashSet<>();																		// S : O(log n)
		
		while (n != 1 && !visited.contains(n)) {
			visited.add(n);
			n = getNext(n);																							// T : O(log n)
		}
		
		return n == 1;
	}
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * 
	 * Floyd Cycle Detection Algorithm
	 * 
	 * 
	 * int slow <- n
	 * int fast <- getNext(n)
	 * 
	 * while fast is not equal to one && slow is not equal to fast
	 * 		slow <- getNext(slow)
	 * 		fast <- getNext(getNext(fast))
	 * end while
	 * 
	 * return is fast is equal to one
	 * */
	public boolean isHappy(int n) {
		int slow = n;
		int fast = getNext(n);																						// T : O(log n)
		
		while (fast != 1 && slow != fast) {
			slow = getNext(slow);																					// T : O(log n)
			fast = getNext(getNext(fast));																			// T : O(log(log n))
		}
		
		return fast == 1;
	}
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * 
	 * why summing each digit is log n
	 * https://stackoverflow.com/questions/50261364/explain-why-time-complexity-for-summing-digits-in-a-number-of-length-n-is-ologn/50262470
	 * 
	 * if is 2 digits number
	 * 10 ~ 99
	 * 
	 * 10 <= Number < 100
	 * 10 ^ (2 - 1) <= Number < 10 ^ 2
	 * 10 ^ (digit - 1) <= Number < 10 ^ digit
	 * digit - 1 <= log(Number) < digit
	 * digit <= log(Number) + 1 && log(Number) < digit
	 * log(Number) < digit <= log(Number) + 1
	 * 
	 * 
	 * int sum <- 0
	 * 
	 * while number is greater than zero
	 * 		int digit <- number modulo ten
	 * 		sum <- sum plus digit multiply digit
	 * 		number <- number divide ten
	 * end while
	 * 
	 * return sum
	 * */
	public int getNext(int number) {
		int sum = 0;
		
		while (number > 0) {																						// T : O(log n)
			int digit = number % 10;
			sum = sum + digit * digit;
			number = number / 10;
		}
		
		return sum;
	}
	
}
