package baekjoon.BOJ_10972_다음순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int[] numbers;
	static int[] inputs;
	static String target;
	static int target_flag = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		inputs = new int[N];
		String[] msg = br.readLine().split(" ");
		for(String s : msg)
			sb.append(s).append(" ");
		target = sb.toString();

		StringBuilder temp = new StringBuilder();
		
		for(int i = 0; i < N; i++){
			inputs[i] = i+1;
			temp.append(N - i).append(" ");
		}
		
		if(target.equals(temp.toString()))
			System.out.println(-1);
		
		permutation(0, 0);
		
	}
	public static void permutation(int cnt, int flag) {
		if(cnt == N) {
			StringBuilder sb = new StringBuilder();
			for(int val : numbers) {
				sb.append(val).append(" ");
			}
			if(target_flag == 1) {
				System.out.println(sb.toString());
				System.exit(0);
			}
			
			
			if(sb.toString().equals(target))
				target_flag = 1;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((flag & 1 << i) != 0)
				continue;
			numbers[cnt] = inputs[i];
			permutation(cnt+1, flag | 1 << i);
		}
	}
}
