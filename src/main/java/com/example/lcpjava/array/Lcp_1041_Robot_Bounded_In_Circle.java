package com.example.lcpjava.array;

public class Lcp_1041_Robot_Bounded_In_Circle {
	
	/**
	 *             N                   
	 *             |( 0, 1 )           
	 *             |                   
	 * W───────────O──────────E        
	 *  ( -1, 0 )  |( 0, 0 )   ( 1, 0 )
	 *             |                   
	 *             S                   
	 *              ( 0, -1 )          
	 * */
	/**
	 * time  : O(n)
	 * space : O(8)
	 * 
	 * https://leetcode.com/problems/robot-bounded-in-circle/discuss/1676710/Well-Detailed-Explaination-JAVA-C%2B%2B-oror-Easy-for-mind-to-Accept-it
	 * 
	 * 
	 * int x <- 0
	 * int y <- 0
	 * int index <- 0
	 * int[][] direction <- North, West, South, East
	 * 
	 * for int i <- 0; if i is lower than instructions length; i++
	 * 		char c <- instructions charAt(i)
	 * 		
	 * 		if
	 * 		end if
	 * end for
	 * 
	 * if x is equal to zero && y is equal to zero
	 * 		return true
	 * end if
	 * 
	 * if index is not equal to zero
	 * 		return true
	 * end if
	 * 
	 * return false
	 * */
	public boolean isRobotBounded_1(String instructions) {
		int x = 0;
		int y = 0;
		int index = 0;
		int[][] direction = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };											// S : O(8)
		
		for (int i = 0; i < instructions.length(); i++) {															// T : O(n)
			char c = instructions.charAt(i);
			
			if (c == 'L') {
				index = (index + 1) % 4;
			} else if (c == 'R') {
				index = (index + 3) % 4;
			} else {
				x += direction[index][0];
				y += direction[index][1];
			}
		}
		
		return (x == 0 && y == 0) || index != 0;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int x <- 0
	 * int y <- 0
	 * int direction <- 0
	 * 
	 * for int i <- 0; if i is lower than instructions length; i++
	 * 		char c <- instructions charAt(i)
	 * 		
	 * 		if c is equal to char L
	 * 			direction++
	 * 			
	 * 			if direction is greater than three
	 * 				direction <- 0
	 * 			end if
	 * 		else if c is equal to char R
	 * 			direction--
	 * 			
	 * 			if direction is lower than zero
	 * 				direction <- 3
	 * 			end if
	 * 		else
	 * 			if direction is equal to zero
	 * 				y++
	 * 			else if direction is equal to one
	 * 				x--
	 * 			else if direction is equal to two
	 * 				y--
	 * 			else
	 * 				x++
	 * 			end if
	 * 		end if
	 * end for
	 * 
	 * if x is equal to zero && y is equal to zero
	 * 		return true
	 * end if
	 * 
	 * if direction is not equal to zero
	 * 		return true
	 * end if
	 * 
	 * return false
	 * */
	public boolean isRobotBounded(String instructions) {
		int x = 0;
		int y = 0;
		int direction = 0;
		
		for (int i = 0; i < instructions.length(); i++) {															// T : O(n)
			char c = instructions.charAt(i);
			
			if (c == 'L') {
				direction++;
				if (direction > 3) { direction = 0; }
			} else if (c == 'R') {
				direction--;
				if (direction < 0) { direction = 3; }
			} else {
				if (direction == 0) {																				// North
					y++;
				} else if (direction == 1) {																		// West
					x--;
				} else if (direction == 2) {																		// South
					y--;
				} else {																							// East
					x++;
				}
			}
		}
		
		return (x == 0 && y == 0) || direction != 0;
	}
	
}
