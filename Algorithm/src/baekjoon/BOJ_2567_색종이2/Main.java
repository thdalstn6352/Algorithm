package baekjoon.BOJ_2567_색종이2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int[][] map = new int[101][101];
		int[][] deltas = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N; i++) {
			String[] msg = br.readLine().split(" ");
			int x = Integer.parseInt(msg[0]) - 1;
			int y = Integer.parseInt(msg[1]) - 1;
			
			for(int r = x; r < x + 10; r++) {
				for(int c = y; c < y + 10; c++) {
					map[r][c] = 1;
				}
			}
		}
		int count = 0;
		
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[0].length; c++) {
				if(map[r][c] == 1) {
					for(int d = 0; d < 4; d++) {
						int nx = r + deltas[d][0];
						int ny = c + deltas[d][1];
						
						if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || map[nx][ny] != 1) {
							count++;
						}
					}
				}
			}
		}
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}
