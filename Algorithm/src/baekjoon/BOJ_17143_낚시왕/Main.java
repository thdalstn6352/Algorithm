package baekjoon.BOJ_17143_낚시왕;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int R, C, M, sum;
	static Shark[][] map;
	static int[][] deltas = { {}, {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
	static List<Shark> sharkQueue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] RCM = br.readLine().split(" ");
		R = Integer.parseInt(RCM[0]); 
		C = Integer.parseInt(RCM[1]); 
		M = Integer.parseInt(RCM[2]); 
		if(M == 0) {
			System.out.println(sum);
			return;
		}
		map = new Shark[R][C];
		sharkQueue = new ArrayList<Shark>();
		
		for(int m = 0; m < M; m++) {
			String[] sharkInfo = br.readLine().split(" ");
			int r = Integer.parseInt(sharkInfo[0]) - 1;
			int c = Integer.parseInt(sharkInfo[1]) - 1;
			int s = Integer.parseInt(sharkInfo[2]);
			int d = Integer.parseInt(sharkInfo[3]);
			int z = Integer.parseInt(sharkInfo[4]);
			
			map[r][c] = new Shark(r, c, s, d, z);
		}

		for(int c = 0; c < C; c++) {
			for(int x = 0; x < R; x++) {
				for(int y = 0; y < C; y++) {
					if(map[x][y] != null) {
						sharkQueue.add(map[x][y]);
					}
				}
			}
			
			for(int r = 0; r < R; r++) {
				if(map[r][c] != null) {
					Shark shark = map[r][c];
					sum += shark.z;
					sharkQueue.remove(shark);
//					System.out.println(shark.r + " " + shark.c);
//					System.out.printf("sum : %d cur_value : %d %n",sum,shark.z);
//					System.out.println("====");
					break;
				}
			}
			
			int size = sharkQueue.size();
			map = new Shark[R][C];
			
			for(int i = 0; i < size; i++) {
				Shark shark = sharkQueue.get(i);
				moveShark(shark);
			}
			sharkQueue.clear();
		}
		System.out.println(sum);
	}
	private static void moveShark(Shark shark) {
		int dist = 0;
		
		if(shark.d < 3) 
			dist = shark.s % ((R - 1) * 2);
		else
			dist = shark.s % ((C - 1) * 2);
		
		int nx = shark.r;
		int ny = shark.c;
		int nd = shark.d;
		for(int i = 0; i < dist; i++) {
			if((nx == 0 && nd == 1) || (nx == R - 1 && nd == 2) || (ny == 0 && nd == 4) || (ny == C - 1 && nd == 3)) {
				if(nd == 1)
					nd = 2;
				else if(nd == 2)
					nd = 1;
				else if(nd == 3)
					nd = 4;
				else
					nd = 3;
			}
			nx += deltas[nd][0];
			ny += deltas[nd][1];
		}
		
		if(map[nx][ny] == null) {
			map[nx][ny] = new Shark(nx, ny, shark.s, nd, shark.z);
		}
		else {
			if(map[nx][ny].z < shark.z) {
				map[nx][ny] = new Shark(nx, ny, shark.s, nd, shark.z);
			}
		}
	}
}

class Shark implements Comparable<Shark>{
	int r;
	int c;
	int s;
	int d;
	int z;

	public Shark(int r, int c, int s, int d, int z) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}


	@Override
	public int compareTo(Shark o) {
		if(this.c == o.c) {
			return this.r - o.r;
		}
		else
			return this.c - o.c;
	}


	@Override
	public String toString() {
		return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
	}
	
}