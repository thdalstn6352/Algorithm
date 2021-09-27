package baekjoon.BOJ_11050_이항계수1;

import java.util.Scanner;

public class Main2 {
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		dp = new int[N + 1][K + 1];
		System.out.println(binomial(N, K));
	}
	
	private static int binomial(int n, int r) {
		for(int i = 0; i < n; i++) {
				// 0 ~ i 또는 0 ~ k 까지 중 작은 것을 택함 불필요한 것을 구하지 않기 위해서 
			for(int j = 0; j <= Math.min(i, r); j++) {
				if(j == 0 || j == i) 
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		return dp[n][r];
	}
}
