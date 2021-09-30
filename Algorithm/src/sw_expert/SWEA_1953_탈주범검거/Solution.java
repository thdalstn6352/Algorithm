package sw_expert.SWEA_1953_탈주범검거;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int N, M, R, C, L;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] value = br.readLine().split(" ");
			N = Integer.parseInt(value[0]);
			M = Integer.parseInt(value[1]);
			R = Integer.parseInt(value[2]);
			C = Integer.parseInt(value[3]);
			L = Integer.parseInt(value[4]);
			
			map = new int[N][M];
			for(int r = 0; r < N; r++) {
				String[] lines = br.readLine().split(" ");
				for(int c = 0; c < M; c++) {
					map[r][c] = Integer.parseInt(lines[c]);
				}
			}
			Point manhole = new Point(R, C, map[R][C], 0);
			sb.append("#").append(tc).append(" ").append(bfs(manhole)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	private static int bfs(Point manhole) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		queue.add(new Point(manhole.x, manhole.y, manhole.type, manhole.time));
		visited[manhole.x][manhole.y] = true;
		int time = 0;
		int cnt = 1;
		
		while(!queue.isEmpty()) {		
			Point hole = queue.poll();		
			int holeType = hole.type;
			//System.out.printf("cur: (%d, %d)%n",hole.x, hole.y);
			for(int d = 0; d < 4; d++) {
				if(!isOk(d, holeType))
					continue;
				
				int nx = hole.x + deltas[d][0];
				int ny = hole.y + deltas[d][1];
				int ntime = hole.time + 1;
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] != 0 && ntime != L) {
					//System.out.printf("(%d, %d)%n", nx, ny);
					switch(d) {
					case 0:
						if(!isOk(1, map[nx][ny]))
							continue;
						break;
					case 1:
						if(!isOk(0, map[nx][ny]))
							continue;
						break;
					case 2:
						if(!isOk(3, map[nx][ny]))
							continue;
						break;
					default:
						if(!isOk(2, map[nx][ny]))
							continue;
						break;
					}
					queue.add(new Point(nx, ny, map[nx][ny], ntime));
					visited[nx][ny] = true;
					cnt++;
				}
			}
			
//			for(int r = 0; r < N; r++) {
//				for(int c = 0; c < M; c++) {
//					if(visited[r][c])
//						System.out.print(1);
//					else
//						System.out.print(0);
//				}
//				System.out.println();
//			}
//			System.out.println("============");
		}
		return cnt;
	}
	
	private static boolean isOk(int dir, int holeType) {
		if(dir == 0) {
			if(holeType == 3 || holeType == 5 || holeType == 6)
				return false;
		}
		else if(dir == 1) {
			if(holeType == 3 || holeType == 4 || holeType == 7)
				return false;
		}
		else if(dir == 2) {
			if(holeType == 2 || holeType == 4 || holeType == 5)
				return false;
		}
		else {
			if(holeType == 2 || holeType == 6 || holeType == 7)
				return false;
		}
		return true;
	}
}

class Point {
	int x;
	int y;
	int type;
	int time;
	
	public Point(int x, int y, int type, int time) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
		this.time = time;
	}
}
