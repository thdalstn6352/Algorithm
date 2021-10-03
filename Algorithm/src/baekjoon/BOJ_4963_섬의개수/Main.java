package baekjoon.BOJ_4963_섬의개수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = { {-1, 0}, {-1, -1}, {-1, 1}, {0, 1}, {0, -1}, {1, 0}, {1, -1}, {1, 1} };
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		while(true) {
			String[] wh = br.readLine().split(" ");

			w = Integer.parseInt(wh[0]);
			h = Integer.parseInt(wh[1]);
			
			if(w == 0 && h == 0)
				break;
			map = new int[h][w];
			visited = new boolean[h][w];
			for(int r = 0; r < h; r++) {
				String[] lines = br.readLine().split(" ");
				for(int c = 0; c < w; c++) {
					map[r][c] = Integer.parseInt(lines[c]);
				}
			}
			
			for(int r = 0; r < h; r++) {
				for(int c = 0; c < w; c++) {
					if(map[r][c] == 1 && !visited[r][c]) {
						dfs(new Point(r, c));
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
			cnt = 0;
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	private static void dfs(Point point) {
		visited[point.x][point.y] = true;
		
		for(int d = 0; d < 8; d++) {
			int nx = point.x + deltas[d][0];
			int ny = point.y + deltas[d][1];
			
			if(nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny] && map[nx][ny] == 1) {
				dfs(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
}
class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
