package baekjoon.BOJ_10817_세수;

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
	
		int[] num = new int[3];
		String[] numbers = br.readLine().split(" ");
		for(int i = 0; i < numbers.length; i++) {
			num[i] = Integer.parseInt(numbers[i]);
		}
		Arrays.sort(num);
		sb.append(num[1]);
		bw.write(sb.toString());
		bw.flush();
		
	}
	
}
