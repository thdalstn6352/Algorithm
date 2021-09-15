package baekjoon.BOJ_2636_치즈;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] deltas = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	static int[][] map;
	static Queue<Point> meltQueue = new LinkedList<>();
	static int cheeseCnt, day;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] msg = br.readLine().split(" ");
		N = Integer.parseInt(msg[0]);
		M = Integer.parseInt(msg[1]);
		
		map = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(lines[c]);					
			}
		}
		
		while(true) {
			manageAir();
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					Point p = new Point(r, c);
					if(map[r][c] == 1 && isContactAir(p)) {
						bfs(p);
					}
				}
			}
			
			if(meltQueue.isEmpty()) {
				break;
			}
			else {
				cheeseCnt = meltQueue.size();
				
				while(!meltQueue.isEmpty()) {
					Point meltCheese = meltQueue.poll();
					map[meltCheese.x][meltCheese.y] = -1;
					
				}
			}
			day++;
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(map[r][c] == -1)
						System.out.print(0 + " ");
					else
						System.out.print(map[r][c] + " ");
				}
				System.out.println();
			}
			
			System.out.println(day + " " + cheeseCnt);
			System.out.println("=======================");
		}
		sb.append(day).append("\n").append(cheeseCnt);
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	private static void bfs(Point p) {
		Queue<Point> cheeseQueue = new LinkedList<>();
		boolean[][] isVisited = new boolean[N][M];
		
		cheeseQueue.offer(p);
		isVisited[p.x][p.y] = true;
		
		while(!cheeseQueue.isEmpty()) {
			Point point = cheeseQueue.poll();
			if(isContactAir(point)) {
				map[point.x][point.y] = 2;
				meltQueue.offer(point);
			}
			for(int d = 0; d < 4; d++) {
				int nx = point.x + deltas[d][0];
				int ny = point.y + deltas[d][1];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && !isVisited[nx][ny]) {
					cheeseQueue.add(new Point(nx, ny));
					isVisited[nx][ny] = true;
				}
			}
		}
	}
	
	
	private static boolean isContactAir(Point p) {
		for(int d = 0; d < 4; d++) {
			int nx = p.x + deltas[d][0];
			int ny = p.y + deltas[d][1];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == -1)
				return true;
		}
		return false;
	}
	
	private static void manageAir() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] isVisited = new boolean[N][M];
		
		queue.offer(new Point(0, 0));
		isVisited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			map[point.x][point.y] = -1;
			
			for(int d = 0; d < 4; d++) {
				int nx = point.x + deltas[d][0];
				int ny = point.y + deltas[d][1];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !isVisited[nx][ny] && map[nx][ny] != 1) {
					map[nx][ny] = -1;
					queue.offer(new Point(nx, ny));
					isVisited[nx][ny] = true;
				}
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