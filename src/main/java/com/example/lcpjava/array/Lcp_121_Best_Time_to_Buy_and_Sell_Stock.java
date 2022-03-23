package com.example.lcpjava.array;

public class Lcp_121_Best_Time_to_Buy_and_Sell_Stock {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * 
	 * Brute Force
	 * 
	 * 
	 * int maxProfit <- 0
	 * int length <- prices length
	 * 
	 * for int buy <- 0; if buy is lower than length minus one; buy++
	 * 		for int sell <- buy plus one; if sell is lower than length; sell++
	 * 			int profit <- prices[sell] minus prices[buy]
	 * 			maxProfit <- Math max(maxProfit, profit)
	 * 		end for
	 * end for
	 * 
	 * return maxProfit
	 * */
	public int maxProfit_1(int[] prices) {
		int maxProfit = 0;
		int length = prices.length;
		
		for (int buy = 0; buy < length - 1; buy++) {																// T : O(n)
			for (int sell = buy + 1; sell < length; sell++) {														// T : O(n)
				int profit = prices[sell] - prices[buy];
				maxProfit = Math.max(maxProfit, profit);
			}
		}
		
		return maxProfit;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/132879/Exhaustive-Search-DP-with-Explanation-(Java-Python)
	 * 
	 * 
	 * int length <- prices length
	 * int maxProfit <- 0
	 * int[] dp <- new int[length]
	 * 
	 * for int day <- 1; if day is lower than length; day++
	 * 		int profit <- prices[day] minus prices[day minus one]
	 * 		dp[day] <- Math max(zero, dp[day minus one] plus profit)
	 * 		maxProfit <- Math max(maxProfit, dp[day])
	 * end for
	 * 
	 * return maxProfit
	 * */
	public int maxProfit_2(int[] prices) {
		int length = prices.length;
		int maxProfit = 0;
		int[] dp = new int[length];																					// S : O(n)
		
		for (int day = 1; day < length; day++) {																	// T : O(n)
			int profit = prices[day] - prices[day - 1];
			dp[day] = Math.max(0, dp[day - 1] + profit);															// sum vs previous sum
			maxProfit = Math.max(maxProfit, dp[day]);
		}
		
		return maxProfit;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/1735550/Python-Javascript-Easy-solution-with-very-clear-Explanation
	 * 
	 * 
	 * int maxProfit <- 0
	 * int buy <- 0
	 * int sell <- 1
	 * 
	 * while sell is lower than prices length
	 * 		int profit <- prices[sell] minus prices[buy]
	 * 		
	 * 		if profit is greater than zero
	 * 			maxProfit <- Math max(maxProfit, profit)
	 * 		else
	 * 			buy <- sell
	 * 		end if
	 * 		
	 * 		sell++
	 * end while
	 * 
	 * return maxProfit
	 * */
	public int maxProfit_3(int[] prices) {
		int maxProfit = 0;
		int buy = 0;
		int sell = 1;
		
		while (sell < prices.length) {																				// T : O(n)
			int profit = prices[sell] - prices[buy];
			
			if (profit > 0) {
				maxProfit = Math.max(maxProfit, profit);
			} else {
				buy = sell;
			}
			
			sell++;
		}
		
		return maxProfit;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Kadane's Algorithm
	 * 
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39038/Kadane's-Algorithm-Since-no-one-has-mentioned-about-this-so-far-%3A)-(In-case-if-interviewer-twists-the-input)
	 * 
	 * 
	 * int minPrice <- prices[0]
	 * int maxProfit <- 0
	 * 
	 * for int price in prices
	 * 		minPrice <- Math min(price, minPrice)
	 * 		maxProfit <- Math max(maxProfit, price minus minPrice)
	 * end for
	 * 
	 * return maxProfit
	 * */
	public int maxProfit_4(int[] prices) {
		int minPrice = prices[0];
		int maxProfit = 0;
		
		for (int price : prices) {																					// T : O(n)
			minPrice = Math.min(price, minPrice);
			maxProfit = Math.max(maxProfit, price - minPrice);
		}
		
		return maxProfit;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int minPrice <- prices[0]
	 * int maxProfit <- 0
	 * 
	 * for int price in prices
	 * 		if price is lower than minPrice
	 * 			minPrice <- Math min(price, minPrice)
	 * 		else
	 * 			maxProfit <- Math max(maxProfit, price minus minPrice)
	 * 		end if
	 * end for
	 * 
	 * return maxProfit
	 * */
	public int maxProfit(int[] prices) {
		int minPrice = prices[0];
		int maxProfit = 0;
		
		for (int price : prices) {																					// T : O(n)
			if (price < minPrice) {
				minPrice = Math.min(price, minPrice);
			} else {
				maxProfit = Math.max(maxProfit, price - minPrice);
			}
		}
		
		return maxProfit;
	}
	
}
