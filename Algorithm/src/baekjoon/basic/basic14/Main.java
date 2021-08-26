package baekjoon.basic.basic14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Queue<Character> queue = new LinkedList<Character>();
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		map.put('(', 1);
		map.put('+', 2);
		map.put('-', 2);
		map.put('*', 3);
		map.put('/', 3);
		
		String command = br.readLine();
		int flag = 0;
		
		for(char val : command.toCharArray()) {
			if(val >= 65 && val <= 90) {
				queue.offer(val);
			}
			else if(val == ')'){
				while(true) {
					char operand = stack.pop();
					if(operand == '(')
						break;
					queue.offer(operand);
				}
			}
			else {
				while(!stack.isEmpty() && (map.get(stack.peek()) >= map.get(val)) && val != '(') {
						queue.offer(stack.pop());
				}
				stack.push(val);
			}
		}
		while(!stack.isEmpty())
			queue.offer(stack.pop());
		while(!queue.isEmpty())
			sb.append(queue.poll());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}

