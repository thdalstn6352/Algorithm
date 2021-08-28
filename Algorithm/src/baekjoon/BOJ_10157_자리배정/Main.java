package baekjoon.BOJ_10157_자리배정;

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
	
		
		String[] mapSize = br.readLine().split(" ");
		int R = Integer.parseInt(mapSize[0]);
		int C = Integer.parseInt(mapSize[1]);
		int K = Integer.parseInt(br.readLine());
		int flag = 0;
		int[][] map = new int[R][C];
		int[][] deltas = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
		int x = 0, y = 0;
		
		if(R * C < K) {
			System.out.println(0);
			return;
		}
	
		for(int count = 1; count <= K; count++) {
			map[x][y] = count;
			int nx = x + deltas[flag][0];
			int ny = y + deltas[flag][1];
			
			if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] != 0) 
				flag = (flag + 1) % 4;
				
			x += deltas[flag][0];
			y += deltas[flag][1];
		}
		
		int resX = x + 1 + deltas[flag][0] * (-1);
		int resY = y + 1 + deltas[flag][1] * (-1);
		
		sb.append(resX).append(" ").append(resY);
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	
	}
}
