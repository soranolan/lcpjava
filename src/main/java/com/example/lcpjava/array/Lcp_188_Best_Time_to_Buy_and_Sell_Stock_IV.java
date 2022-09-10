package com.example.lcpjava.array;

public class Lcp_188_Best_Time_to_Buy_and_Sell_Stock_IV {
	
	/**
	 * time  : O(n ^ 2 * k)
	 * space : O(k * n)
	 * 
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution/190004
	 * */
	public int maxProfit_1(int k, int[] prices) {
		int n = prices.length;
		if (k == 0 || n == 0) { return 0; }
		if (k > n / 2) { return base(prices, n); }
		
		int[][] dp = new int[k + 1][n];																				// S : O((k + 1) * n)
		
		for (int transaction = 1; transaction <= k; transaction++) {												// T : O(k)
			for (int sellAtDay = 1; sellAtDay < n; sellAtDay++) {													// T : O(n - 1)
				int profit = Math.max(0, prices[sellAtDay] - prices[0]);
				
				for (int buyAtDay = 1; buyAtDay <= sellAtDay; buyAtDay++) {											// T : O(n)
					profit = Math.max(profit, dp[transaction - 1][buyAtDay - 1] + prices[sellAtDay] - prices[buyAtDay]);
				}
				
				dp[transaction][sellAtDay] = Math.max(dp[transaction][sellAtDay - 1], profit);
			}
		}
		
		return dp[k][n - 1];
	}
	
	/**
	 * time  : O(n ^ 2 * k)
	 * space : O(k * n)
	 * 
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution
	 * */
	public int maxProfit_2(int k, int[] prices) {
		int n = prices.length;
		if (k == 0 || n == 0) { return 0; }
		if (k > n / 2) { return base(prices, n); }
		
		int[][] dp = new int[k + 1][n];																				// S : O((k + 1) * n)
		
		for (int transaction = 1; transaction <= k; transaction++) {												// T : O(k)
			for (int day = 1; day < n; day++) {																		// T : O(n - 1)
				int min = prices[0];
				
				for (int current = 1; current <= day; current++) {													// T : O(n)
					min = Math.min(min, prices[current] - dp[transaction - 1][current - 1]);
				}
				
				dp[transaction][day] = Math.max(dp[transaction][day - 1], prices[day] - min);
			}
		}
		
		return dp[k][n - 1];
	}
	
	/**
	 * time  : O(k * n)
	 * space : O(k * n)
	 * 
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54117/Clean-Java-DP-solution-with-comment
	 * */
	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
		if (k == 0 || n == 0) { return 0; }
		if (k > n / 2) { return base(prices, n); }
		
		int[][] dp = new int[k + 1][n];																				// S : O((k + 1) * n)
		
		for (int transaction = 1; transaction <= k; transaction++) {												// T : O(k)
			int profit = -prices[0];
			
			for (int day = 1; day < n; day++) {																		// T : O(n - 1)
				dp[transaction][day] = Math.max(dp[transaction][day - 1], prices[day] + profit);
				profit = Math.max(profit, dp[transaction - 1][day - 1] - prices[day]);
			}
		}
		
		return dp[k][n - 1];
	}
	
	private int base(int[] prices, int n) {
		int profit = 0;
		for (int i = 1; i < n; i++) {																				// T : O(n - 1)
			profit += Math.max(prices[i] - prices[i - 1], 0);
		}
		return profit;
	}
	
}
