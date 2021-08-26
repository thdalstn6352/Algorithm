package baekjoon.basic.basic13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Double> stack = new Stack<Double>();
		Queue<Character> queue = new LinkedList<Character>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		int operandNum = Integer.parseInt(br.readLine());
		
		String expression = br.readLine();
		
		for(int e = 0; e < expression.length(); e++) {
			queue.offer(expression.charAt(e));
		}
		
		for(int oper = 0; oper < operandNum; oper++) {
			char c = (char)(65 + oper);
			int num = Integer.parseInt(br.readLine());
			map.put(c, num);
		}
		
		while(!queue.isEmpty()) {
			char c = queue.poll();
			double result, fnum, snum;
			switch(c) {
			case '+':
				result = stack.pop() + stack.pop();
				stack.push(result);
				break;
				
			case '-':
				fnum = stack.pop();
				snum = stack.pop();
				result = snum - fnum;
				stack.push(result);
				break;
				
			case '*':
				fnum = stack.pop();
				snum = stack.pop();
				result = fnum * snum;
				stack.push(result);
				break;
				
			case '/':
				fnum = stack.pop();
				snum = stack.pop();
				result = snum / fnum;
				stack.push(result);
				break;
				
			default:
				stack.push((double)map.get(c));
			}
		}
		System.out.printf("%.2f",stack.pop());
	}
}
