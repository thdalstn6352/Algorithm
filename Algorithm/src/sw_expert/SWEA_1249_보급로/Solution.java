package sw_expert.SWEA_1249_보급로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int N;
	static int[][] map;
	static int[][][] answer;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			answer = new int[N][N][4];
			
			for(int r = 0; r < N; r++) {
				String val = br.readLine();
				for(int c = 0; c < N; c++) {
					map[r][c] = val.charAt(c) - '0';
				}
			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					for(int d = 0; d < 4; d++) {
						answer[r][c][d] = Integer.MAX_VALUE;
					}
				}
			}
			bfs();
			
			int min = Integer.MAX_VALUE;
			for(int d = 0; d < 4; d++) {
				min = Math.min(min, answer[N-1][N-1][d]);
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		
		for(int d = 0; d < 4; d++) {
			queue.add(new Point(0, 0, d));
			answer[0][0][d] = 0;
		}
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = point.x + deltas[d][0];
				int ny = point.y + deltas[d][1];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(answer[nx][ny][d] > map[nx][ny] + answer[point.x][point.y][point.dir]) {
						answer[nx][ny][d] = map[nx][ny] + answer[point.x][point.y][point.dir];
						queue.add(new Point(nx, ny, d));
					}
				}
			}
		}
		
	}
}

class Point {
	int x;
	int y;
	int dir;
	
	public Point(int x, int y, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
}

