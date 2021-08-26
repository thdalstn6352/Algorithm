package baekjoon.BOJ_2493;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> height_stack = new Stack<Integer>();
		Stack<Integer> index_stack = new Stack<Integer>();
		
		int topNum = Integer.parseInt(br.readLine());
		String[] tops = br.readLine().split(" ");
		
		// 데이터 입력
		for(int index = 0; index < topNum; index++) {
			int top_height = Integer.parseInt(tops[index]);
			if(height_stack.isEmpty()) {
				sb.append("0").append(" ");
				height_stack.push(top_height);
				index_stack.push(index);
				continue;
			}
			while(true) {
				if(height_stack.peek() < top_height) {
					height_stack.pop();
					index_stack.pop();
					if(height_stack.isEmpty()) {
						sb.append("0").append(" ");
						height_stack.push(top_height);
						index_stack.push(index);
						break;
					}
				}
				else {
					sb.append(index_stack.peek() + 1).append(" ");
					height_stack.push(top_height);
					index_stack.push(index);
					break;
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
