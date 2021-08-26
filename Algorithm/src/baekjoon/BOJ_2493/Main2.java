package baekjoon.BOJ_2493;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int topNum = Integer.parseInt(br.readLine());
		String[] tops = br.readLine().split(" ");
		int[] top = new int[topNum];
		int[] result = new int[topNum];
		
		// 데이터 입력
		for(int t = 0; t < topNum; t++) {
			top[t] = Integer.parseInt(tops[t]);
		}
		
		for(int start = top.length - 1; start >= 0; start--) {
			int topLength = top[start];
			for(int cur = start - 1; cur >= 0; cur--) {
				if(topLength <= top[cur]) {
					result[start] = cur + 1;
					break;
				}
			}
		}
		for(int len : result) {
			sb.append(len).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
