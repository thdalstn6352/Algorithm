package baekjoon.basic.basic11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Stack<Integer> sequence = new Stack<Integer>();
		Stack<Integer> save = new Stack<Integer>();
		Stack<Integer> result = new Stack<Integer>();
		
		int size = Integer.parseInt(br.readLine());
		
		String[] string = br.readLine().split(" ");
		for(String num : string) {
			sequence.push(Integer.parseInt(num));
		}
		
		while(!sequence.isEmpty()) {
			int top = sequence.peek();
			
			if(save.isEmpty()) {
				result.push(-1);
				save.push(sequence.pop());
				continue;
			}
			
			if(top < save.peek()) {
				result.push(save.peek());
				save.push(sequence.pop());
			}
			else {
				save.pop();
				continue;
			}
		}
		
		while(!result.isEmpty())
			sb.append(result.pop()).append(" ");
		sb.toString().trim();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}
