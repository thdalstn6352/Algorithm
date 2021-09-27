package baekjoon.BOJ_17144_미세먼지안녕;

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
	static int R, C, T;
	static int[][] map;
	static int[][] temp;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
	static AirCleaner aircleaner;
	static Queue<Point> munjiQueue = new LinkedList<>();
	static int tempValue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] RCT = br.readLine().split(" ");
		R = Integer.parseInt(RCT[0]);
		C = Integer.parseInt(RCT[1]);
		T = Integer.parseInt(RCT[2]);

		map = new int[R][C];
		temp = new int[R][C];
		
		boolean find = false;
		List<Point> munjiList = new ArrayList<>();
		
		for(int r = 0; r < R; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(lines[c]);
				
				if(map[r][c] == -1) {
					if(!find) {
						aircleaner = new AirCleaner(new Point(r, c), new Point(r+1, c));
						find = true;
					}
				}
				else if(map[r][c] != 0) {
					munjiQueue.add(new Point(r, c));
				}
			}
		}
		
		for(int tc = 0; tc < T; tc++) {
			spreadMunji();
			addMunji();
			activeCleaner();
		}
		
		int sum = 0;
		for(int r = 0; r < R; r++) {
			for(int c= 0; c< C; c++) {
				System.out.print(map[r][c] + " ");
				if(map[r][c] != 0 && map[r][c] != -1)
					sum += map[r][c];
			}
			System.out.println();
		}
		System.out.println(sum);
	}
	
	private static void spreadMunji() {
		int size = munjiQueue.size();
		for(int i = 0; i < size; i++) {
			Point munji = munjiQueue.poll();
			int cnt = 0;
			int quantity = 0;
			for(int d = 0 ; d < 4; d++) {
				int nx = munji.x + deltas[d][0];
				int ny = munji.y + deltas[d][1];
				
				if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
					munjiQueue.add(new Point(nx, ny));
					quantity = map[munji.x][munji.y] / 5;
					temp[nx][ny] += quantity;
					cnt++;
				}
			}
			map[munji.x][munji.y] = map[munji.x][munji.y] - (quantity * cnt);
		}
	}
	
	private static void addMunji() {
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(temp[r][c] != 0)
					map[r][c] += temp[r][c];
			}
		}
	}
	
	private static void activeCleaner() {
		Point upCleaner = aircleaner.upPosition;
		Point downCleaner = aircleaner.downPosition;
		leftRotateArray(0, upCleaner.x, 0, C - 1);
		rightRotateArray(downCleaner.x, R - 1, 0, C - 1);
	}
	
	private static void leftRotateArray(int rs, int re, int cs, int ce) {		
		for(int d = re - 1; d > rs; d--) {
			map[d][cs] = map[d-1][cs]; // v 하
		}
		
		for(int l = cs; l < ce; l++) {
			map[rs][l] = map[rs][l+1]; //<- 좌
		}
		for(int u = rs; u < re; u++) {
			map[u][ce] = map[u+1][ce]; // ^ 상
		}
		for(int r = ce; r > cs; r--) { 
			map[re][r] = map[re][r-1]; //-> 우
		}
		
		map[re][cs+1] = 0;
	}
	
	private static void rightRotateArray(int rs, int re, int cs, int ce) {
		for(int u = rs+1; u < re; u++) {
			map[u][cs] = map[u+1][cs]; // ^ 상
		}
		
		for(int l = cs; l < ce; l++) {
			map[re][l] = map[re][l+1]; //<- 좌
		}
		
		for(int d = re; d > rs; d--) {
			map[d][ce] = map[d-1][ce]; // v 하
		}
		
		for(int r = ce; r > cs; r--) { 
			map[rs][r] = map[rs][r-1]; //-> 우
		}
		
		map[rs][cs+1] = 0;
		
	}
}

class AirCleaner {
	Point upPosition;
	Point downPosition;
	
	public AirCleaner(Point upPosition, Point downPosition) {
		super();
		this.upPosition = upPosition;
		this.downPosition = downPosition;
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