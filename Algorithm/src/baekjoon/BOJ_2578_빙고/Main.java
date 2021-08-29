package baekjoon.BOJ_2578_빙고;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static int[][] map;
	static boolean[][] checked;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		map = new int[5][5];
		checked = new boolean[5][5];
		Map<Integer, Point> point = new HashMap<>();
		int pickNum = 0;
		
		for(int r = 0; r < 5; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < 5; c++) {
				int val = Integer.parseInt(lines[c]);
				map[r][c] = val;
				point.put(val, new Point(r, c));
			}
		}
		
		for(int r = 0; r < 5; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < 5; c++) {
				pickNum++;
				int cnt = 0;
				int pick = Integer.parseInt(lines[c]);
				Point p = point.get(pick);
				checked[p.x][p.y] = true;
				
				cnt += rowBingo();
				cnt += colBingo();
				cnt += diaBingo();
				
				if(cnt >= 3) {
					System.out.println(pickNum);
					return;
				}
			}
		}
	}
	private static int rowBingo() {
		int count = 0;
		int flag = 0;
		
		for(int r = 0; r < 5; r++) {
			flag = 0;
			for(int c = 0; c< 5; c++) {
				if(!checked[r][c]) {
					flag = 1;
					break;
				}
			}
			if(flag == 0)
				count++;
		}
		return count;
	}
	private static int colBingo() {
		int count = 0;
		int flag = 0;
		
		for(int c = 0; c< 5; c++) {
			flag = 0;
			for(int r = 0; r < 5; r++) {
				if(!checked[r][c]) {
					flag = 1;
					break;
				}
			}
			if(flag == 0)
				count++;
		}
		return count;
	}
	private static int diaBingo() {
		int count = 0;
		int flag = 0;
		
		for(int r = 0, c = 0; r < 5 ; r++, c++) {
			if(!checked[r][c]) {
				flag = 1;
				break;
			}
		}
		if(flag == 0)
			count++;
		
		flag = 0;
		for(int r = 0, c = 4; r < 5 ; r++, c--) {
			if(!checked[r][c]) {
				flag = 1;
				break;
			}
		}
		if(flag == 0)
			count++;
		
		return count;
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
