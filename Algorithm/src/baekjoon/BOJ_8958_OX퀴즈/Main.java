package baekjoon.BOJ_8958_OX퀴즈;

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
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String msg = br.readLine();
			int cnt = 0;
			int sum = 0;
			for(int i = 0; i < msg.length(); i++) {
				if(msg.charAt(i) == 'O') {
					cnt++;
					sum += cnt;
				}
				else
					cnt = 0;
			}
			sb.append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
		
	}
}
