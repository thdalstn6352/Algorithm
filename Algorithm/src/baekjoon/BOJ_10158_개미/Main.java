package baekjoon.BOJ_10158_개미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[][] deltas = { {1, 1}, {-1, 1}, {1, -1}, {-1, -1} };
							// 우하		우상		좌하		좌상
	static int w, h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] mapSize = br.readLine().split(" ");
		String[] locate = br.readLine().split(" ");
		
		w = Integer.parseInt(mapSize[0]);
		h = Integer.parseInt(mapSize[1]);

		
		int startX = Integer.parseInt(locate[0]);
		int startY = Integer.parseInt(locate[1]);
		int flag = 0; // 오른쪽 아래
		
		int t = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int nextFlag = -1;
		int temp = -1;
		
		while(cnt < t) {
			int min = 0;
			int rowChange = 0;
			int colChange = 0;
			
			switch(flag) {
			case 0:
				rowChange = w - startX;
				colChange = h - startY;
				
				if(rowChange < colChange) {
					nextFlag = 1;
				}
				else if(rowChange > colChange) {
					nextFlag = 2;
				}
				else {
					nextFlag = 3;
				}
				break;
			case 1:
				rowChange = startX - 0;
				colChange = h - startY;
				
				if(rowChange < colChange) {
					nextFlag = 0;
				}
				else if(rowChange > colChange) {
					nextFlag = 3;
				}
				else {
					nextFlag = 2;
				}
				
				break;
			case 2:
				rowChange = w - startX;
				colChange = startY - 0;
				
				if(rowChange < colChange) {
					nextFlag = 3;
				}
				else if(rowChange > colChange) {
					nextFlag = 0;
				}
				else {
					nextFlag = 1;
				}
				
				break;
			case 3:
				rowChange = startX - 0;
				colChange = startY - 0;

				if(rowChange < colChange) {
					nextFlag = 2;
				}
				else if(rowChange > colChange) {
					nextFlag = 1;
				}
				else {
					nextFlag = 0;
				}
				break;
			}
			
			min = Math.min(rowChange, colChange);
			startX += min * deltas[flag][0];
			startY += min * deltas[flag][1];
			cnt += min;
			temp = flag;
			flag = nextFlag;
		}
		
		int resX = startX + (cnt - t) * deltas[temp][0] * (-1);
		int resY = startY + (cnt - t) * deltas[temp][1] * (-1);
		
		sb.append(resX).append(" ").append(resY);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
		
	}
}
