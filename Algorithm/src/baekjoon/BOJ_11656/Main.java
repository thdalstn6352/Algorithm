package baekjoon.BOJ_11656;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		
		char[] msg = br.readLine().toCharArray();
		
		for(int i = 0; i < msg.length; i++) {
			String line = "";
			for(int c = i; c < msg.length; c++) {
				line += Character.toString(msg[c]);
			}
			list.add(line);
		}
		Collections.sort(list);
		
		for(String m : list) {
			sb.append(m).append("\n");
		}
		sb.toString().trim();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}
