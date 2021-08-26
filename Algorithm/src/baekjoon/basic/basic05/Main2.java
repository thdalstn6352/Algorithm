package baekjoon.basic.basic05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> left_stack = new Stack<Character>();
		Stack<Character> right_stack = new Stack<Character>();
		
		
		String value = br.readLine();
		
		for(int i = 0; i < value.length(); i++) {
			left_stack.push(value.charAt(i));
		}
		
		int test_case = Integer.parseInt(br.readLine());

		for(int tc = 0; tc < test_case; tc++) {
			String string = br.readLine();
			char c = string.charAt(0);
			
			if(c == 'L') {
				if(!left_stack.isEmpty())
					right_stack.push(left_stack.pop());
			}
			else if(c == 'D') {
				if(!right_stack.isEmpty())
					left_stack.push(right_stack.pop());
			}
			else if(c == 'B') {
				if(!left_stack.isEmpty()) {
					left_stack.pop();
				}
			}
			else {
				left_stack.push(string.charAt(2));
			}
		}

		while(!left_stack.isEmpty()) {
			right_stack.push(left_stack.pop());
		}
		
		while(!right_stack.isEmpty()) {
			sb.append(right_stack.pop());
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		bw = null;
		br = null;
		sb = null;
	}
}