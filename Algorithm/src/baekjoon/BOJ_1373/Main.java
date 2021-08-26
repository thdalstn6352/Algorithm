package baekjoon.BOJ_1373;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static Stack<Character> stack = new Stack<>();
	static Stack<Integer> result = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String value = br.readLine();
		for(char c : value.toCharArray()) {
			stack.push(c);
		}
		
		int size = value.length() % 3 == 0? value.length() / 3 : value.length() / 3 + 1;

		for(int i = 0; i < size; i++) {
			BinToOct();
		}
		
		while(!result.isEmpty()) {
			sb.append(result.pop());
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	public static void BinToOct() {		
		int s = 0;
		for(int i = 1; i <= 4; i *= 2) {
			if(stack.isEmpty())
				break;
			s += i * (stack.pop()-'0');
		}
		result.push(s);
	}
}
