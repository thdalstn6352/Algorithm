package sw_expert.SWEA_1223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	static Map<Character, Integer> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		map = new HashMap<Character, Integer>();
		map.put('*', 2);
		map.put('/', 2);
		map.put('+', 1);
		map.put('-', 1);
	
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++) {
			int length = Integer.parseInt(br.readLine());
			String msg = br.readLine();
			sb.append("#").append(tc).append(" ").append(calc(postfix(msg, length))).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static String postfix(String msg, int length) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			char c = msg.charAt(i);
			if(c >= 48 && c <= 57) {
				sb.append(c);
			}
			else {
				if(stack.isEmpty())
					stack.push(c);
				else {
					while(true) {
						if(stack.isEmpty() || map.get(stack.peek()) < map.get(c)) {
							stack.push(c);
							break;
						}
						else {
							sb.append(stack.pop());
						}
					}
				}
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
	
	public static int calc(String msg) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);
			if(c >= 48 && c <= 57) {
				stack.push(c - '0');
			}
			else {				
				switch(c) {
				case '+':
					stack.push(stack.pop() + stack.pop());
					break;
				case '*':
					stack.push(stack.pop() * stack.pop());
					break;
				}
			}
		}
		
		return stack.pop();		
	}
}
