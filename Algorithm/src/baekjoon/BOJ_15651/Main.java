package baekjoon.BOJ_15651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int N, R;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] msg = br.readLine().split(" ");
		N = Integer.parseInt(msg[0]);
		R = Integer.parseInt(msg[1]);
		numbers = new int[R];
		permutation(0);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
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
			numbers[cnt] = i;
			permutation(cnt+1);
		}

	}
}
