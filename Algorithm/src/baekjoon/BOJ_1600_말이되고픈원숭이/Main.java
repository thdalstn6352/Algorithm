package baekjoon.BOJ_1600_말이되고픈원숭이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] deltas = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	static int[][] horseDeltas = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
	static int[][] map;
	static int W, H;
	static int startX, startY;
	static int endX, endY;
	static int min = Integer.MAX_VALUE;
	static boolean[][][] visited; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
		int K = Integer.parseInt(br.readLine());
		String[] axis = br.readLine().split(" ");
		
		W = Integer.parseInt(axis[0]);
		H = Integer.parseInt(axis[1]);

		endX = H - 1;
		endY = W - 1;
		
		map = new int[H][W];
		visited = new boolean[31][H][W];
		for(int r = 0; r < H; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(lines[c]);
			}
		}

		bfs(new Point(0, 0, K, 0));
	}
	
	
	private static void bfs(Point point) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(point);
		visited[point.k][point.x][point.y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x == endX && p.y == endY) {
				System.out.println(p.cnt);
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = p.x + deltas[d][0];
				int ny = p.y + deltas[d][1];
				 
				if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] != 1 && !visited[p.k][nx][ny]) {
					queue.offer(new Point(nx, ny, p.k, p.cnt+1));
					visited[p.k][nx][ny] = true;
				}
			}
			
			if(p.k != 0) {
				for(int h = 0; h < 8; h++) {
					int nx = p.x + horseDeltas[h][0];
					int ny = p.y + horseDeltas[h][1];
					
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] != 1 && !visited[p.k - 1][nx][ny]) {
						queue.offer(new Point(nx, ny, p.k - 1, p.cnt+1));
						visited[p.k - 1][nx][ny] = true;
					}
				}
				
			}
			
		}
		System.out.println(-1);
		return;
		
	}
}

class Point {
	int x;
	int y;
	int k;
	int cnt;
	
	public Point(int x, int y, int k, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.k = k;
		this.cnt = cnt;
	}

	
}
