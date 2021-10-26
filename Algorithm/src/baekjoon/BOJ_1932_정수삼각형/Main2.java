package baekjoon.BOJ_1932_정수삼각형;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N][N];
		
		int max = 0;
		dp[0][0] = Integer.parseInt(br.readLine());
		
		for(int r = 1; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < r + 1; c++) {
				dp[r][c] = Integer.parseInt(lines[c]);
				if(c == 0)
					dp[r][c] += dp[r-1][c];
				else if(c == r)
					dp[r][c] += dp[r-1][c-1];
				else
					dp[r][c] += Math.max(dp[r-1][c-1], dp[r-1][c]);
				
				max = Math.max(max, dp[r][c]);
			}
		}
		
		System.out.println(max);
		
	}
}
