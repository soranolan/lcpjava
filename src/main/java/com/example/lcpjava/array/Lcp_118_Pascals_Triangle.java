package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.List;

public class Lcp_118_Pascals_Triangle {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n ^ 2)
	 * 
	 * List<List<Integer>> outer
	 * List<Integer> inner
	 * 
	 * for int i <- 0 to numRows
	 * 		for int j <- inner size minus one to zero
	 * 			inner set (j, inner get (j) plus inner get (j - 1))
	 * 		end for
	 * 		inner add one
	 * 		List<Integer> clone inner
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
			inner.add(1);																							// T : amortized O(1); S : O(n)
			List<Integer> clone = new ArrayList<>(inner);															// S : O(n)
			outer.add(clone);																						// T : amortized O(1); S : O(n)
		}
		
		return outer;
	}
	
	public static void main(String[] args) {
		Lcp_118_Pascals_Triangle lcp = new Lcp_118_Pascals_Triangle();
		int input = -1;
		List<List<Integer>> output = null;
		
		// [ [ 1 ], [ 1, 1 ], [ 1, 2, 1 ], [ 1, 3, 3, 1 ], [ 1, 4, 6, 4, 1 ] ]
		input = 5;
		output = lcp.generate(input);
		System.out.println(output);
		
		// [ [ 1 ] ]
		input = 1;
		output = lcp.generate(input);
		System.out.println(output);
	}
	
}
