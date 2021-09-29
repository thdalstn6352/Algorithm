package baekjoon.BOJ_1194_달이차오른다가자;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {
	static int R, C;
	static char[][] map;
	static boolean[][][] visited;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] RC = br.readLine().split(" ");
		Point startPos = null;
		
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);
		
		map = new char[R][C];
		//List<Character> keyList = new ArrayList<Character>();
		visited = new boolean[R][C][64];
		
		for(int r = 0; r < R; r++) {
			char[] lines = br.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				map[r][c] = lines[c];
				if(map[r][c] == '0') {
					startPos = new Point(r,c,0,0);
				}
			}
		}
		bfs(startPos);
	}
	
	private static void bfs(Point point) {
		Queue<Point> queue = new LinkedList<>();
		visited[point.x][point.y][point.key] = true;
		queue.add(new Point(point.x, point.y, point.key, point.cnt));
		map[point.x][point.y] = '.';

		while(!queue.isEmpty()) {
			Point p = queue.poll();

			for(int d = 0; d < 4; d++) {
				int nx = p.x + deltas[d][0];
				int ny = p.y + deltas[d][1];
				int curKey = p.key;
				int curCnt = p.cnt;
				
				if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != '#' && !visited[nx][ny][curKey]) {
					if(map[nx][ny] == '1') {
						System.out.println(curCnt + 1);
						return;
					}
					else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
						curKey = curKey | (1 << map[nx][ny] - 'a');
					}
					else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F')  {
						if((curKey & (1 << map[nx][ny] - 'A')) == 0){
							continue;
						}
					}
					visited[nx][ny][curKey] = true;
					queue.add(new Point(nx, ny, curKey, curCnt+1));
				}
			}
		}
		System.out.println(-1);
		
	}
}

class Point {
	int x;
	int y;
	int key;
	int cnt;
	
	public Point(int x, int y, int key, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.key = key;
		this.cnt = cnt;
	}
}