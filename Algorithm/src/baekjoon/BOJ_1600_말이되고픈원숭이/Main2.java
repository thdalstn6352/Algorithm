package baekjoon.BOJ_1600_말이되고픈원숭이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
	static int[][] deltas = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	static int[][] horseDeltas = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
	static int[][] map;
	static int W, H;
	static int startX, startY;
	static int endX, endY;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
		int K = Integer.parseInt(br.readLine());
		String[] axis = br.readLine().split(" ");
		
		W = Integer.parseInt(axis[0]);
		H = Integer.parseInt(axis[1]);

		endX = H - 1;
		endY = W - 1;
		
		map = new int[H][W];
		boolean[][] visited = new boolean[H][W];
		for(int r = 0; r < H; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(lines[c]);
			}
		}

		dfs(new Point2(0, 0, K, 0), visited);
	}
	
	private static void dfs(Point2 point, boolean [][] visited) {
		if(point.x == endX && point.y == endY) {
			System.out.println(point.cnt);
			return;
		}
		visited[point.x][point.y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nx = point.x + deltas[d][0];
			int ny = point.y + deltas[d][1];
			
			if(nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny] && map[nx][ny] != 1) {
				visited[nx][ny] = true;
				dfs(new Point2(nx, ny, point.k, point.cnt + 1), visited);
				visited[nx][ny] = false;
			}
		}
		
		for(int h = 0; h < 8; h++) {
			
		}
	}
	

}

class Point2 {
	int x;
	int y;
	int k;
	int cnt;
	
	public Point2(int x, int y, int k, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.k = k;
		this.cnt = cnt;
	}

	
}
