package baekjoon.BOJ_2563_색종이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[][] map = new int[101][101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			String[] Axis = br.readLine().split(" ");
			int x = Integer.parseInt(Axis[0]);
			int y = Integer.parseInt(Axis[1]);
			
			int rowSize = x + 10;
			int colSize = y + 10;
			
			for(int i = x; i < rowSize; i++) {
				for(int j = y; j < colSize; j++) {
					map[i][j] = 1;
				}
			}
		}
		int count = 0;
		
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[0].length; c++) {
				if(map[r][c] == 1)
					count++;
			}
		}
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}
