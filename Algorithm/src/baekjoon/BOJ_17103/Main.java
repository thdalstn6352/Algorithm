package baekjoon.BOJ_17103;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[] num = new int[1000001];
	static List<Integer> primeList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		getPrime();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < testCase; tc++) {
			int val = Integer.parseInt(br.readLine());
			int cnt = 0;

			for(int i = 2; i <= val/2; i++) {
				if(num[i] == 0)
					continue;
				if(num[val - i] != 0)
					cnt++;
			}
			sb.append(cnt).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
		
	}
	
	public static void getPrime() {
		for(int i = 2; i < num.length; i++) {
			num[i] = i;
		}
		
		for(int i = 2; i <= Math.sqrt(num.length); i++) {
			if(num[i] == 0)
				continue;
			for(int j = i+i; j < num.length; j+=i) {
				num[j] = 0;
			}
		}
		for(int i = 0; i < num.length; i++) {
			if(num[i] == 0)
				continue;
		}
	}
	
}
