package baekjoon.BOJ_17472_다리만들기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
	static int value = 1;
	static boolean[][] visited;
	static Map<Integer, Object> islandMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		visited = new boolean[N][M];
		islandMap = new HashMap<>();
		map = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(lines[c]);
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 1 && !visited[r][c]) {
					bfs(new Point(r, c), value++);
				}
			}
		}
		calcDist();
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		
	}
	
	private static void bfs(Point point, int val) {
		Queue<Point> queue = new LinkedList<>();
		List<Point> list = new ArrayList<>();
		queue.add(point);
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = p.x + deltas[d][0];
				int ny = p.y + deltas[d][1];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] != 0) {
					map[nx][ny] = val;
					visited[nx][ny] = true;
					queue.add(new Point(nx, ny));
					list.add(new Point(nx, ny));
				}
			}
		}
		islandMap.put(val, list);
		List<Point> l = (List<Point>) islandMap.get(val);
		for(int i = 0; i < l.size(); i++) {
			System.out.println(val);
			System.out.println(l.get(i));
		}
		System.out.println("===============");
	}
	
	
	private static void calcDist() {
		for(int i = 1; i <= islandMap.size(); i++) {
			for(int j = i+1; j <= islandMap.size(); j++) {
				if(i == j) continue;
				int min = Integer.MAX_VALUE;
				for(Point island : (List<Point>) islandMap.get(i)) {
					for(Point next_island : (List<Point>) islandMap.get(j)) {
						int dist = Math.abs(island.x - next_island.x) + Math.abs(island.y - next_island.y);
						System.out.printf("(%d, %d) -> (%d, %d) = %d %n",island.x, island.y, next_island.x, next_island.y, dist);
						min = Math.min(min, dist);
					}
				}
			}
		}
	}
}

class bridge {
	int from;
	int to;
	int dist;
	
	public bridge(int from, int to, int dist) {
		super();
		this.from = from;
		this.to = to;
		this.dist = dist;
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

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
