package baekjoon.BOJ_6064_카잉달력;

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
			String[] msg = br.readLine().split(" ");
			int M = Integer.parseInt(msg[0]);
			int N = Integer.parseInt(msg[1]);
			
			int x = Integer.parseInt(msg[2]) - 1;
			int y = Integer.parseInt(msg[3]) - 1;
			
			int flag = 0;
			int gcd = M > N ? gcd(M, N) : gcd(N, M);
			int lcm = (M * N) / gcd;
			
			for(int i = x; i < lcm; i += M) {
				if(i % N == y) {
					sb.append(i+1).append("\n");
					flag = 1;
					break;
				}
			}
			
			if(flag == 0)
				sb.append(-1).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
	
	public static int gcd(int num1, int num2) {
		if(num1 % num2 == 0) {
			return num2;
		}
		return gcd(num2, num1%num2);
	}
}
