package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_435_Non_overlapping_Intervals {
	
	/**
	 * time  : O(n log n)
	 * space : O(1)
	 * 
	 * sort by start time
	 * */
	public int eraseOverlapIntervals_1(int[][] intervals) {
		Arrays.sort(intervals, (offer, previous) -> offer[0] - previous[0]);										// T : O(n log n)
		
		int rooms = intervals.length;
		int lastStart = intervals[rooms - 1][0];
		int booked = 1;
		
		for (int i = rooms - 2; i >= 0; i--) {																		// T : O(n)
			int previousStart = intervals[i][0];
			int previousEnd = intervals[i][1];
			
			if (previousEnd <= lastStart) {
				lastStart = previousStart;
				booked++;
			}
		}
		
		return rooms - booked;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(1)
	 * 
	 * sort by end time
	 * 
	 * https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most
	 * https://leetcode.com/problems/non-overlapping-intervals/discuss/282743/Java-updated-solution-based-on-the-top-voted-post
	 * 
	 * compare previous end time with next start time,
	 * if is valid, no overlap, then keep it.
	 * */
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (offer, previous) -> offer[1] - previous[1]);										// T : O(n log n)
		
		int rooms = intervals.length;
		int previousEnd = intervals[0][1];
		int booked = 1;
		
		for (int i = 1; i < rooms; i++) {																			// T : O(n)
			int nextStart = intervals[i][0];
			int nextEnd = intervals[i][1];
			
			if (nextStart >= previousEnd) {
				previousEnd = nextEnd;
				booked++;
			}
		}
		
		return rooms - booked;
	}
	
}
