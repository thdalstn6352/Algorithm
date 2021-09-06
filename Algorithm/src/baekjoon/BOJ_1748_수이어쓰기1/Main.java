package baekjoon.BOJ_1748_수이어쓰기1;

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
	
		int[] value = new int[9];
		
		// 각 자릿수 길이의 합
		for(int i = 1; i <= 8; i++) {
			value[i] = 9 * i * (int)Math.pow(10, i - 1);
		}

		String target = br.readLine();
		int targetNum = Integer.parseInt(target);
		int length = target.length();
		int sum = 0;
		
		for(int i = 0; i < length; i++) {
			sum += value[i];
		}
		
		if(targetNum < 10)
			sum += targetNum;
		else
			sum += length * (targetNum - (int)Math.pow(10, length - 1) + 1);
			
		sb.append(sum);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}
