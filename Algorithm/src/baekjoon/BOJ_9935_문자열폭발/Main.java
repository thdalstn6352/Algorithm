package baekjoon.BOJ_9935_문자열폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		Stack<Character> stack = new Stack<>();
		Stack<Character> temp = new Stack<>();
		
		String target = br.readLine();
		String bomb = br.readLine();
		char bombLastValue = bomb.charAt(bomb.length() - 1);
		String answer = "";
		
		for(int i = 0; i < target.length(); i++) {
			char value = target.charAt(i);
			stack.push(value);

			if(value == bombLastValue) {
				if(stack.size() >= bomb.length()) {
					for(int j = bomb.length() - 1; j >= 0; j--) {
						char num1 = stack.pop();
						char num2 = bomb.charAt(j);
						temp.push(num1);
						
						if(num1 != num2) {
							while(!temp.isEmpty())
								stack.push(temp.pop());
							break;
						}
					}
					temp.clear();
				}
			}
				
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		answer = sb.reverse().toString();
		
		if(answer.isEmpty())
			answer = "FRULA";
		
		System.out.println(answer);
	}
}

