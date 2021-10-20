package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class test01 {
	static int N;
	static int[][] map;
	static Po po;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	static boolean[][] finalvisited;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			finalvisited = new boolean[N][N];
			
			for(int r = 0; r < N; r++) {
				String[] lines = br.readLine().split(" ");
				
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(lines[c]);
					if(map[r][c] == 2)
						po = new Po(r, c, 0, visited);
				}
			}
			bfs();
			int count = 0;
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(map[r][c] == 1 && finalvisited[r][c]) {
						//System.out.print(1 +" ");
						count++;
					}
//					else
//						System.out.print(0 + " ");
				}
			//	System.out.println();
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	private static void bfs() {
		Queue<Po> queue = new LinkedList<>();
		
		po.visitedCopy[po.x][po.y] = true;
		queue.add(po);
		
		while(!queue.isEmpty()){
			Po point = queue.poll();
			int x = point.x;
			int y = point.y;
			int cnt = point.cnt;
			boolean[][] visited = deepCopy(point.visitedCopy);
			if(cnt == 3)
				break;
			for(int d = 0; d < 4; d++) {
				int flag = 0;
				int nx = x;
				int ny = y;
				
				while(true) {
					nx += deltas[d][0];
					ny += deltas[d][1];
					
						
					if(nx < 0 || nx >= N || ny < 0 || ny >= N)
						break;
						
					if(flag == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						finalvisited[nx][ny] = true;
						queue.add(new Po(nx, ny, cnt+1, visited));
						if(map[nx][ny] == 1)
							break;
					}
					
					if(map[nx][ny] == 1) {
						flag = 1;
					}
					
				}
			}
		}
	}
	private static boolean[][] deepCopy(boolean[][] copy) {
		boolean[][] visited = new boolean[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				visited[r][c] = copy[r][c];
			}
		}
		
		return visited;
	}
}

class Po {
	int x;
	int y;
	int cnt;
	boolean[][] visitedCopy;
	
	public Po(int x, int y, int cnt, boolean[][] visitedCopy) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.visitedCopy = visitedCopy;
	}
}