package sw_expert.SWEA_1767_프로세서연결하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int N;
	static int[][] map;
	static int[][] deltas = { {-1 , 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				String[] lines = br.readLine().split(" ");
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(lines[c]);
				}
			}
			
			for(int r = 1; r < N - 1; r++) {
				for(int c = 1; c < N - 1; c++) {
					if(map[r][c] == 1) {
						bfs(new Point(r, c));
					}
				}
			}
		}
		
	}
	
	private static void bfs(Point point) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		int min = Integer.MAX_VALUE;
		
		queue.add(point);
		visited[point.r][point.c] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r + deltas[d][0];
				int nc = p.c + deltas[d][1];
				int len = 0;
				
				if(nr >= 1 && nr < N && nc >= 1 && nc < N && map[nr][nc] != 1) {
					calcDist(new Point(nr, nc), d, len);
				}
			}
		}
	}
	
	private static void calcDist(Point point, int d, int len) {
		int nr = point.r + deltas[d][0];
		int nc = point.c + deltas[d][1];
		
		if(nr >= 1 && nr < N && nc >= 1 && nc < N && map[nr][nc] != 1) {
			calcDist(new Point(nr, nc), d, len+1);
		}
	}
}

class Point {
	int r;
	int c;
	
	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}
