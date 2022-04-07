package com.example.lcpjava.array;

public class Lcp_495_Teemo_Attacking {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int seconds <- 0
	 * int length <- timeSeries length
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		if i plus one is lower than length
	 * 			int time <- timeSeries[i plus one] minus timeSeries[i]
	 * 			
	 * 			if time is lower than duration
	 * 				seconds <- seconds plus time
	 * 			else
	 * 				seconds <- seconds plus duration
	 * 			end if
	 * 		else
	 * 			seconds <- seconds plus duration
	 * 		end if
	 * end for
	 * 
	 * return seconds
	 * */
	public int findPoisonedDuration_1(int[] timeSeries, int duration) {
		int seconds = 0;
		int length = timeSeries.length;
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			if (i + 1 < length) {
				int time = timeSeries[i + 1] - timeSeries[i];
				
				if (time < duration) {
					seconds += time;
				} else {
					seconds += duration;
				}
			} else {																								// last one
				seconds += duration;
			}
		}
		
		return seconds;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int seconds <- 0
	 * int length <- timeSeries length
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		if i plus one is lower than length
	 * 			seconds <- seconds plus Math min(timeSeries[i plus one] minus timeSeries[i], duration) 
	 * 		else
	 * 			seconds <- seconds plus duration
	 * 		end if
	 * end for
	 * 
	 * return seconds
	 * */
	public int findPoisonedDuration_2(int[] timeSeries, int duration) {
		int seconds = 0;
		int length = timeSeries.length;
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			if (i + 1 < length) {
				seconds += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
			} else {																								// last one
				seconds += duration;
			}
		}
		
		return seconds;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int seconds <- 0
	 * 
	 * for int i <- 0; if i is lower than timeSeries length minus one; i++
	 * 		seconds <- seconds plus Math min(timeSeries[i plus one] minus timeSeries[i], duration) 
	 * end for
	 * 
	 * seconds <- seconds plus duration
	 * 
	 * return seconds
	 * */
	public int findPoisonedDuration_3(int[] timeSeries, int duration) {
		int seconds = 0;
		
		for (int i = 0; i < timeSeries.length - 1; i++) {															// T : O(n - 1)
			seconds += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
		}
		
		seconds += duration;																						// last one
		
		return seconds;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int seconds <- duration
	 * 
	 * for int i <- 1; if i is lower than timeSeries length; i++
	 * 		seconds <- seconds plus Math min(timeSeries[i] minus timeSeries[i minus one], duration) 
	 * end for
	 * 
	 * return seconds
	 * */
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		int seconds = duration;																						// last one
		
		for (int i = 1; i < timeSeries.length; i++) {																// T : O(n - 1)
			seconds += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
		}
		
		return seconds;
	}
	
}
