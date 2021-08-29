package baekjoon.BOJ_2999_비밀이메일;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String msg = br.readLine();
		
		int N = msg.length();
		int R = 0;
		int C = 0;
		char[][] msgs;
		
		for(int i = 1; i < N; i++) {
			if(N % i == 0) {
				if((N / i) >= i) {
					R = i;
					C = N / i;
				}
				else
					break;
			}
		}

		msgs = new char[R][C];
		int count = 0;
		
		for(int c = 0; c < C; c++) {
			for(int r = 0; r < R; r++) {
				msgs[r][c] = msg.charAt(count++);
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				sb.append(msgs[r][c]);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
		
	}
}
