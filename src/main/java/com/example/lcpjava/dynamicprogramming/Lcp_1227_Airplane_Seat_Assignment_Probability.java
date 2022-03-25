package com.example.lcpjava.dynamicprogramming;

public class Lcp_1227_Airplane_Seat_Assignment_Probability {
	
	/**
	 * https://leetcode.com/problems/airplane-seat-assignment-probability/discuss/414864/True-formula-and-explanations-for-all-other-formulas.
	 * 
	 * 
	 * A B C D E
	 *   2 3 1  
	 * 
	 * =============================================================================================================
	 * 
	 * f(n) = 1 / n																									1st person's chance pick A
	 *      + 1 / n * 0																								1st person's chance pick E
	 *      + (n - 2) / n * (																						1st person's chance pick B C D, total chance minus (A + E)
	 *      					1 / (n - 2) * f(n - 1)																1st person's chance pick B (times), then 2nd person can pick randomly, so there are total minus B seats left (subproblem)
	 *      					1 / (n - 2) * f(n - 2)																1st person's chance pick C, 2nd person pick his own B (times), then 3rd person will pick randomly, total minus (B + C) seats left
	 *      					...																					
	 *      					1 / (n - 2) * f(2)																	1st person's chance pick D, 2nd pick B, 3rd pick C (times), then there are (A + E) seats left
	 *      )
	 *      
	 *      = 1 / n + ((n - 2) / n) * (1 / (n - 2)) * (f(n - 1) + f(n - 2) + ... + f(2))
	 *      
	 *      n - 2      1       1
	 *      ¢w¢w¢w¢w¢w X ¢w¢w¢w¢w¢w¢w¢w = ¢w¢w¢w																					eq0
	 *        n      n - 2     n
	 *      
	 *      = 1 / n + 1 / n * (f(n - 1) + f(n - 2) + ... + f(2))													eq1
	 * 
	 * =============================================================================================================
	 * 
	 *       n * f(n)     = 1 + f(n - 1) + f(n - 2) + ... + f(2)													eq2 = n * eq1
	 * (n + 1) * f(n + 1) = 1 + f(n) + f(n - 1) + ... + f(2)														eq3 = eq2(n + 1)
	 * (n + 1) * f(n + 1) = f(n) + n * f(n)																			eq3 - eq2
	 * (n + 1) * f(n + 1) = (n + 1) * f(n)
	 *           f(n + 1) = f(n)																					eq4
	 * 
	 * =============================================================================================================
	 * 
	 * (n - 1) * f(n - 1) = 1 + f(n - 2) + f(n - 3) + ... + f(2)													eq5
	 *                    = n * f(n) - f(n - 1)																		eq5 - eq2
	 *       n * f(n - 1) = n * f(n)
	 *           f(n - 1) = f(n)																					eq6
	 * 
	 * =============================================================================================================
	 * 
	 *           n - 2 > 0																							eq7 by eq0
	 *           n > 2
	 *           f(4)     = f(3)																					eq8 by eq4
	 *           f(2)     = f(3)																					eq9 by eq6
	 * 
	 * =============================================================================================================
	 * 
	 *       n * f(n)     = 1 + f(n - 1) + f(n - 2) + ... + f(2)													by eq2
	 *                    = 1 + f(n) + f(n) + ... + f(n)															by eq4 eq6 eq7 eq8 eq9
	 *                    = 1 + (n - 2) * f(n)																		eq10
	 * 
	 * =============================================================================================================
	 * 
	 * when n = 2
	 * 2 * f(2) = 1 + 0 * f(2)																						by eq10
	 * f(2) = 1 / 2
	 * */
	public double nthPersonGetsNthSeat(int n) {
		return (n == 1) ? 1 : 0.5;
	}
	
}
