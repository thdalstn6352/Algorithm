package sw_expert.SWEA_3307_최장증가부분수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N];
			int max = 0;
			dp[0] = 1;
			
			String[] lines = br.readLine().split(" ");

			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(lines[i]);
			}
			
			for(int i = 1; i < N; i++) {
				dp[i] = 1;
				for(int j = 0; j < i; j++) {
					if(arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
				max = Math.max(dp[i], max);
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}
}