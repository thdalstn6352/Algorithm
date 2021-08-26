package baekjoon.BOJ_1992;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			String lines = br.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = lines.charAt(c) - '0';
			}
		}
		
		calcQuadTree(N, 0, 0);
		bw.write(sb.toString());
		bw.flush();
	
	}
	
	public static void calcQuadTree(int size, int x, int y) {

		if(isCompression(size, x, y)) {
			sb.append(map[x][y]);
			return;
		}
		
		int newSize = size / 2;	
		
		sb.append('(');
		
		calcQuadTree(newSize, x, y);						// 1사분면
		calcQuadTree(newSize, x, y + newSize);				// 2사분면
		calcQuadTree(newSize, x + newSize, y);				// 3사분면
		calcQuadTree(newSize, x + newSize, y + newSize);	// 4사분면
		
		sb.append(')');
	}
	
	public static boolean isCompression(int size, int x, int y) {
		int value = map[x][y];
		
		for(int r = x; r < x + size; r++) {
			for(int c = y; c < y + size; c++) {
				if(value != map[r][c]) {
					return false;
				}
			}
		}
		return true;
	}
 
}