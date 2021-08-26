package baekjoon.basic.basic09;

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
		Stack<Character> stack = new Stack<Character>();
		int flag = 1;
		
		String msg = br.readLine();

		for(int i = 0; i < msg.length(); i++) {
			//괄호 안의 문자는 push하지 않고 continue
			if(flag == 0 && msg.charAt(i) != '>') {
				sb.append(msg.charAt(i));
				continue;
			}

			if(msg.charAt(i) == '<') {
				if(!stack.isEmpty()) {
					while(!stack.isEmpty())
						sb.append(stack.pop());
				}
				flag = 0;
				sb.append("<");
				continue;
			}
			if(msg.charAt(i) == '>') {
				flag = 1;
				sb.append(">");
				continue;
			}
			
			if(msg.charAt(i) == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
				continue;
			}
			
			if(flag == 1) {
				stack.push(msg.charAt(i));
			}
		}
		if(!stack.isEmpty()) {
			while(!stack.isEmpty())
				sb.append(stack.pop());
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
		
	}
}
