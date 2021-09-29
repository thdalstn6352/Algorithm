package baekjoon.BOJ_4485_녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static int[][][] answer;
	static int problem = 1;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
			map = new int[N][N];
			answer = new int[N][N][4];
			
			for(int r = 0; r < N; r++) {
				String[] lines = br.readLine().split(" ");
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(lines[c]);
				}
			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					for(int d = 0; d < 4; d++) {
						answer[r][c][d] = 10000;
					}
				}
			}
			
			bfs(new Point(0, 0, 0));
			
			int min = Integer.MAX_VALUE;
			for(int d = 0; d < 4; d++) {
				min = Math.min(min, answer[N-1][N-1][d]);
			}
			sb.append("Problem ").append(problem++).append(": ").append(min).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
	
	}
	
	private static void bfs(Point point) {
		Queue<Point> queue = new LinkedList<>();
		
		for(int d = 0; d < 4; d++) {
			queue.add(new Point(point.x, point.y, d));
			answer[point.x][point.y][d] = map[point.x][point.y];
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = p.x + deltas[d][0];
				int ny = p.y + deltas[d][1];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny <N && (answer[p.x][p.y][p.dir] + map[nx][ny] < answer[nx][ny][d])) {
					answer[nx][ny][d] = answer[p.x][p.y][p.dir] + map[nx][ny];
					queue.add(new Point(nx, ny, d));
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
