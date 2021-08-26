package baekjoon.BOJ_3085;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int res = 0;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		
		for(int r = 0; r < N; r++) {
			String lines = br.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = lines.charAt(c);
			}
		}
		
		calc(map);
		if(res == N) {
			System.out.println(res);
			return;
		}
			
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N - 1; col++) {
				swapRL(row, col, map);
				swapLR(row, col, map);
			}
		}
		
		for(int col = 0; col < N; col++) {
			for(int row = 0; row < N - 1; row++) {
				swapUD(row, col, map);
				swapDU(row, col, map);
			}
		}
		sb.append(res);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}

	
	private static void swapRL(int row, int col, char[][] map) {
		if(map[row][col] != map[row][col+1]) {
			char temp = map[row][col];
			map[row][col] = map[row][col+1];
			map[row][col + 1] = temp;
			calc(map);
		}
	}
	
	private static void swapLR(int row, int col, char[][] map) {
		if(map[row][col] != map[row][col+1]) {
			char temp = map[row][col];
			map[row][col] = map[row][col+1];
			map[row][col + 1] = temp;
		}
	}
	
	
	private static void swapUD(int row, int col, char[][] map) {
		if(map[row][col] != map[row + 1][col]) {
			char temp = map[row][col];
			map[row][col] = map[row + 1][col];
			map[row + 1][col] = temp;
			calc(map);
		}
	}
	private static void swapDU(int row, int col, char[][] map) {
		if(map[row][col] != map[row + 1][col]) {
			char temp = map[row][col];
			map[row][col] = map[row + 1][col];
			map[row + 1][col] = temp;
		}
	}
	
	private static void calc(char[][] map) {
		int count = 0;
		for(int row = 0; row < N; row++) {
			count = 1;
			for(int col = 0; col < N - 1; col++) {
				if(map[row][col] == map[row][col + 1]) {
					count++;
				}
				else {
					res = Math.max(res, count);
					count = 1;
				}
			}
			res = Math.max(res, count);
		}
		
		for(int col = 0; col < N; col++) {
			count = 1;
			for(int row = 0; row < N - 1; row++) {
				if(map[row][col] == map[row+1][col]) {
					count++;
				}
				else {
					res = Math.max(res, count);
					count = 1;
				}
			}
			res = Math.max(res, count);
		}
		
	}
}
