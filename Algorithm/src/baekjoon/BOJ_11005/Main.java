package baekjoon.BOJ_11005;

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
		Stack<Character> stack = new Stack<>();
		String[] numbers = br.readLine().split(" ");
		
		int N = Integer.parseInt(numbers[0]);
		int B = Integer.parseInt(numbers[1]);
		
		while(N != 0) {
			int remain = N % B;
			if(remain >= 0 && remain <= 9)
				stack.push((char)(remain + 48));
			else {
				stack.push((char)(remain + 55));
			}
			N /= B;
		}
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
