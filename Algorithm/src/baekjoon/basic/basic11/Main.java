package baekjoon.basic.basic11;

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

		int size = Integer.parseInt(br.readLine());
		
		int[] sequence = new int[size];
		int[] result = new int[size];
		Arrays.fill(result, -1);
		
		String[] string = br.readLine().split(" ");
		for(int i = 0; i < string.length; i++) {
			sequence[i] = Integer.parseInt(string[i]);
		}
		
		for(int n = 0; n < sequence.length; n++) {
			int target = sequence[n];
			for(int cnt = n+1; cnt < sequence.length; cnt++) {
				if(target < sequence[cnt]) {
					result[n] = sequence[cnt];
					break;
				}
				
			}
		}
		
		for(int value: result)
			sb.append(value).append(" ");
		sb.toString().trim();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}
