package baekjoon.BOJ_1463;

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
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while(N != 1) {
			if(N % 3 == 0) {
				N /= 3;
				cnt++;
				continue;
			}
			else {
				N -= 1;
				cnt++;
			}
			
			if(N % 2 == 0) {
				N /= 2;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	
	}
}
