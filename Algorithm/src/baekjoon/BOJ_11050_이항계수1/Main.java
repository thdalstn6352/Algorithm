package baekjoon.BOJ_11050_이항계수1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(binomial(N, K));
	}
	
	private static int binomial(int n, int k) {
		if(k == 0 || n == k) 
			return 1;
		return binomial(n - 1, k - 1) + binomial(n - 1, k);
	}
}
