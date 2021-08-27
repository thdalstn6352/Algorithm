package baekjoon.BOJ_10158_개미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
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

		
		int t = Integer.parseInt(br.readLine());
		
		int offsetX = 1;
		int offsetY = 1;
		
		for(int i = 0; i < t; i++) {
			if(startX == w || startX == 0) {
				offsetX = -offsetX;
			}
			if(startY == h || startY == 0) {
				offsetY = -offsetY;
			}
			startX += 1 * offsetX;
			startY += 1 * offsetY;
		}
		
		sb.append(startX).append(" ").append(startY);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
		
	}
}
