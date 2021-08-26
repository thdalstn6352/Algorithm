package baekjoon.BOJ_9613;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] input;
	static int[] numbers;
	static int R = 2;
	static int N;
	static long sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= testCase; tc++) {
			String[] lines = br.readLine().split(" ");
			int cnt = Integer.parseInt(lines[0]);
			N = cnt;
			input = new int[cnt];
			numbers = new int[R];
			
			for(int i = 0; i < cnt; i++) {
				input[i] = Integer.parseInt(lines[i+1]);
			}
			combination(0, 0);
			sb.append(sum).append("\n");
			sum = 0;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == R) {
			sum += getGCD(numbers[0], numbers[1]);
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}
	
	public static int getGCD(int num1, int num2) {
		int remain = num1 % num2;
		if(remain == 0)
			return num2;
		return getGCD(num2, remain);
	}
}
