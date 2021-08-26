package ThisIsCodingTest.dfsNbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SearchMiro {
	static int h, w;
	static char[][] map;
	static int[][] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] msg = br.readLine().split(" ");
		h = Integer.parseInt(msg[0]);
		w = Integer.parseInt(msg[1]);
		map = new char[h][w];
		isSelected = new int[h][w];
		
		Point start = null;
		Point dest = null;
		
		for(int r = 0; r < h; r++) {
			String lines = br.readLine();
			for(int c = 0; c < w; c++) {
				map[r][c] = lines.charAt(c);
				if(map[r][c] == 'S')
					start = new Point(r, c);
				else if(map[r][c] == 'G')
					dest = new Point(r, c);
			}
		}
		isSelected[start.x][start.y] = 1;
		
		bfs(start.x, start.y);
		sb.append(isSelected[dest.x][dest.y] - 1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		bw = null;
		br = null;
		
	}

	static int[][] deltas = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
	
	public static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		
		while(!queue.isEmpty()) {
			Point val = queue.poll();
			for(int d = 0; d < 4; d++) {
				int cnt = isSelected[val.x][val.y];
				
				int nx = val.x + deltas[d][0];
				int ny = val.y + deltas[d][1];
				
				if(nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] != '#' && isSelected[nx][ny] == 0) {
					isSelected[nx][ny] = cnt+1;
					queue.offer(new Point(nx, ny));
				}
			}
		}
	}
}

class Point {
	int x;
	int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}