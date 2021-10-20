package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test02 {
	static int N;
	static int[][] result;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			result = new int[N][N];
			
			String[] lines = br.readLine().split(" ");
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == j || Math.abs(i - j) == 1 || Math.abs(i - j) == N - 1)
						result[i][j] = -1;
					else {
						result[i][j] = (int) (Math.pow(Integer.parseInt(lines[i]) + Integer.parseInt(lines[j]), 2));
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N-1; j++) {
					if(i == j || Math.abs(i - j) == 1 || Math.abs(i - j) == N - 1) continue;
					//System.out.println(i + " " + j);
					calc(i, j);
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			max=0;
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	private static void calc(int A, int B) {
		int value1 = result[A][B];
		int value2 = 0;
		
		int start = B + 2 > N ? (B + 2) % 10 : B + 2;
		int end = A - 2 < 0 ? N + (A - 2) : A - 2;
		
		
		for(int i = start; i <= end; i++) {
			for(int j = start; j <= end; j++) {
				if(i == j || Math.abs(i - j) == 1 || Math.abs(i - j) == N - 1)
					continue;
				value2 = result[i][j];
				int val = value1 + value2;
				max = Math.max(max, val);
			}
		}
			
	}
}
