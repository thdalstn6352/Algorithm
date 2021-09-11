package baekjoon.BOJ_10972_다음순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
	
		N = sc.nextInt();
		int[] input = new int[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		if(np(input)) {
			for(int a : input) {
				sb.append(a).append(" ");
			}
			bw.write(sb.toString());
			bw.flush();
		}
		else
			System.out.println(-1);
		
		bw.close();
		bw = null;
	}
	
	private static boolean np(int[] input) {
		int idx = N - 1;
		
		while(idx > 0 && input[idx -1] >= input[idx])
			idx--;
		
		if(idx == 0)
			return false;
		
		int target = N - 1;
		
		while(input[idx - 1] >= input[target])
			target--;
		
		swap(input, idx -1, target);
		
		int loc = N - 1;
		
		while(idx < loc) {
			swap(input, idx, loc);
			idx++;
			loc--;
		}
		return true;
		
	}
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
