package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.List;

public class Lcp_118_Pascals_Triangle {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n ^ 2)
	 * 
	 * List<List<Integer>> outer <- empty list
	 * List<Integer> inner <- empty list
	 * 
	 * for int i <- 0; if i is lower than numRows; i++
	 * 		for int j <- inner size minus one; if j is greater than zero; j--
	 * 			inner set (j, inner get (j) plus inner get (j - 1))
	 * 		end for
	 * 		inner add one
	 * 		List<Integer> clone <- clone inner
	 * 		outer add clone
	 * end for
	 * 
	 * return outer
	 * */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> outer = new ArrayList<>();
		List<Integer> inner = new ArrayList<>();
		
		for (int i = 0; i < numRows; i++) {																			// T : O(n)
			for (int j = inner.size() - 1; j > 0; j--) {															// T : O(n)
				inner.set(j, inner.get(j) + inner.get(j - 1));														// T : O(1)
			}
			inner.add(1);																							// T : O(α(n)); S : O(n)
			List<Integer> clone = new ArrayList<>(inner);															// S : O(n)
			outer.add(clone);																						// T : O(α(n)); S : O(n)
		}
		
		return outer;
	}
	
}
