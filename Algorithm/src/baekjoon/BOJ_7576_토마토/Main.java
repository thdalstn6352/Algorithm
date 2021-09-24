package baekjoon.BOJ_7576_토마토;

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
	static int[][] map;
	static List<Point> tomatoList;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
	static int day, zero;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] NM = br.readLine().split(" ");
		
		M = Integer.parseInt(NM[0]);
		N = Integer.parseInt(NM[1]);
		
		map = new int[N][M];
		List<Point> tomatoList = new ArrayList<Point>();
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0 ; c < M; c++) {
				map[r][c] = Integer.parseInt(lines[c]);
				if(map[r][c] == 1)
					tomatoList.add(new Point(r, c, 0));
				else if(map[r][c] == 0)
					zero++;
			}
		}
		bfs(tomatoList);
		System.out.println(day);
	}
	
	private static void bfs(List<Point> list) {
		Queue<Point> queue = new LinkedList<>();
		
		for(int i = 0; i < list.size(); i++) {
			Point p = tomatoList.get(i);
			queue.add(p);
		}
		
		while(!queue.isEmpty()) {
			Point tomato = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = tomato.x + deltas[d][0];
				int ny = tomato.y + deltas[d][1];
				int curday = tomato.day;
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
					map[nx][ny] = 1;
					queue.add(new Point(nx, ny, curday+1));
					zero--;
				}
			}
			day = tomato.day;
		}
		if(zero != 0)
			day = -1;
		
	}
}

class Point {
	int x;
	int y;
	int day;
	
	public Point(int x, int y, int day) {
		super();
		this.x = x;
		this.y = y;
		this.day = day;
	}
	
}
