package baekjoon.BOJ_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int N, time, fishCnt, sharkSize = 2;
	static int[][] map;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Shark shark = null;
		
		for(int r = 0; r < N; r++) {
			String[] nums = br.readLine().split(" ");
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(nums[c]);
				if(map[r][c] == 9)
					shark = new Shark(r, c, 0);
			}
		}
		move(shark);
	}
	
	private static void move(Shark shark) {
		while(true) {
			Queue<Shark> fishQueue = new PriorityQueue<>();
			Queue<Shark> sharkQueue = new LinkedList<>();
			boolean[][] isVisited = new boolean[N][N];
			
			sharkQueue.offer(shark);
			isVisited[shark.x][shark.y] = true;
			
			while(!sharkQueue.isEmpty()) {
				Shark curShark = sharkQueue.poll();
				int curX = curShark.x;
				int curY = curShark.y;
				int curDist = curShark.dist;
				
				for(int d = 0; d < 4; d++) {
					int nx = curX + deltas[d][0];
					int ny = curY + deltas[d][1];
					
					if(nx >= 0 && nx < N && ny >= 0 && ny < N && !isVisited[nx][ny] && map[nx][ny] <= sharkSize) {
						if(map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
							fishQueue.offer(new Shark(nx, ny, curDist +1));
						}
						sharkQueue.offer(new Shark(nx, ny, curDist+1));
						isVisited[nx][ny] = true;
					}
				}
			}
			
			if(fishQueue.size() == 0) {
				System.out.println(time);
				return;
			}
			
			eatFish(fishQueue, shark);
		}
	}
	
	private static void eatFish(Queue<Shark> fishQueue, Shark shark) {
		Shark FishLocate = fishQueue.poll();
		time += FishLocate.dist;
		fishCnt++;
		map[FishLocate.x][FishLocate.y] = 0;
		
		if(fishCnt == sharkSize){
			sharkSize++;
			fishCnt = 0;
		}
		
		map[shark.x][shark.y] = 0; // 9 -> 0
		shark.x = FishLocate.x;
		shark.y = FishLocate.y;
	}
} 



class Shark implements Comparable<Shark>{
	int x;
	int y;
	int dist;
	
	public Shark(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	@Override
	public int compareTo(Shark o) {
		if(this.dist == o.dist) {
			if(this.x == o.x) {
				return this.y - o.y;
			}
			else {
				return this.x - o.x;
			}
		}
		return this.dist - o.dist;
	}

	@Override
	public String toString() {
		return "Shark [x=" + x + ", y=" + y + ", dist=" + dist + "]";
	}
	
	
}