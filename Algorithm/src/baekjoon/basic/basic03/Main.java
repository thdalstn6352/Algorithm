package baekjoon.basic.basic03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			sb.append(solve(br.readLine())).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	public static String solve(String msg) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);
			if(c == '(') {
				stack.push(c);
			}
			else if(stack.isEmpty()) {
				return "NO";
			}
			else {
				stack.pop();
			}
		}
		
		if(stack.isEmpty()) 
			return "YES";
		else
			return "NO";
		
	}
}
