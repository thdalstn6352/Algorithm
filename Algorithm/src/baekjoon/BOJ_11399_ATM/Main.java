package baekjoon.BOJ_11399_ATM;

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
	
		int num = Integer.parseInt(br.readLine());
		int[] times = new int[num];
		int[] res = new int[num];
		int sum = 0;
		String[] msg = br.readLine().split(" ");
		for(int i = 0; i < msg.length; i++) {
			times[i] = Integer.parseInt(msg[i]);
		}
		Arrays.sort(times);
		for(int idx = 0; idx < num; idx++) {
			if(idx == 0)
				res[idx] = times[idx];
			else
				res[idx] = res[idx - 1] + times[idx];
			sum += res[idx];
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
