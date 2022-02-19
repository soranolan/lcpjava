package com.example.lcpjava.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_451_Sort_Characters_By_Frequency {
	
	/**
	 * time  : O(n)
	 * space : O(n + m)
	 * 
	 * Map<Character, Integer> countMap <- new HashMap
	 * 
	 * for char c in s to char array
	 * 		countMap put(c, countMap getOrDefault(c, zero) plus one)
	 * end for
	 * 
	 * Queue<Character> maxHeap <- new PriorityQueue<>((offer, previous) -> countMap get(previous) minus countMap get(offer))
	 * for char c in countMap keySet
	 * 		maxHeap offer(c)
	 * end for
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * while maxHeap is not empty
	 * 		char c <- maxHeap poll
	 * 		int count <- countMap get(c)
	 * 		
	 * 		for int i <- 0; if i is lower than count; i++
	 * 			sb append(c)
	 * 		end for
	 * end while
	 * 
	 * return sb to string
	 * */
	public String frequencySort_1(String s) {
		Map<Character, Integer> countMap = new HashMap<>();															// S : O(m)
		for (char c : s.toCharArray()) { countMap.put(c, countMap.getOrDefault(c, 0) + 1); }						// T : O(n)
		
		Queue<Character> maxHeap = new PriorityQueue<>(Comparator.comparingInt(countMap::get).reversed());			// S : O(m)
		for (char c : countMap.keySet()) {																			// T : O(m)
			maxHeap.offer(c);																						// T : O(m log m)
		}
		
		StringBuilder sb = new StringBuilder();																		// S : O(n)
		while (!maxHeap.isEmpty()) {																				// T : O(n)
			char c = maxHeap.poll();																				// T : O(1)
			int count = countMap.get(c);																			// T : O(1)
			
			for (int i = 0; i < count; i++) { sb.append(c); }
		}
		
		return sb.toString();
	}
	
	/**
	 * time  : O(n)
	 * space : O(n + m)
	 * 
	 * Map<Character, Integer> countMap <- new HashMap
	 * 
	 * for char c in s to char array
	 * 		countMap put(c, countMap getOrDefault(c, zero) plus one)
	 * end for
	 * 
	 * int size <- s length plus one
	 * List<List<Character>> buckets <- new ArrayList<List<Character>>(size)
	 * 
	 * for int i <- 0; if i is lower than size; i++
	 * 		buckets add(new ArrayList<>())
	 * end for
	 * 
	 * for char c in countMap keySet
	 * 		int count <- countMap get(c)
	 * 		buckets get(count) add(c)
	 * end for
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * 
	 * for int count <- buckets size minus one; if count is greater than or equal to zero; count--
	 * 		List<Character> bucket <- buckets get(count)
	 * 		
	 * 		if bucket size is equal to zero
	 * 			continue
	 * 		end if
	 * 		
	 * 		Iterator<Character> it <- bucket iterator
	 * 		
	 * 		while it has next
	 * 			char c <- it next
	 * 			
	 * 			for int i <- 0; if i is lower than count; i++
	 * 				sb append(c)
	 * 			end for
	 * 		end while
	 * end for
	 * 
	 * return sb to string
	 * */
	public String frequencySort_2(String s) {
		Map<Character, Integer> countMap = new HashMap<>();															// S : O(m)
		for (char c : s.toCharArray()) { countMap.put(c, countMap.getOrDefault(c, 0) + 1); }						// T : O(n)
		
		int size = s.length() + 1;
		List<List<Character>> buckets = new ArrayList<List<Character>>(size);										// S : O(n + 1)
		for (int i = 0; i < size; i++) { buckets.add(new ArrayList<>()); }											// T : O(n + 1)
		
		for (char c : countMap.keySet()) {																			// T : O(m)
			int count = countMap.get(c);																			// T : O(1)
			buckets.get(count).add(c);																				// T : O(1)
		}
		
		StringBuilder sb = new StringBuilder();
		for (int count = buckets.size() - 1; count >= 0; count--) {													// T : O(n)
			List<Character> bucket = buckets.get(count);															// T : O(1)
			if (bucket.size() == 0) { continue; }
			
			Iterator<Character> it = bucket.iterator();
			while (it.hasNext()) {
				char c = it.next();
				for (int i = 0; i < count; i++) { sb.append(c); }
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * time  : O(n * 128)
	 * space : O(n)
	 * 
	 * char[] result <- new char[s length]
	 * int[] bucket <- new int[128]
	 * 
	 * for char c in s to char array
	 * 		bucket[c] <- bucket[c] plus one
	 * end for
	 * 
	 * int i <- 0
	 * int length <- result length
	 * 
	 * while i is lower than length
	 * 		int maxCount <- 0
	 * 		char c <- ' '
	 * 		
	 * 		for int j <- 0; if j is lower than 128; j++
	 * 			int count <- bucket[j]
	 * 			
	 * 			if count is lower than or equal to maxCount
	 * 				continue
	 * 			end if
	 * 			
	 * 			maxCount <- count
	 * 			c <- j to char
	 * 		end for
	 * 		
	 * 		if maxCount is equal to zero
	 * 			return String value of result
	 * 		end if
	 * 		
	 * 		for int count <- 0; if count is lower than maxCount; count++
	 * 			result[i] <- c
	 * 			i++
	 * 		end for
	 * 		
	 * 		bucket[c] <- zero
	 * end while
	 * 
	 * return String value of result
	 * */
	public String frequencySort(String s) {
		char[] result = new char[s.length()];																		// S : O(n)
		int[] bucket = new int[128];																				// S : O(128)
		for (char c : s.toCharArray()) { bucket[c]++; }																// T : O(n)
		
		int i = 0;
		int length = result.length;
		while (i < length) {																						// T : O(n)
			int maxCount = 0;
			char c = ' ';
			
			for (int j = 0; j < 128; j++) {																			// T : O(128)
				int count = bucket[j];
				if (count <= maxCount) { continue; }
				
				maxCount = count;
				c = (char) j;
			}
			
			if (maxCount == 0) { return String.valueOf(result); }
			
			for (int count = 0; count < maxCount; count++) { result[i++] = c; }
			bucket[c] = 0;
		}
		
		return String.valueOf(result);
	}
	
}
