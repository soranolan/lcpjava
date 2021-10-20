package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_561_Array_Partition_I {
	
	/**
	 * time  : O(n log n)
	 * space : O(1)
	 * 
	 * array sort
	 * int sum <- 0
	 * 
	 * for int i <- 0; if i is lower than array length; i <- i plus two
	 * 		sum <- sum plus array[i]
	 * end for
	 * 
	 * return sum
	 * */
	public int arrayPairSum_1(int[] nums) {
		Arrays.sort(nums);																							// T : O(n log n)
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2) { sum += nums[i]; }												// T : O(n)
		return sum;
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(n)
	 * 
	 * int[] container <- empty array[20001]
	 * for number in array
	 * 		container[number plus 10000]++;
	 * end for
	 * 
	 * int sum <- 0
	 * boolean isOdd <- true
	 * for int i <- 0; if i is lower than container length; i++
	 * 		while container[i] is greater than zero
	 * 			if isOdd
	 * 				sum <- sum plus (i minus 10000)
	 * 			end if
	 * 			isOdd <- not isOdd
	 * 			container[i]--;
	 * 		end while
	 * end for
	 * 
	 * return sum
	 * */
	public int arrayPairSum_2(int[] nums) {
		int[] container = new int[20001];																			// S : O(n)
		for (int num : nums) { container[num + 10000]++; }															// T : O(n)
		
		int sum = 0;
		boolean isOdd = true;
		
		for (int i = 0; i < container.length; i++) {																// T : O(m)
			while (container[i] > 0) {																				// T : O(n)
				if (isOdd) { sum += (i - 10000); }
				isOdd = !isOdd;
				container[i]--;
			}
		}
		
		return sum;
	}
	
	/**
	 * time : O(m + n)
	 * space : O(m + n)
	 * 
	 * int min <- array[0]
	 * int max <- array[0]
	 * for number in array
	 * 		if max is lower than number
	 * 			max <- number
	 * 		else if min is greater than number
	 * 			min <- number
	 * 		end if
	 * end for
	 * 
	 * int distance <- max minus min
	 * int[] container <- empty array[distance plus one]
	 * for number in array
	 * 		container[number minus min]++
	 * end for
	 * for int i <- 1; if i is lower than container length; i++
	 * 		container[i] <- container[i] plus container[i minus one]
	 * end for
	 * 
	 * int length <- array length
	 * int[] sorted <- empty array[length]
	 * for int i <- length minus one; if i is greater than or equal to zero; i--
	 * 		int index <- array[i] minus min
	 * 		sorted[container[index] minus one] <- array[i]
	 * 		container[index]--
	 * end for
	 * 
	 * int sum <- 0
	 * for int i <- 0; if i is lower than sorted length; i <- i plus two
	 * 		sum <- sum plus sorted[i]
	 * end for
	 * 
	 * return sum
	 * */
	public int arrayPairSum_3(int[] nums) {
		int min = nums[0];
		int max = nums[0];
		
		for (int num : nums) {																						// T : O(n)
			if (max < num) {
				max = num;
			} else if (min > num) {
				min = num;
			}
		}
		
		int distance = max - min;
		int[] container = new int[distance + 1];																	// S : O(m)
		
		for (int num : nums) { container[num - min]++; }															// T : O(n)
		for (int i = 1; i < container.length; i++) { container[i] = container[i] + container[i - 1]; }				// T : O(m)
		
		int length = nums.length;
		int[] sorted = new int[length];																				// S : O(n)
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			int index = nums[i] - min;
			sorted[container[index] - 1] = nums[i];
			container[index]--;
		}
		
		int sum = 0;
		for (int i = 0; i < sorted.length; i += 2) { sum += sorted[i]; }											// T : O(n)
		
		return sum;
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(m)
	 * 
	 * int min <- array[0]
	 * int max <- array[0]
	 * for number in array
	 * 		if max is lowert than number
	 * 			max <- number
	 * 		else if min is greater than number
	 * 			min <- number
	 * 		end if
	 * end for
	 * 
	 * int distance <- max minus min
	 * int[] container <- empty array[distance plus one]
	 * for number in array
	 * 		container[number minus min]++
	 * end for
	 * 
	 * int sum <- 0
	 * boolean isOdd <- true
	 * for int i <- 0; if i is lower than container length; i++
	 * 		while container[i] is greater than zero
	 * 			if isOdd
	 * 				sum <- sum plus (i minus 10000)
	 * 			end if
	 * 			isOdd <- not isOdd
	 * 			container[i]--;
	 * 		end while
	 * end for
	 * 
	 * return sum
	 * */
	public int arrayPairSum(int[] nums) {
		int min = nums[0];
		int max = nums[0];
		
		for (int num : nums) {																						// T : O(n)
			if (max < num) {
				max = num;
			} else if (min > num) {
				min = num;
			}
		}
		
		int distance = max - min;
		int[] container = new int[distance + 1];																	// S : O(m)
		
		for (int num : nums) { container[num - min]++; }															// T : O(n)
		
		int sum = 0;
		boolean isOdd = true;
		
		for (int i = 0; i < container.length; i++) {																// T : O(m)
			while (container[i] > 0) {																				// T : O(n)
				if (isOdd) { sum += (i + min); }
				isOdd = !isOdd;
				container[i]--;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Lcp_561_Array_Partition_I lcp = new Lcp_561_Array_Partition_I();
		int[] input = null;
		int output = -1;
		
		// 4
		input = new int[] { 1, 4, 3, 2 };
		output = lcp.arrayPairSum(input);
		System.out.println(output);
		
		// 9
		input = new int[] { 6, 2, 6, 5, 1, 2 };
		output = lcp.arrayPairSum(input);
		System.out.println(output);
	}
	
}
