package baekjoon.BOJ_10974_모든순열;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
//	static int N;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] input = new int[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		
		do {
			for(int val : input) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			
		}while(np(input, N));
		
		bw.write(sb.toString());
		bw.flush();
		
	}
	private static boolean np(int[] input, int N) {
		int i = N - 1;
		
		while(i > 0 && input[i - 1] > input[i])
			i--;
		
		if(i == 0)
			return false;
		
		int j = N - 1;
		
		while(input[i - 1] > input[j])
			j--;
		
		swap(input, i - 1, j);
		
		int k = N - 1;
		
		while(i < k) {
			swap(input, i++, k--);
		}
		return true;
		
	}
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
