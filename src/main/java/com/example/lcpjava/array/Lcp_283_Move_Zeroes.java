package com.example.lcpjava.array;

public class Lcp_283_Move_Zeroes {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int left <- 0
	 * 
	 * for int right <- 1 to array end
	 * 		if array[left] is equal to zero
	 * 			if array[right] is not equal to zero
	 * 				array[left] <- array[right]
	 * 				array[right] <- 0
	 * 				left++
	 * 			end if
	 * 		else
	 * 			left++
	 * 		end if
	 * end for
	 * */
	public void moveZeroes_1(int[] nums) {
		int left = 0;
		
		for (int right = 1; right < nums.length; right++) {
			if (nums[left] == 0) {
				if (nums[right] != 0) {
					nums[left] = nums[right];
					nums[right] = 0;
					left++;
				}
			} else {
				left++;
			}
		}
		
		for (int num : nums) { System.out.print(num + " "); }
		System.out.println();
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int left <- 0
	 * 
	 * for int right <- 0 to array end
	 * 		if array[right] is not equal to zero
	 * 			int temp <- array[right]
	 * 			array[right] <- array[left]
	 * 			array[left] <- temp
	 * 			left++
	 * 		end if
	 * end for
	 * */
	public void moveZeroes_2(int[] nums) {
		int left = 0;
		for (int right = 0; right < nums.length; right++) {
			if (nums[right] != 0) {
				int temp = nums[right];
				nums[right] = nums[left];
				nums[left] = temp;
				left++;
			}
		}
		
		for (int num : nums) { System.out.print(num + " "); }
		System.out.println();
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int left <- 0
	 * int right <- 0
	 * 
	 * while right is lower than array length
	 * 		if array[right] is equal to zero
	 * 			right++
	 * 			continue
	 * 		end if
	 * 		int temp <- array[right]
	 * 		array[right] <- array[left]
	 * 		array[left] <- temp
	 * 		right++
	 * 		left++
	 * end while
	 * */
	public void moveZeroes_3(int[] nums) {
		int left = 0;
		int right = 0;
		
		while (right < nums.length) {
			if (nums[right] == 0) {
				right++;
				continue;
			}
			int temp = nums[right];
			nums[right] = nums[left];
			nums[left] = temp;
			right++;
			left++;
		}
		
		for (int num : nums) { System.out.print(num + " "); }
		System.out.println();
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int snowBall = 0;
	 * 
	 * for int i <- 0 to array end
	 * 		if array[i] is equal to zero
	 * 			snowBall++
	 * 		else if snowBall is greater than zero
	 * 			array[i - snowBall] <- array[i]
	 * 			array[i] <- 0
	 * 		end if
	 * end for
	 * */
	public void moveZeroes(int[] nums) {
		int snowBall = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				snowBall++;
			} else if (snowBall > 0) {
				nums[i - snowBall] = nums[i];
				nums[i] = 0;
			}
		}
		
		for (int num : nums) { System.out.print(num + " "); }
		System.out.println();
	}
	
	public static void main(String[] args) {
		Lcp_283_Move_Zeroes lcp = new Lcp_283_Move_Zeroes();
		int[] input = null;
		
		// 1 3 12 0 0
		input = new int[] { 0, 1, 0, 3, 12 };
		lcp.moveZeroes(input);
		
		// 1 3 12 0 0
		input = new int[] { 0, 0, 1, 3, 12 };
		lcp.moveZeroes(input);
		
		// 0
		input = new int[] { 0 };
		lcp.moveZeroes(input);
	}
	
}
