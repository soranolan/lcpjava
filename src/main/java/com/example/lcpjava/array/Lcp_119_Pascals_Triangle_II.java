package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.List;

public class Lcp_119_Pascals_Triangle_II {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n ^ 2)
	 * 
	 * List<List<Integer>> outer <- empty list
	 * List<Integer> inner <- empty list
	 * 
	 * for int i <- 0; if i is lower than or equal to index; i--
	 * 		for int j <- inner size minus one; if j is greater than zero; j--
	 * 			inner set(j, inner get(j) plus inner get(j minus one))
	 * 		end for
	 * 		inner add one
	 * 		List<Integer> clone <- clone inner
	 * 		outer add clone
	 * end for
	 * 
	 * return outer get index
	 * */
	public List<Integer> getRow_1(int rowIndex) {
		List<List<Integer>> outer = new ArrayList<>();
		List<Integer> inner  = new ArrayList<>();
		
		for (int i = 0; i <= rowIndex; i++) {																		// T : O(n)
			for (int j = inner.size() - 1; j > 0; j--) {															// T : O(m)
				inner.set(j, inner.get(j) + inner.get(j - 1));														// T : O(1)
			}
			inner.add(1);																							// T : O(£\(n)); S : O(n)
			List<Integer> clone = new ArrayList<>(inner);															// S : O(n)
			outer.add(clone);																						// T : O(£\(n)); S : O(n)
		}
		
		return outer.get(rowIndex);
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * List<Integer> result <- empty list
	 * 
	 * for int i <- 0; if i is lower than or equal to index; i++
	 * 		for int j <- result size minus one; if j is greater than zero; j--
	 * 			result set(j, result get(j) plus result get(j minus one))
	 * 		end for
	 * 		result add one
	 * end for
	 * 
	 * return result
	 * */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i <= rowIndex; i++) {																		// T : O(n)
			for (int j = result.size() - 1; j > 0; j--) {															// T : O(m)
				result.set(j, result.get(j) + result.get(j - 1));													// T : O(1)
			}
			result.add(1);																							// T : O(£\(n)); S : O(n)
		}
		
		return result;
	}
	
}
