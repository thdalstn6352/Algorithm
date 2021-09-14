package baekjoon.BOJ_1149_RGB거리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[][] dp;
	static int[][] cost;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		cost = new int[N + 1][3];
		dp = new int[N + 1][3];
		
		for(int i = 1; i <= N; i++) {
			String[] lines = br.readLine().split(" ");
			for(int color = 0; color < 3; color++) { // 0: 빨 / 1: 초 / 2: 파
				cost[i][color] = Integer.parseInt(lines[color]);
			}
		}
		
		dp[1][0] = cost[1][0];
		dp[1][1] = cost[1][1];
		dp[1][2] = cost[1][2];
		
		System.out.println(Math.min(calc(N, 0), Math.min(calc(N, 1), calc(N, 2))));
	}
	
	private static int calc(int floor, int color) {
		if(dp[floor][color] == 0) {
			if(color == 0) {
				dp[floor][0] = Math.min(calc(floor - 1, 1), calc(floor - 1, 2)) + cost[floor][0];
			}
			else if(color == 1) {
				dp[floor][1] = Math.min(calc(floor - 1, 0), calc(floor - 1, 2)) + cost[floor][1];
			}
			else {
				dp[floor][2] = Math.min(calc(floor - 1, 0), calc(floor - 1, 1)) + cost[floor][2];
			}
		}
		return dp[floor][color];
	}
}
