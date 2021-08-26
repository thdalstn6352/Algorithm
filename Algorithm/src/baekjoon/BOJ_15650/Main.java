package baekjoon.BOJ_15650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
		
		combination(0, 1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == R) {
			for(int n : numbers)
				sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
			
	}
}
