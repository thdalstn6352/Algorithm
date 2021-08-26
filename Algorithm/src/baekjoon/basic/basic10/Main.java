package baekjoon.basic.basic10;

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
		Stack<stick> stack = new Stack<stick>();
		
		String brackets = br.readLine();
		int num = 0;
		
		for(int i = 0; i < brackets.length(); i++){
			char bracket = brackets.charAt(i);
			if(bracket == '(')
				stack.push(new stick(i, bracket));
			else {
				if(stack.peek().index == (i - 1)) {
					stack.pop();
					num += stack.size();
				}
				else {
					stack.pop();
					num++;
				}
			}
		}
		sb.append(num);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
		
	}
}

class stick {
	int index;
	char value;
	public stick() {
		super();
	}
	
	public stick(int index, char value) {
		super();
		this.index = index;
		this.value = value;
	}
	
}
