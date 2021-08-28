package baekjoon.BOJ_2559_수열;

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
	
		String[] msg = br.readLine().split(" ");
		int N = Integer.parseInt(msg[0]);
		int K = Integer.parseInt(msg[1]);
		
		String[] nums = br.readLine().split(" ");

		int max = 0;
		int sum = 0;
		
		for(int i = 0; i < K; i++) {
			sum += Integer.parseInt(nums[i]);
		}
		max = sum;
		
		for(int j = K; j < N; j++) {
			sum -= Integer.parseInt(nums[j - K]);
			sum += Integer.parseInt(nums[j]);
			max = Math.max(max, sum);
		}
		
		sb.append(max);
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}
