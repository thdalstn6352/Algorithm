package baekjoon.BOJ_1987;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int R, C, result = 1;
	static char[][] map;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	static List<Character> list;
	static boolean[][] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] msg = br.readLine().split(" ");
		R = Integer.parseInt(msg[0]);
		C = Integer.parseInt(msg[1]);
		map = new char[R][C];
		isSelected = new boolean[R][C];
		list = new ArrayList<Character>();
		
		for(int r = 0; r < R; r++) {
			String lines = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = lines.charAt(c);
			}
		}
		
		searchAlphabet(0, 0, 0);
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
		
	}
	public static void searchAlphabet(int x, int y, int count) {
		
		if(list.contains(map[x][y]) || isSelected[x][y]) {
			result = Math.max(result, count);
			return;
		}
		
		isSelected[x][y] = true;
		list.add(map[x][y]);
		for(int d = 0; d < deltas.length; d++) {
			
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			
			
			if(nx >= 0 && nx < R && ny >= 0 && ny < C ) {			
				searchAlphabet(nx, ny, count+1);
			}
		}
		isSelected[x][y] = false;
		list.remove(list.size()-1);
	}
	
}
