package baekjoon.BOJ_23290_마법사상어와복제;

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
	static int M, S;
	static int[][] map = new int[4][4];
	
	static int[][] deltas = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	static Queue<Fish> fishQueue;
	static Queue<NextFish> nfishQueue;
	
	static Shark shark = null;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] infos = br.readLine().split(" ");
		
		M = Integer.parseInt(infos[0]);
		S = Integer.parseInt(infos[1]);
		fishQueue = new LinkedList<>();
		nfishQueue = new LinkedList<>();
		
		for(int i = 0; i < M; i++) {
			String[] lines = br.readLine().split(" ");
			fishQueue.add(new Fish(Integer.parseInt(lines[0]) -1, Integer.parseInt(lines[1])-1, Integer.parseInt(lines[2])));
		}
		
		String[] sharkInfo = br.readLine().split(" ");
		shark = new Shark(Integer.parseInt(sharkInfo[0]) - 1, Integer.parseInt(sharkInfo[1]) - 1);
		map[shark.x][shark.y] = 1;
		
		for(int idx = 0; idx < S; idx++) {
			moveFish();
			
		}
		
		for(int r = 0; r < 4; r++) {
			for(int c = 0; c< 4; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	public static void moveFish() {
		for(int i = 0; i < M; i++) {
			int x = fishQueue.get(i).x;
			int y = fishQueue.get(i).y;
			int nextX = x;
			int nextY = y;
			
			int dir = fishQueue.get(i).dir - 1;
			
			
			for(int j = 0; j < 8; j++) {
				int nx = x + deltas[dir][0];
				int ny = y + deltas[dir][1];
				
				if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != 1 && map[nx][ny] != 3) {
					nextX = nx;
					nextY = ny;
					break;
				}
				dir--;
				if(dir == -1) 
					dir = 7; 
			}
			nfishQueue.add(new NextFish(nextX, nextY, dir));
			map[nextX][nextY] = 2;
			System.out.println(nfishQueue.get(i));
		}
	}
	
//	public static void moveShark(i) {
//		
//	}
}


class Fish {
	int x;
	int y;
	int dir;
	
	public Fish(int x, int y, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "Fish [x=" + x + ", y=" + y + ", dir=" + dir + "]";
	}
}

class NextFish {
	int x;
	int y;
	int dir;
	
	public NextFish(int x, int y, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "NextFish [x=" + x + ", y=" + y + ", dir=" + dir + "]";
	}
	
	
}

class Shark {
	int x;
	int y;
	
	public Shark(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
