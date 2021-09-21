package sw_expert.SWEA_1767_프로세서연결하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	static int N;
	static int[][] map;
	static int[][] deltas = { {-1 , 0}, {1, 0}, {0, -1}, {0, 1} };
	static List<Point> coreList;
	static int minLength = Integer.MAX_VALUE;
	static int maxCoreCnt;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList = new ArrayList<>();
			
			for(int r = 0; r < N; r++) {
				String[] lines = br.readLine().split(" ");
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(lines[c]);
					if(map[r][c] == 1) {
						if(!(r == 0 || r == N -1 || c == 0 || c == N - 1))
							coreList.add(new Point(r, c));
							
					}
				}
			}
			dfs(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(minLength).append("\n");
			
			minLength = Integer.MAX_VALUE;
			maxCoreCnt = 0;
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	private static void dfs(int idx, int coreCnt, int len) {
		if(idx == coreList.size()) {
			if(coreCnt > maxCoreCnt) {
				minLength = len;
				maxCoreCnt = coreCnt;
			}
			else if(coreCnt == maxCoreCnt) {
				if(len < minLength)
					minLength = len;
			}
			return;
		}
		
		int x = coreList.get(idx).x;
		int y = coreList.get(idx).y;

		for(int d = 0; d < 4; d++) {
			int nx = x;
			int ny = y;
			int cnt = 0;
			
			while(true) {
				nx += deltas[d][0];
				ny += deltas[d][1];
				
				if(!isAvailable(nx, ny)) {
					break;
				}
				
				if(map[nx][ny] == 1) {
					cnt = 0;
					break;
				}
				cnt++;
			}
			if(cnt == 0)
				dfs(idx+1, coreCnt, len);
			else {
				connectOrdisconnect(new Point(x, y), cnt, d, 1);
				dfs(idx+1, coreCnt+1, len + cnt);
				connectOrdisconnect(new Point(x, y), cnt, d, 0);
			}
		}
		
	}
	
	private static void connectOrdisconnect(Point point, int cnt, int dir, int val) {
		int x = point.x;
		int y = point.y;
		
		for(int i = 0; i < cnt; i++) {
			x += deltas[dir][0];
			y += deltas[dir][1];
			
			map[x][y] = val;
		}
	}
	
	private static boolean isAvailable(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < N)
			return true;
		return false;
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
