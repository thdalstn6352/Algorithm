package baekjoon.BOJ_10026_적록색약;

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
	static int N, count;
	static char[][] map;
	static char target;
	static boolean[][] visited;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		List<Point> GreenPoint = new ArrayList<>();
		
		for(int r = 0; r < N; r++) {
			String msg = br.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = msg.charAt(c);
				if(map[r][c] == 'G')
					GreenPoint.add(new Point(r, c));
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!visited[r][c]) 
					bfs(new Point(r, c));
			}
		}
		sb.append(count).append(" ");
		
		for(Point p : GreenPoint) {
			map[p.x][p.y] = 'R';
		}
		
		visited = new boolean[N][N];
		count = 0;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!visited[r][c]) 
					bfs(new Point(r, c));
			}
		}
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
	
	public static void bfs(Point point) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(point);
		visited[point.x][point.y] = true;
		target = map[point.x][point.y];
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = p.x + deltas[d][0];
				int ny = p.y + deltas[d][1];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == target) {
					queue.offer(new Point(nx,ny));
					visited[nx][ny] = true;  //bfs는 queue에서 뺄때가 아니라 넣을때 방문처리.!
				}
			}
		}
		count++;
		
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
