package baekjoon.alphabet_10808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] alphabet;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		alphabet = new int[26];
		
		String msg = br.readLine();
		
		for(int c = 0; c < msg.length(); c++) {
			alphabet[msg.charAt(c) - 97]++;
		}
		
		for(int value : alphabet)
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
