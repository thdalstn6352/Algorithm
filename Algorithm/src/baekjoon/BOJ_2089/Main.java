package baekjoon.BOJ_2089;

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

		Stack<Integer> stack = new Stack<>();
		
		int num = Integer.parseInt(br.readLine());
		if(num == 0) {
			System.out.println(0);
			return;
		}
		while(num != 1) {
			int quotient = num / -2;
			int remain = num % -2;
			
			if(remain < 0) {
				quotient += 1;
				remain = 1;
			}
			num = quotient;
			stack.push(remain);
		}
		stack.push(num);
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
		
	}
}
