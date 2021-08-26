package baekjoon.BOJ_2745;

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
	
		String[] msg = br.readLine().split(" ");
		String N = msg[0];
		int B = Integer.parseInt(msg[1]);
		int sum = 0;
		
		for(int i = 0; i < N.length(); i++) {
			int num = 0;
			char c = N.charAt(N.length() - 1 - i);
			if(c >= 48 && c <= 57) {
				num = (c - '0') * (int)Math.pow(B, i);
			}
			else {
				num = (c - 55) * (int)Math.pow(B, i);
			}
			
			sum += num;
		}
		sb.append(sum);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}
