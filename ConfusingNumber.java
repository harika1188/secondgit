package Day1;

/*
 * 
 * 
Input: 20
Output: 6
Explanation: 
The confusing numbers are [6,9,10,16,18,19].
6 converts to 9.
9 converts to 6.
10 converts to 01 which is just 1.
16 converts to 91.
18 converts to 81.
19 converts to 61.
 * 
 */

import java.util.Scanner;


public class ConfusingNumber {

	
	public static int[] valid = {0, 1, 6, 8, 9};
	public static int[] reverse = {0, 1, 2, 3, 4, 5, 9, 7, 8, 6};
	static int res = 0;
	public static int getConfusingNumberCount(int N) {
		dfs(0, N);
		return res;
	}
	public static void dfs(int num, int N) {
		if (isValid(num)) res++;
		for (int i = 0; i < valid.length; i++) {
			if (i == 0 && num == 0) continue;
			// check overflow
			int digit = valid[i];
			if ((Integer.MAX_VALUE - digit) / 10 < num || num * 10 + digit > N) continue;
			dfs(num * 10 + digit, N);
		}
	}
	public static boolean isValid(int num) {
		long rev = 0;
		int copy = num;
		while (num != 0) {
			int digit = num % 10;
			rev = rev * 10 + reverse[digit];
			num /= 10;
		}
		return rev != copy;
	}
	
	public static void main(String args[] ) {
		 Scanner scan = new Scanner(System.in);
			int n=scan.nextInt();
		    System.out.println(getConfusingNumberCount(n));
	}
}
