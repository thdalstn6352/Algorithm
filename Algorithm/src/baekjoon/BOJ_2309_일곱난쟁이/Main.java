package baekjoon.BOJ_2309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static List<Integer> list = new ArrayList<>();
	static int[] yodle = new int[7];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		for(int i = 0; i < 9; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		combination(0, 0);
		bw.write(sb.toString());
		bw.flush();
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int idx = 0; idx < 7; idx++) {
				sum += yodle[idx];
			}
			if(sum == 100) {
				Arrays.sort(yodle);
				for(int i = 0 ; i < 7; i++) {
					sb.append(yodle[i]).append("\n");
				}
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			yodle[cnt] = list.get(i);
			combination(cnt+1, i+1);
		}
	}
}
