package baekjoon.BOJ_11655;

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
		
		String msg = br.readLine();
		
		for(int c = 0; c < msg.length(); c++) {
			char value = msg.charAt(c);
			if((value >= 65 && value <= 77) || (value >= 97 && value <= 109)) {
				value += 13;
			}
			else if((value >= 78 && value <= 90) || (value >= 110 && value <= 122)) {
				value -= 13;
			}
			
			sb.append(value);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}
