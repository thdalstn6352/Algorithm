package baekjoon.BOJ_15649;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] input;
	static int[] numbers;
	static boolean[] isSelected;
	
	static int N, R;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] msg = br.readLine().split(" ");
		N = Integer.parseInt(msg[0]);
		R = Integer.parseInt(msg[1]);
		numbers = new int[R];
		isSelected = new boolean[N + 1];

		permutation(0);
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void permutation(int cnt) {
		if(cnt == R) {
			for(int n : numbers) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(isSelected[i])
				continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
