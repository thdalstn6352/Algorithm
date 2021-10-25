package baekjoon.BOJ_1932_정수삼각형;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N][N];
		int[][] temp = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < r + 1; c++) {
				temp[r][c] = Integer.parseInt(lines[c]);
			}
		}
		
		dp[0][0] = temp[0][0];
		
		for(int r = 1; r < N; r++) {
			for(int c = 0; c < r + 1; c++) {
				if(c == 0)
					dp[r][c] = dp[r-1][c] + temp[r][c];
				else if(c == r)
					dp[r][c] = dp[r-1][c-1] + temp[r][c];
				else
					dp[r][c] = temp[r][c] + Math.max(dp[r-1][c-1], dp[r-1][c]);
			}
		}
		
		int max = 0;
		
		for(int c = 0; c < N; c++) {
			max = Math.max(max, dp[N-1][c]);
		}
		System.out.println(max);
		
	}
}
