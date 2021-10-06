package sw_expert.SWEA_5656_벽돌깨기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int N, W, H, total, remove;
	static int minBrick = Integer.MAX_VALUE;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] NWH = br.readLine().split(" ");
			N = Integer.parseInt(NWH[0]);
			W = Integer.parseInt(NWH[1]);
			H = Integer.parseInt(NWH[2]);
			
			int[][] map = new int[H][W];
			
			for(int r = 0; r < H; r++) {
				String[] lines = br.readLine().split(" ");
				for(int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(lines[c]);
					if(map[r][c] != 0)
						total++;
				}
			}
			
			permutation(0, map);
			sb.append("#").append(tc).append(" ").append(minBrick).append("\n");
			minBrick = Integer.MAX_VALUE;
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	private static void permutation(int cnt, int[][] map) {
		if(cnt == N) {
			minBrick = Math.min(minBrick, getRemain(map));
			return;
		}
		
		for(int i = 0; i < W; i++) {
			Point point = findBrick(i, map);
			if(point == null)
				permutation(cnt+1, map);
			else {
				int[][] newMap = new int[H][W];
				newMap = copy(map);
				bfs(point, newMap);
				downBrick(newMap);
				permutation(cnt+1, newMap);
			}
		}
		
	}
	private static void bfs(Point point, int[][] map) {
		Queue<Point> queue = new LinkedList<>();
		//boolean[][] visited = new boolean[H][W];

		queue.add(new Point(point.x, point.y, point.value));
		//System.out.println(queue.peek());
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = p.x;
				int ny = p.y;
				int length = p.value - 1;
				map[nx][ny] = 0;
				
				for(int l = 0; l < length; l++) {
					nx += deltas[d][0];
					ny += deltas[d][1];
					//System.out.println(nx + " " + ny);
					if(nx < 0 || nx >= H || ny < 0 || ny >= W)
						break;
					if(map[nx][ny] > 1) 
						queue.add(new Point(nx, ny, map[nx][ny]));
					map[nx][ny] = 0;
					remove++;
				}
			}
			
		}
	}
	
	private static Point findBrick(int idx, int[][] map) {
		for(int r = 0; r < H; r++) {
			if(map[r][idx] != 0) {
				return new Point(r, idx, map[r][idx]);
			}
		}
		return null;
	}
	
	private static void downBrick(int[][] map) {
		for(int c = 0; c < W; c++) {
			int r = H - 1;
			while(r > 0) {
				if(map[r][c] == 0) {
					int nr = r - 1;
					while(nr > 0 && map[nr][c] == 0)
						nr--;
					
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				r--;
			}
		}
	}
	
	private static int[][] copy(int[][] temp) {
		int[][] copy = new int[H][W];
		
		for(int r = 0; r < H; r++) {
			for(int c = 0; c< W; c++) {
				copy[r][c] = temp[r][c];
			}
		}
		
		return copy;
	}
	
	private static int getRemain(int[][] map) {
		int count = 0;
		
		for(int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++) {
				if(map[r][c] > 0)
					count++;
			}
		}
		return count;
	}
}

class Point {
	int x;
	int y;
	int value;
	
	public Point(int x, int y, int value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", value=" + value + "]";
	}	
	
}
