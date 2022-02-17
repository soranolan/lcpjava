package com.example.lcpjava.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Lcp_347_Top_K_Frequent_Elements {
	
	/**
	 * time  : O(n log k)
	 * space : O(n)
	 * 
	 * Map<Integer, Integer> countMap <- new HashMap
	 * for int number in array
	 * 		countMap put(number, countMap getOrDefault(number, zero) plus one)
	 * end for
	 * 
	 * Queue<Integer> minHeap <- new PriorityQueue<>(Comparator comparingInt(countMap get))
	 * for int number in countMap keySet
	 * 		minHeap offer(number)
	 * 		
	 * 		if minHeap size is greater than k
	 * 			minHeap poll
	 * 		end if
	 * end for
	 * 
	 * int[] result <- new int[k]
	 * for int i <- 0; if i is lower than k; i++
	 * 		result[i] <- minHeap poll
	 * end for
	 * 
	 * return result
	 * */
	public int[] topKFrequent_1(int[] nums, int k) {
		Map<Integer, Integer> countMap = new HashMap<>();															// S : O(n)
		for (int num : nums) {																						// T : O(n)
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);													// T : O(1)
		}
		
		Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(countMap::get));						// S : O(k)
		for (int num : countMap.keySet()) {																			// T : O(n)
			minHeap.offer(num);																						// T : O(log k)
			if (minHeap.size() > k) {																				// T : O(1)
				minHeap.poll();																						// T : O(log k)
			}
		}
		
		int[] result = new int[k];																					// S : O(k)
		for (int i = 0; i < k; i++) {																				// T : O(k)
			result[i] = minHeap.poll();																				// T : O(log k)
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Map<Integer, Integer> countMap <- new HashMap
	 * for int number in array
	 * 		countMap put(number, countMap getOrDefault(number, zero) plus one)
	 * end for
	 * 
	 * int max <- zero
	 * Map<Integer, List<Integer>> groupMap <- new HashMap
	 * for int number in countMap keySet
	 * 		int count <- countMap get(number)
	 * 		max <- Math max(count, max)
	 * 		
	 * 		List<Integer> group <- groupMap getOrDefault(count, new ArrayList<>())
	 * 		group add(number)
	 * 		groupMap put(count, group)
	 * end for
	 * 
	 * int index <- k minus one
	 * int[] result <- new int[k]
	 * for int count <- max; if count is greater than zero; count--
	 * 		if index is lower than zero
	 * 			break
	 * 		end if
	 * 		
	 * 		if groupMap does not containsKey(count)
	 * 			continue
	 * 		end if
	 * 		
	 * 		List<Integer> group <- groupMap get(count)
	 * 		Iterator<Integer> it <- group iterator
	 * 		while it has next && index is greater than or equal to zero
	 * 			result[index--] <- it next
	 * 		end while
	 * end for
	 * 
	 * return result
	 * */
	public int[] topKFrequent_2(int[] nums, int k) {
		Map<Integer, Integer> countMap = new HashMap<>();															// S : O(n)
		for (int num : nums) {																						// T : O(n)
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);													// T : O(1)
		}
		
		int max = 0;
		Map<Integer, List<Integer>> groupMap = new HashMap<>();														// S : O(n)
		for (int num : countMap.keySet()) {																			// T : O(n)
			int count = countMap.get(num);																			// T : O(1)
			max = Math.max(count, max);
			
			List<Integer> group = groupMap.getOrDefault(count, new ArrayList<>());
			group.add(num);																							// T : O(1)
			groupMap.put(count, group);																				// T : O(1)
		}
		
		int index = k - 1;
		int[] result = new int[k];																					// S : O(k)
		for (int count = max; count > 0; count--) {																	// T : O(n)
			if (index < 0) { break; }
			if (!groupMap.containsKey(count)) { continue; }															// T : O(1)
			
			List<Integer> group = groupMap.get(count);																// T : O(1)
			Iterator<Integer> it = group.iterator();
			while (it.hasNext() && index >= 0) { result[index--] = it.next(); }
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Hoare's selection algorithm
	 * Lomuto's Partition Scheme
	 * 
	 * Map<Integer, Integer> countMap <- new HashMap
	 * for int number in array
	 * 		countMap put(number, countMap getOrDefault(number, zero) plus one)
	 * end for
	 * 
	 * int size <- countMap size
	 * int[] unique <- new int[size]
	 * int index <- zero
	 * for int number in countMap keySet
	 * 		unique[index++] <- number
	 * end for
	 * 
	 * quickSelect(zero, size minus one, size minus k)
	 * 
	 * return Arrays copy of range(unique, size minus k, size)
	 * */
	int[] unique;
	Map<Integer, Integer> countMap;
	public int[] topKFrequent_3(int[] nums, int k) {
		countMap = new HashMap<>();																					// S : O(n)
		for (int num : nums) { countMap.put(num, countMap.getOrDefault(num, 0) + 1); }								// T : O(n)
		
		int size = countMap.size();
		unique = new int[size];																						// S : O(n)
		int index = 0;
		for (int num : countMap.keySet()) { unique[index++] = num; }												// T : O(n)
		
		quickSelect(0, size - 1, size - k);
		
		return Arrays.copyOfRange(unique, size - k, size);
	}
	
	/**
	 * if start is equal to end
	 * 		return
	 * end if
	 * 
	 * Random random <- new Random
	 * int pivotIndex <- start plus random nextInt(end minus start)
	 * 
	 * pivotIndex <- partition(start, end, pivotIndex)
	 * 
	 * if pivotIndex is equal to kSmallest
	 * 		return
	 * else if pivotIndex is greater than kSamllest
	 * 		quickSelect(start, pivotIndex minus one, kSmallest)
	 * else
	 * 		quickSelect(pivotIndex plus one, end, kSmallest)
	 * end if
	 * */
	public void quickSelect(int start, int end, int kSmallest) {
		if (start == end) { return; }
		
		Random randomNum = new Random();
		int pivotIndex = start + randomNum.nextInt(end - start);
		
		pivotIndex = partition(start, end, pivotIndex);
		
		if (pivotIndex == kSmallest) {
			return;
		} else if (pivotIndex > kSmallest) {
			quickSelect(start, pivotIndex - 1, kSmallest);
		} else {
			quickSelect(pivotIndex + 1, end, kSmallest);
		}
	}
	
	/**
	 * int pivotCount <- countMap get(unique[pivotIndex])
	 * int storeIndex <- start
	 * swap pivotIndex to end
	 * 
	 * for int i <- start; if i is lower than or equal to end; i++
	 * 		int count <- countMap get(unique[i])
	 * 		
	 * 		if count is greater than or equal to pivotCount
	 * 			continue
	 * 		end if
	 * 		
	 * 		swap i to storeIndex
	 * 		
	 * 		storeIndex++
	 * end for
	 * 
	 * swap storeIndex to end
	 * 
	 * return storeIndex
	 * */
	public int partition(int start, int end, int pivotIndex) {
		int pivotCount = countMap.get(unique[pivotIndex]);
		int storeIndex = start;
		swap(pivotIndex, end);
		
		for (int i = start; i <= end; i++) {
			int count = countMap.get(unique[i]);
			if (count >= pivotCount) { continue; }
			swap(storeIndex, i);
			storeIndex++;
		}
		
		swap(storeIndex, end);
		
		return storeIndex;
	}
	
	/**
	 * int temp <- unique[left]
	 * unique[left] <- unique[right]
	 * unique[right] <- temp
	 * */
	public void swap(int left, int right) {
		int temp = unique[left];
		unique[left] = unique[right];
		unique[right] = temp;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int max <- Integer min value
	 * int min <- Integer max value
	 * 
	 * for int number in array
	 * 		min <- Math min(number, min)
	 * 		max <- Math max(number, max)
	 * end for
	 * 
	 * int[] bucket <- new int[max minus min plus one]
	 * 
	 * for int number in array
	 * 		bucket[number minus min] <- bucket[number minus min] plus one
	 * end for
	 * 
	 * int size <- array length plus one
	 * List<List<Integer>> groups <- new ArrayList<List<Integer>>(size)
	 * 
	 * for int i <- 0; if i is lower than size; i++
	 * 		groups add(new ArrayList<>())
	 * end for
	 * 
	 * for int i <- 0; if i is lower than bucket length; i++
	 * 		int count <- bucket[i]
	 * 		
	 * 		if count is equal to zero
	 * 			continue
	 * 		end if
	 * 		
	 * 		int number <- min plus i
	 * 		groups get(count) add(number)
	 * end for
	 * 
	 * int index <- k minus one
	 * int[] result <- new int[k]
	 * for int i <- groups size minus one; if i is greater than or equal to zero; i--
	 * 		if index is lower than zero
	 * 			break
	 * 		end if
	 * 		
	 * 		List<Integer> group <- groups get(i)
	 * 		
	 * 		if group size is equal to zero
	 * 			continue
	 * 		end if
	 * 		
	 * 		Iterator<Integer> it <- group to iterator
	 * 		while it has next && index is greater than or equal to zero
	 * 			result[index] <- it next();
	 * 			index--;
	 * 		end while
	 * end for
	 * 
	 * return result
	 * */
	public int[] topKFrequent(int[] nums, int k) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int num : nums) {																						// T : O(n)
			min = Math.min(num, min);
			max = Math.max(num, max);
		}
		
		int[] bucket = new int[max - min + 1];																		// S : O(max - min)
		for (int num : nums) { bucket[num - min]++; }																// T : O(n)
		
		int size = nums.length + 1;
		List<List<Integer>> groups = new ArrayList<List<Integer>>(size);											// S : O(n + 1)
		for (int i = 0; i < size; i++) { groups.add(new ArrayList<>()); }											// T : O(n + 1)
		
		for (int i = 0; i < bucket.length; i++) {																	// T : O(max - min)
			int count = bucket[i];
			if (count == 0) { continue; }
			
			int num = min + i;
			groups.get(count).add(num);
		}
		
		int index = k - 1;
		int[] result = new int[k];																					// S : O(k)
		for (int i = groups.size() - 1; i >= 0; i--) {																// T : O(n)
			if (index < 0) { break; }
			
			List<Integer> group = groups.get(i);
			if (group.size() == 0) { continue; }
			
			Iterator<Integer> it = group.iterator();
			while (it.hasNext() && index >= 0) { result[index--] = it.next(); }
		}
		
		return result;
	}
	
}
