package com.example.lcpjava.math;

public class Lcp_858_Mirror_Reflection {
	
	/**
	 * p = 3
	 * q = 2
	 * 
	 * 2 * p = 3 * q
	 * m * p = n * q
	 * 
	 * m = 2 = q
	 * n = 3 = p
	 * */
	/**
	 * time  : O(log(min(p, q)))
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/mirror-reflection/discuss/146336/Java-solution-with-an-easy-to-understand-explanation
	 * https://leetcode.com/problems/mirror-reflection/discuss/141773/C%2B%2BJavaPython-1-line-without-using-any-package-or
	 * */
	public int mirrorReflection(int p, int q) {
		int m = q;
		int n = p;
		
		while (m % 2 == 0 && n % 2 == 0) {
			m /= 2;
			n /= 2;
		}
		
		if (m % 2 == 0 && n % 2 == 1) { return 0; }
		if (m % 2 == 1 && n % 2 == 1) { return 1; }
		if (m % 2 == 1 && n % 2 == 0) { return 2; }
		
		return -1;
	}
	
	/**
	 * by point
	 * 
	 * https://leetcode.com/problems/mirror-reflection/discuss/141790/The-Most-Straight-Forward-Solution.Pure-Math.Only-13ms
	 * */
	
}
