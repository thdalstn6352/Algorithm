package baekjoon.BOJ_3052_나머지;

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
	
		int[] remain = new int[42];
		
		for(int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			remain[num % 42] = 1;
		}
		
		int cnt = 0;
		for(int val : remain) {
			if(val == 1)
				cnt++;
		}
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}
