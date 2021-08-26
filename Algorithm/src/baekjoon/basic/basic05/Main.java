package baekjoon.basic.basic05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		List<Character> msg = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String value = br.readLine();
		int cursor = value.length();
		
		for(int i = 0; i < value.length(); i++) {
			msg.add(value.charAt(i));
		}
		
		int test_case = Integer.parseInt(br.readLine());

		for(int tc = 0; tc < test_case; tc++) {
			String string = br.readLine();
			char c = string.charAt(0);
			
			if(c == 'L') {
				if(cursor != 0)
					cursor--;
			}
			else if(c == 'D') {
				if(cursor != msg.size())
					cursor++;
			}
			
			else if(c == 'B') {
				if(cursor != 0) {
					msg.remove(cursor - 1);
					cursor--;
				}
				
			}
			else {
				msg.add(cursor, string.charAt(2));
				cursor++;
			}
		}

		for(char item : msg) {
			sb.append(item);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		bw = null;
		br = null;
		sb = null;
	}
}
