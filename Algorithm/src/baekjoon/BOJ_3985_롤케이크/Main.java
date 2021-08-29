package baekjoon.BOJ_3985_롤케이크;

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
	
		int L = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		int[] cakeCnt = new int[num + 1];
		int[] cake = new int[L];
		int maxCake = 0;
		int maxIdx = 0;
		
		int eatCake = 0;
		int eatIdx = 0;
		
		for(int i = 1; i <= num; i++) {
			String[] info = br.readLine().split(" ");
			int start = Integer.parseInt(info[0]);
			int end = Integer.parseInt(info[1]);
			int eat = 0;
			
			cakeCnt[i] = end - start + 1;
			if(maxCake < cakeCnt[i]) {
				maxCake = cakeCnt[i];
				maxIdx = i;
			}
			
			for(int idx = start - 1; idx < end; idx++) {
				if(cake[idx] != 0) {
					continue;
				}
				cake[idx] = i;
				eat++;
			}
			if(eatCake < eat) {
				eatCake = eat;
				eatIdx = i;
			}
		}
		sb.append(maxIdx).append("\n");
		sb.append(eatIdx);
	
		bw.write(sb.toString());
		bw.flush();
		
	}
}
