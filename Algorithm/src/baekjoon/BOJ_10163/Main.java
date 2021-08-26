package baekjoon.BOJ_10163;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[1001][1001];
		int[] count = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			String[] lines = br.readLine().split(" ");
			int x = Integer.parseInt(lines[0]);
			int y = Integer.parseInt(lines[1]);
			int width = Integer.parseInt(lines[2]);
			int height = Integer.parseInt(lines[3]);
			
			int nx = x + width - 1;
			int ny = y + height - 1;
			
			
			for(int r = x; r <= nx; r++) {
				for(int c = y; c <= ny; c++) {
					map[r][c] = i;
				}
			}
		}
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				count[map[i][j]]++;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			sb.append(count[i]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
