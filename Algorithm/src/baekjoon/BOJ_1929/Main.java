package baekjoon.BOJ_1929;

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

		String[] numbers = br.readLine().split(" ");
		int startNum = Integer.parseInt(numbers[0]);
		int endNum = Integer.parseInt(numbers[1]);
		
		int[] nums = new int[10000001];
		
		for(int num = 1; num <= endNum; num++) {
			nums[num] = num;
		}
		nums[1] = 0;
		
		for(int i = 2; i <= Math.sqrt(endNum); i++) {
			if(nums[i] == 0)
				continue;
			for(int j = i*2; j <= endNum; j+=i) {
				nums[j] = 0;
			}
		}
		
		for(int n = startNum; n <= endNum; n++) {
			if(nums[n] != 0)
				sb.append(nums[n]).append("\n");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
	
	}
}
