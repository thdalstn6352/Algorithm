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

public class Main2 {
	static int R, C;
	static char[][] map;
	static Point2 startPos;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] RC = br.readLine().split(" ");
		
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);
		
		map = new char[R][C];
		
		for(int r = 0; r < R; r++) {
			char[] lines = br.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				map[r][c] = lines[c];
				if(map[r][c] == '0') {
					startPos = new Point2(r,c,new ArrayList<>(), 0, new boolean[R][C]);
				}
			}
		}
		bfs(startPos);
	}
	
	private static void bfs(Point2 point) {
		Queue<Point2> queue = new LinkedList<>();
		point.visited[point.x][point.y] = true;
		queue.add(new Point2(point.x, point.y, point.keyList, point.cnt, point.visited));
		map[point.x][point.y] = '.';

		while(!queue.isEmpty()) {
			Point2 p = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = p.x + deltas[d][0];
				int ny = p.y + deltas[d][1];
				boolean[][] isVisted = deepCopy(p.visited);
				List<Character> keySet = new ArrayList<>();
				for(char a: p.keyList) {
					keySet.add(a);
				}
				
				if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != '#' && !isVisted[nx][ny]) {
					System.out.println(nx + " " + ny);
					if(map[nx][ny] == '.') {
						isVisted[nx][ny] = true;
						queue.add(new Point2(nx, ny, keySet, p.cnt+1, isVisted));
						System.out.println(".도착");
						System.out.println(Arrays.deepToString(isVisted));
					}
					else if(map[nx][ny] == '1') {
						System.out.println("1도착");
						System.out.println(Arrays.deepToString(isVisted));
						System.out.println(p.cnt + 1);
						return;
					}
					else if(map[nx][ny] >= 97 && map[nx][ny] <= 122) {
						keySet.add(map[nx][ny]);
						isVisted = new boolean[R][C];
						isVisted[nx][ny] = true;
						queue.add(new Point2(nx, ny, keySet, p.cnt+1, isVisted));
						System.out.println("열쇠 도착");
						System.out.println(Arrays.deepToString(isVisted));
					}
					else {
						char value = (char) (map[nx][ny] + 32);
						System.out.println("문 도착");
						System.out.println(keySet);
						
						if(keySet.contains(value)) {
							System.out.println("통과!");
							isVisted[nx][ny] = true;
							queue.add(new Point2(nx, ny, keySet, p.cnt+1, isVisted));
							System.out.println(Arrays.deepToString(isVisted));
						}
					}
				}
			}
		}
		System.out.println(-1);
	}
	
	private static boolean[][] deepCopy(boolean[][] temp) {
		boolean[][] copy = new boolean[R][C];
		for (int i = 0; i < temp.length; i++) {
			System.arraycopy(temp[i], 0, copy[i], 0, temp[i].length);
		}
		
		return copy;
	}
}

class Point2 {
	int x;
	int y;
	List<Character> keyList;
	int cnt;
	boolean[][] visited;

	public Point2(int x, int y, List<Character> keyList, int cnt, boolean[][] visited) {
		super();
		this.x = x;
		this.y = y;
		this.keyList = keyList;
		this.cnt = cnt;
		this.visited = visited;
	}
	
}