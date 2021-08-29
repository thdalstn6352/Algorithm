package baekjoon.BOJ_17413_단어뒤집기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		Stack<Character> stack = new Stack<>();
		
		String msg = br.readLine();
		int flag = 0;
		
		for(int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);
			
			if(c == '<' || c == '>' || flag == 1) {
				if(c == '<') {
					flag = 1;
					while(!stack.isEmpty())
						sb.append(stack.pop());
				}
				else if(c == '>')
					flag = 0;
				sb.append(c);
				continue;
			}
			
			if(c == ' ') {
				while(!stack.isEmpty())
					sb.append(stack.pop());
				sb.append(' ');
			}
			else {
				stack.push(c);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		
	}
}
