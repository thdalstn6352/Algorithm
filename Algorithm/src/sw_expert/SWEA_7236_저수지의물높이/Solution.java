package sw_expert.SWEA_7236_저수지의물높이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int[][] deltas = { {-1, 0}, {-1, 1}, {0, 1},{1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
		int max = 0;
		
		int T = Integer.parseInt(br.readLine());
		char[][] map;
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			
			for(int r = 0; r < N; r++) {
				String[] lines = br.readLine().split(" ");
				for(int c = 0; c < N; c++) {
					map[r][c] = lines[c].charAt(0);
				}
			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					int count = 0;
					if(map[r][c] == 'W') {
						for(int d = 0; d < 8; d++) {
							int nx = r + deltas[d][0];
							int ny = c + deltas[d][1];
							
							if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 'W') {
								count++;
							}
						}
						if(count == 0)
							count = 1;
						max = Math.max(max, count);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			max = 0;
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
