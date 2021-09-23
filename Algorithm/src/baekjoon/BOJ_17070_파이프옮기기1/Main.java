package baekjoon.BOJ_17070_파이프옮기기1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static int[][] deltas = {{0, 1}, {1, 0}, {1, 1}};
	static int[][] map;
	static int N;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(lines[c]);
			}
		}
		dfs(new Point(0, 0), new Point(0, 1), 0);
		
		System.out.println(cnt);
	}
	
	private static void dfs(Point start, Point end, int dir) {
		if(end.x == N -1 && end.y == N - 1) {
			cnt++;
			return;
		}
		
		for(int d = 0; d < 3; d++) {
			int nx = end.x + deltas[d][0];
			int ny = end.y + deltas[d][1];
			
			if(dir == 0) {
				if(d == 1)
					continue;
			}
			else if(dir == 1)
				if(d == 0)
					continue;
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
				//System.out.printf("(%d, %d) -> (%d, %d)%n",end.x, end.y, nx, ny);
				
				if(d == 2) {
					//System.out.printf("map[%d][%d] = %d, map[%d][%d] = %d%n", nx, end.y, map[nx][end.y], end.x, ny, map[end.x][ny]);
					if(map[nx][end.y] != 0 || map[end.x][ny] != 0)
						continue;
				}
					
				dfs(end, new Point(nx, ny), d);
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