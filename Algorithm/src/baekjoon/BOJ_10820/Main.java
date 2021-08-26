package baekjoon.BOJ_10820;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		
		String input;
		while((input = br.readLine()) != null) {
			count = new int[4];
			sb = new StringBuilder();
			for(int c = 0; c < input.length(); c++) {
				char val = input.charAt(c);
				
				if(val >= 97 && val <=122)
					count[0]++;
				else if(val >= 65 && val <=90)
					count[1]++;
				else if(val >= 48 && val <=57)
					count[2]++;
				else if(val == ' ')
					count[3]++;
			}
			for(int cnt : count) {
				sb.append(cnt).append(" ");
			}
			sb.append("\n");
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			br.close();
			bw = null;
			br = null;
		}
	}
}
