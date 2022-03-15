package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lcp_406_Queue_Reconstruction_by_Height {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * Arrays sort(people, (offer, previous) -> if offer[0] is not equal to previous[0] then previous[0] minus offer[0] else offer[1] minus previous[1]
	 * 
	 * List<int[]> result <- new ArrayList
	 * 
	 * for int[] person in people
	 * 		result add(person[1], person)
	 * end for
	 * 
	 * return result to array(new int[result size][])
	 * */
	public int[][] reconstructQueue_1(int[][] people) {
		Arrays.sort(people, (offer, previous) -> offer[0] != previous[0] ? previous[0] - offer[0] : offer[1] - previous[1]);
		List<int[]> result = new ArrayList<>();																		// S : O(n)
		for (int[] person : people) {																				// T : O(n)
			result.add(person[1], person);																			// T : O(n)
		}
		return result.toArray(new int[result.size()][]);
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * Arrays sort(people, (offer, previous) -> if offer[0] is not equal to previous[0] then offer[0] minus previous[0] else previous[1] minus offer[1]
	 * 
	 * int[][] result <- new int[people length][]
	 * 
	 * for int[] person in people
	 * 		int count <- 0
	 * 		
	 * 		for int i <- 0; if i is lower than result length; i++
	 * 			if result[i] is not equal to null
	 * 				continue
	 * 			end if
	 * 			
	 * 			if count is equal to person[1]
	 * 				result[i] <- person
	 * 				break
	 * 			end if
	 * 			
	 * 			count++
	 * 		end for
	 * end for
	 * 
	 * return result
	 * */
	public int[][] reconstructQueue_2(int[][] people) {
		Arrays.sort(people, (offer, previous) -> offer[0] != previous[0] ? offer[0] - previous[0] : previous[1] - offer[1]);
		
		int[][] result = new int[people.length][];
		
		for (int[] person : people) {																				// T : O(n)
			int count = 0;
			
			for (int i = 0; i < result.length; i++) {																// T : O(n)
				if (result[i] != null) { continue; }
				
				if (count == person[1]) {
					result[i] = person;
					break;
				}
				
				count++;
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(n * log n * log n)
	 * space : O(n)
	 * 
	 * binary search + binary indexed tree (Fenwick tree)
	 * 
	 * https://leetcode.com/problems/queue-reconstruction-by-height/discuss/427157/Three-different-C%2B%2B-solutions.-from-O(n2)-to-O(nlogn).-faster-than-99.
	 * 
	 * 
	 * Arrays sort(people, (offer, previous) -> if offer[0] is not equal to previous[0] then offer[0] minus previous[0] else previous[1] minus offer[1]
	 * 
	 * length <- people length
	 * bit <- new int[length plus one]
	 * 
	 * int[][] result <- new int[length][]
	 * 
	 * for int i <- 2; if i is lower than or equal to length; i++
	 * 		update(i, one)
	 * end for
	 * 
	 * for int[] person in people
	 * 		int index <- binarySearch(person[1])
	 * 		result[index] <- person
	 * 		update(index plus one, minus one)
	 * end for
	 * 
	 * return result
	 * */
	int length;
	int[] bit;
	public int[][] reconstructQueue_3(int[][] people) {
		Arrays.sort(people, (offer, previous) -> offer[0] != previous[0] ? offer[0] - previous[0] : previous[1] - offer[1]);
		
		length = people.length;
		bit = new int[length + 1];																					// S : O(n + 1)
		
		int[][] result = new int[length][];																			// S : O(n)
		
		for (int i = 2; i <= length; i++) {																			// T : O(n - 2)
			update(i, 1);																							// T : O(log n)
		}
		
		for (int[] person : people) {																				// T : O(n)
			int index = binarySearch(person[1]);																	// T : O(log n * log n)
			result[index] = person;
			update(index + 1, -1);																					// T : O(log n)
		}
		
		return result;
	}
	
	/**
	 * https://www.youtube.com/watch?v=CWDQJGaN1gY
	 * 
	 * 1. find two's complement				<- binary b
	 * 2. add one							<- b + 1																this is what minus i do
	 * 3. & with original number			<- b & original number o
	 * 
	 * get parent
	 * 4. subtract from original number		<- o - b
	 * 
	 * get next
	 * 4. add to original number			<- o + b
	 * */
	/**
	 * for int i <- start; if i is lower than or equal to length; i <- i plus (i & minus i)
	 * 		bit[i] <- bit[i] plus value
	 * end for
	 * */
	public void update(int start, int value) {
		for (int i = start; i <= length; i += (i & -i)) {
			bit[i] += value;
		}
	}
	
	/**
	 * int start <- 0
	 * int end <- length
	 * 
	 * while start is lower than end
	 * 		int mid <- start plus (end minus start) divided by two
	 * 		
	 * 		if getSum(mid) is lower than count
	 * 			start <- mid plus one
	 * 		else
	 * 			end <- mid
	 * 		end if
	 * end while
	 * 
	 * return start
	 * */
	public int binarySearch(int count) {
		int start = 0;
		int end = length;
		
		while (start < end) {
			int mid = start + (end - start) / 2;
			
			if (getSum(mid) < count) {																				// T : O(log n)
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		return start;
	}
	
	/**
	 * int sum <- 0
	 * 
	 * for int i <- start plus one; if i is greater than zero; i <- i minus (i & minus i)
	 * 		sum <- sum plus bit[i]
	 * end for
	 * 
	 * return sum
	 * */
	public int getSum(int start) {
		int sum = 0;
		
		for (int i = start + 1; i > 0; i -= (i & -i)) {
			sum += bit[i];
		}
		
		return sum;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * binary search + binary indexed tree (Fenwick tree)
	 * 
	 * https://leetcode.com/problems/queue-reconstruction-by-height/discuss/427157/Three-different-C%2B%2B-solutions.-from-O(n2)-to-O(nlogn).-faster-than-99.
	 * 
	 * 
	 * Arrays sort(people, (offer, previous) -> if offer[0] is not equal to previous[0] then offer[0] minus previous[0] else previous[1] minus offer[1]
	 * 
	 * length <- people length
	 * bit <- new int[length plus one]
	 * 
	 * int[][] result <- new int[length][]
	 * 
	 * for int i <- 2; if i is lower than or equal to length; i++
	 * 		update(i, one)
	 * end for
	 * 
	 * int msb <- mostSignificantBit(length)
	 * 
	 * for int[] person in people
	 * 		int index <- findLowerBound(person[1], msb)
	 * 		result[index] <- person
	 * 		update(index plus one, minus one)
	 * end for
	 * 
	 * return result
	 * */
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (offer, previous) -> offer[0] != previous[0] ? offer[0] - previous[0] : previous[1] - offer[1]);
		
		length = people.length;
		bit = new int[length + 1];																					// S : O(n + 1)
		
		int[][] result = new int[length][];																			// S : O(n)
		
		for (int i = 2; i <= length; i++) {																			// T : O(n - 2)
			update(i, 1);																							// T : O(log n)
		}
		
		int msb = mostSignificantBit(length);
		
		for (int[] person : people) {																				// T : O(n)
			int index = binarySearch(person[1], msb);																// T : O(log n)
			result[index] = person;
			update(index + 1, -1);																					// T : O(log n)
		}
		
		return result;
	}
	
	/**
	 * int count <- 0
	 * 
	 * while length <- length right shift one is greater than zero
	 * 		count++
	 * end while
	 * 
	 * return count
	 * */
	public int mostSignificantBit(int length) {																		// ideally, start from middle, or from right most
		int count = 0;
		
		while ((length >>= 1) > 0) {
			count++;
		}
		
		return 1 << count;
	}
	
	/**
	 * int start <- 0
	 * int end <- msb
	 * 
	 * while end is not equal to zero
	 * 		int mid <- start plus end
	 * 		end <- end right shift one
	 * 		
	 * 		if mid is lower than bit length && bit[mid] is lower than count 
	 * 			start <- mid
	 * 			count <- count minus bit[mid]
	 * 		end if
	 * end while
	 * 
	 * return start
	 * */
	public int binarySearch(int count, int msb) {
		int start = 0;
		int end = msb;
		
		while (end != 0) {
			int mid = start + end;
			end >>= 1;																								// pointer go left, 4 -> 2 -> 1 -> 0
			
			if (mid < bit.length && bit[mid] < count) {
				start = mid;																						// pointer go right, 4 + 2 -> 6 + 1
				count -= bit[mid];																					// subtract cumulative count
			}
		}
		
		return start;
	}
	
}
