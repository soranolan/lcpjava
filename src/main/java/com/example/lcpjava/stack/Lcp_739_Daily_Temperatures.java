package com.example.lcpjava.stack;

import java.util.Stack;

public class Lcp_739_Daily_Temperatures {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Monotonic Stack
	 * 
	 * Stack<Integer> stack <- new Stack
	 * int length <- array length
	 * int[] answer <- new int[length]
	 * 
	 * for int currentDay <- 0; if currentDay is lower than length; currentDay++
	 * 		while stack is not empty
	 * 			int currentTemperature <- array[currentDay]
	 * 			int previousTemperature <- array[stack peek]
	 * 			if currentTemperature is lower than or equal to previousTemperature
	 * 				break
	 * 			end if
	 * 			
	 * 			int previousDay <- stack pop
	 * 			answer[previousDay] <- currentDay minus previousDay
	 * 		end while
	 * 		stack push(currentDay)
	 * end for
	 * 
	 * return answer
	 * */
	public int[] dailyTemperatures_1(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int length = temperatures.length;
		int[] answer = new int[length];																				// S : O(n)
		
		for (int currentDay = 0; currentDay < length; currentDay++) {												// T : O(n)
			while (!stack.isEmpty()) {
				int currentTemperature = temperatures[currentDay];
				int previousTemperture = temperatures[stack.peek()];
				if (currentTemperature <= previousTemperture) { break; }
				
				int previousDay = stack.pop();
				answer[previousDay] = currentDay - previousDay;
			}
			stack.push(currentDay);
		}
		
		return answer;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int length <- array length
	 * int hottest <- 0
	 * int[] answer <- new int[length]
	 * 
	 * for int currentDay <- length minus one; if currentDay is greater than or equal to zero; currentDay--
	 * 		int currentTemperature <- array[currentDay]
	 * 		if currentTemperature is greater than or equal to hottest
	 * 			hottest <- currentTemperature
	 * 			continue
	 * 		end if
	 * 		
	 * 		int days <- 1
	 * 		while currentTemperature is greater than or equal to array[currentDay plus days]
	 * 			days <- days plus answer[currentDay plus days]
	 * 		end while
	 * 		
	 * 		answer[currentDay] <- days
	 * end for
	 * 
	 * return answer
	 * */
	public int[] dailyTemperatures(int[] temperatures) {
		int length = temperatures.length;
		int hottest = 0;
		int answer[] = new int[length];
		
		for (int currentDay = length - 1; currentDay >= 0; currentDay--) {											// T : O(n)
			int currentTemperature = temperatures[currentDay];
			if (currentTemperature >= hottest) {
				hottest = currentTemperature;
				continue;
			}
			
			int days = 1;
			while (currentTemperature >= temperatures[currentDay + days]) {
				days = days + answer[currentDay + days];
			}
			
			answer[currentDay] = days;
		}
		
		return answer;
	}
	
}
