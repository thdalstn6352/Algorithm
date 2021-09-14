package baekjoon.BOJ_20056_마법사상어와파이어볼;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, M, K;
	static int[][] map;
	//static List<FireBall> list;
	
	static int[][] deltas = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
	static List<FireBall> fireballs;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		fireballs = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			int m = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			
			fireballs.add(new FireBall(r, c, m, s, d));
			map[r][c] = 1;
		}
		
		for(int move = 0; move < K; move++) {
			moveCmd();
		}
		
		int answer = 0;
		for(int i = 0; i < fireballs.size(); i++) {
			answer += fireballs.get(i).m;
		}
		
		System.out.println(answer);
		
	}
	private static void moveCmd() {
		for(int i = 0; i < M; i++) {
			FireBall fireball = fireballs.get(i);
			int nx = (fireball.r + N + (deltas[fireball.d][0] * fireball.s)) % N;
			int ny = (fireball.c + N + (deltas[fireball.d][1] * fireball.s)) % N;
			
			map[fireball.r][fireball.c]--;
			fireballs.get(i).r = nx;
			fireballs.get(i).c = ny;
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] > 1) {
					int cnt = map[r][c];
					int mSum = 0;
					int sSum = 0;
					int dFlag = 0;
					
					for(int i = 0; i < M; i++) {
						map[r][c] = 4;
						if(r == fireballs.get(i).r && c == fireballs.get(i).c) {
							mSum += fireballs.get(i).m;
							sSum += fireballs.get(i).s;
							switch(dFlag) {
							case 0:
								if(fireballs.get(i).d % 2 == 1)
									dFlag = 2;
								else
									dFlag = 1;
								break;
							case 1:
								if(fireballs.get(i).d % 2 == 1)
									dFlag = 3;
								break;
							case 2:
								if(fireballs.get(i).d % 2 == 0)
									dFlag = 3;
								break;
							case 3:
								break;
							}
							fireballs.remove(i);
						}
					}
					mSum /= 5;
					sSum /= cnt;
					
					if(mSum > 0) {
						if(dFlag == 3) {
							for(int d = 0; d < 7; d += 2) {
								fireballs.add(new FireBall(r, c, mSum, sSum, d));
							}
						}
						else if(dFlag == 1 || dFlag == 2){
							for(int d = 1; d < 8; d += 2) {
								fireballs.add(new FireBall(r, c, mSum, sSum, d));
							}
						}
					}
					else if(mSum == 0) {
						map[r][c] = 0;
					}
					
				}
			}
		}
		
	}
}

class FireBall {
	int r;
	int c;
	int m;
	int s;
	int d;
	
	public FireBall(int r, int c, int m, int s, int d) {
		super();
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}
