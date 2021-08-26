package baekjoon.BOJ_1476;

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
		
		int E = Integer.parseInt(msg[0]);
		int S = Integer.parseInt(msg[1]);
		int M = Integer.parseInt(msg[2]);
		
		int e = 1, s = 1, m = 1;
		int year = 1;
		
		while(true) {
			e %= 16;
			s %= 29;
			m %= 20;
			if(e == 0)
				e = 1;
			if(s == 0)
				s = 1;
			if(m == 0)
				m = 1;
			
			if(E == e && S == s && M == m)
				break;
			e++;
			s++;
			m++;
			year++;
		}
		sb.append(year);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}
