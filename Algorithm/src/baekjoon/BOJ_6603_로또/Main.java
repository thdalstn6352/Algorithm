package baekjoon.BOJ_6603_로또;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int[] input;
	static int[] numbers;
	static int N;
	static StringBuilder sb; 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		sb = new StringBuilder();
		
		while(true) {
			N = sc.nextInt();
			if(N == 0)
				break;
			input = new int[N];
			numbers = new int[6];
			
			for(int i = 0; i < N; i++) {
				input[i] = sc.nextInt();
			}
			combination(0, 0);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == 6) {
			for(int val : numbers) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
	}
}
