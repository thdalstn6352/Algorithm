package baekjoon.BOJ_1463_1로만들기;

import java.util.Scanner;

public class Main2 {
	static Integer[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		dp = new Integer[N+1];
		
		dp[0] = 0;
		dp[1] = 0;
		
		System.out.println(calc(N));
	}
	private static int calc(int num) {
		if(dp[num] == null) {
			dp[num] = calc(num - 1) + 1;
			
			if(num % 2 == 0)
				dp[num] = Math.min(dp[num], calc(num / 2) + 1);
			if(num % 3 == 0)
				dp[num] = Math.min(dp[num], calc(num / 3) + 1);
		}
		return dp[num];
	}
}
