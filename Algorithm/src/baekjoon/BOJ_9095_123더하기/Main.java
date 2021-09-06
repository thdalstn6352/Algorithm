package baekjoon.BOJ_9095_123더하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int[] dp = new int[4];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int value = Integer.parseInt(br.readLine());
			if(value < 4)
				sb.append(dp[value]).append("\n");
			else
				sb.append(recur(value)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	public static int recur(int value) {
		if(value == 1)
			return 1;
		else if(value == 2)
			return 2;
		else if(value == 3)
			return 4;
		
		else
			return recur(value - 3) + recur(value - 2) + recur(value - 1);
	}
}
