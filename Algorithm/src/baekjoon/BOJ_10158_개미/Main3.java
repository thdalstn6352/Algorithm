package baekjoon.BOJ_10158_개미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main3 {
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
		
		int endX = (startX + t) % (2 * w);
		int endY = (startY + t) % (2 * h);
		
		endX = w - Math.abs(w - endX);
		endY = h - Math.abs(h - endY);
		
		sb.append(endX).append(" ").append(endY);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
		
	}
}
