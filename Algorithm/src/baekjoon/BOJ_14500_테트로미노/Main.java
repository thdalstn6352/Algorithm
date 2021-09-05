package baekjoon.BOJ_14500_테트로미노;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[][] map;
	static int N, M;
	static int maxSum;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] sizes = br.readLine().split(" ");
		N = Integer.parseInt(sizes[0]);
		M = Integer.parseInt(sizes[1]);
	
		map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(lines[c]);
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				dfs(new Point(r, c), visited, 0, 0);
				check(new Point(r, c));
			}
		}
		
		System.out.println(maxSum);
	}
	
	public static void dfs(Point point, boolean[][] visited, int cnt, int sum) {
		if(cnt == 3) {
			sum += map[point.x][point.y];
			maxSum = Math.max(maxSum, sum);
			return;
		}

		sum += map[point.x][point.y];
		
		for(int d = 0; d < 4; d++) {
			int nx = point.x + deltas[d][0];
			int ny = point.y + deltas[d][1];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] != true) {
				visited[point.x][point.y] = true;
				dfs(new Point(nx, ny), visited, cnt+1, sum);
				visited[point.x][point.y] = false;
			}
		}
	}
	public static void check(Point point) {
		int sum = map[point.x][point.y];
		int cnt = 0;
		
		for(int d = 0; d < 4; d++) {
			int nx = point.x + deltas[d][0];
			int ny = point.y + deltas[d][1];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
				cnt++;
				sum += map[nx][ny];
			}
		}
		if(cnt == 4) {
			for(int d = 0; d < 4; d++) {
				int nx = point.x + deltas[d][0];
				int ny = point.y + deltas[d][1];
				int value = sum - map[nx][ny];
				maxSum = Math.max(maxSum, value);
			}
		}
		else if(cnt == 3) {
			maxSum = Math.max(maxSum, sum);
		}
		else
			return;
			
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
