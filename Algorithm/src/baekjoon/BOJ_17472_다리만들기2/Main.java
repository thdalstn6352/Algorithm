package baekjoon.BOJ_17472_다리만들기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
	static int value = 1;
	static boolean[][] visited;
	static Map<Integer, Object> islandMap;
	static PriorityQueue<Bridge> bridgeQueue;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		visited = new boolean[N][M];
		islandMap = new HashMap<>();
		bridgeQueue = new PriorityQueue<>();
		
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
		parents = new int[value + 1];
		for(int idx = 1; idx <= islandMap.size(); idx++) {
			calcDist(idx);
		}

		make();
		
		int min = 0;
		int cnt = 0;
		while(!bridgeQueue.isEmpty()) {
			Bridge bridge = bridgeQueue.poll();
			//System.out.println(bridge);
			if(union(bridge.from, bridge.to)) {
				min += bridge.dist;
				//System.out.println(bridge);
				if(++cnt == value - 2)
					break;
			}
			//System.out.println("-----");
		}
		
		if(cnt != value - 2)
			System.out.println(-1);
		else
			System.out.println(min);	
	}
	
	private static void bfs(Point point, int val) {
		Queue<Point> queue = new LinkedList<>();
		List<Point> list = new ArrayList<>();
		queue.add(point);
		visited[point.x][point.y] = true;
		map[point.x][point.y] = val;
		list.add(new Point(point.x, point.y));
		
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
	}
	
	private static void calcDist(int idx) {
		List<Point> l = (List<Point>) islandMap.get(idx);
		Queue<Point> queue = new LinkedList<>();
		
		for(int i = 0; i < l.size(); i++) {
			queue.add(l.get(i));
			
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				
				for(int d = 0; d < 4; d++) {
					int nx = p.x + deltas[d][0];
					int ny = p.y + deltas[d][1];

					if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != idx) {
						int len = 1;
						connectBridge(new Point(nx, ny), d, len, idx);
					}
				}
			}
		}
	}
	
	private static void connectBridge(Point point, int d, int len, int start) {
		int nx = point.x + deltas[d][0];
		int ny = point.y + deltas[d][1];
		
		if(!(nx >= 0 && nx < N && ny >= 0 && ny < M)) {
			return;
		}
		
		if(map[nx][ny] > 0) {
			if(len >= 2)
				bridgeQueue.add(new Bridge(start, map[nx][ny], len));
			return;
		}
		
		connectBridge(new Point(nx, ny), d, len + 1, start);
	}
	
	private static void make() {
		for(int i = 1; i < value; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(parents[a] == a) 
			return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}
}

class Bridge implements Comparable<Bridge>{
	int from;
	int to;
	int dist;
	
	public Bridge(int from, int to, int dist) {
		super();
		this.from = from;
		this.to = to;
		this.dist = dist;
	}

	@Override
	public String toString() {
		return "Bridge [from=" + from + ", to=" + to + ", dist=" + dist + "]";
	}

	@Override
	public int compareTo(Bridge o) {
		return this.dist - o.dist;
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
