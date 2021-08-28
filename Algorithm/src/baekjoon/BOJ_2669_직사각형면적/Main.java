package baekjoon.BOJ_2669_직사각형면적;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int[][] map = new int[101][101];
		
		
		for(int tc = 1; tc <= 4; tc++) {
			String[] msg = br.readLine().split(" ");
			int x1 = Integer.parseInt(msg[0]); //1
			int y1 = Integer.parseInt(msg[1]); //2
			int x2 = Integer.parseInt(msg[2]); //4
			int y2 = Integer.parseInt(msg[3]); //4
			
			for(int r = x1; r < x2; r++) {
				for(int c = y1; c < y2; c++) {
					map[r][c] = 1;
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
