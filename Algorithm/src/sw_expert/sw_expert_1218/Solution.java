package sw_expert.sw_expert_1218;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		
		//int test_case = Integer.parseInt(br.readLine());
		int test_case = 10;
		
		for(int tc = 1; tc <= test_case; tc++) {
			int charNum = Integer.parseInt(br.readLine());
			String string = br.readLine();
			
			OUTER: for(int c = 0; c < charNum; c++) {
				char bracket = string.charAt(c);
				switch (bracket) {
				case ')':
					if(stack.peek() == '(') {
						stack.pop();
					}
					else {
						break OUTER;
					}
					break;
				case ']':
					if(stack.peek() == '[') {
						stack.pop();
					}
					else {
						break OUTER;
					}
					break;
				case '}':
					if(stack.peek() == '{') {
						stack.pop();
					}
					else {
						break OUTER;
					}
					break;
				case '>': 
					if(stack.peek() == '<') {
						stack.pop();
					}
					else {
						break OUTER;
					}
					break;
				default: stack.push(bracket);
				
				}
				
			}
			if(stack.isEmpty()) 
				sb.append("#").append(tc).append(" ").append("1").append("\n");
			
			else
				sb.append("#").append(tc).append(" ").append("0").append("\n");
			stack.clear();
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}
