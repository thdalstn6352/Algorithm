package baekjoon.BOJ_14502_연구소;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N, M;
	static List<Point> wallList;
	static List<Point> virusList;
	static Point[] wallArray;
	static int[][] map;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] sizes = br.readLine().split(" ");
		N = Integer.parseInt(sizes[0]);
		M = Integer.parseInt(sizes[1]);
		
		map = new int[N][M];
		wallList = new ArrayList<>();
		virusList = new ArrayList<>();
		wallArray = new Point[3];
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < M; c++) {
				int value = Integer.parseInt(lines[c]);
				map[r][c] = value;
				if(value == 0)
					wallList.add(new Point(r, c));
				else if(value == 2)
					virusList.add(new Point(r, c));
			}
		}
		combination(0, 0);
		System.out.println(max);

	}
	
	private static void combination(int start, int cnt) {
		if(cnt == 3) {
			int[][] temp = deepCopy(map);
			for(Point p : wallArray) {
				temp[p.x][p.y] = 1;
			}
			bfs(temp);
			return;
		}
		
		for(int i = start; i < wallList.size(); i++) {
			wallArray[cnt] = wallList.get(i);
			combination(i + 1, cnt + 1);
		}
	}
	
	private static void bfs(int[][] board) {
		Queue<Point> queue = new LinkedList<>();
		int cnt = 0;
		
		boolean[][] visited = new boolean[N][M];

		for(Point p : virusList) {
			queue.offer(p);
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = p.x + deltas[d][0];
				int ny = p.y + deltas[d][1];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 1 && board[nx][ny] != 2 && !visited[nx][ny]) {
					board[nx][ny] = 2;
					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny));
				}
			}
		}
		
		
		for(int r = 0 ; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(board[r][c] == 0)
					cnt++;
			}
		}
		max = Math.max(max, cnt);	
	}
	
	private static int[][] deepCopy(int[][] map) {
		int[][] temp = new int[map.length][map[0].length];
		
		for(int r = 0; r < map.length; r++) {
			for(int c= 0; c < map[0].length; c++) {
				temp[r][c] = map[r][c];
			}
		}
		return temp;
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
