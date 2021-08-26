package baekjoon.BOJ_2493;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Top_Info> stack = new Stack<Top_Info>();
		
		int topNum = Integer.parseInt(br.readLine());
		String[] tops = br.readLine().split(" ");
		
		
		// 데이터 입력
		for(int t = 0; t < topNum; t++) {
			int top_height = Integer.parseInt(tops[t]);
			
			while(true) {
				if(stack.isEmpty()) {
					sb.append("0").append(" ");
					stack.push(new Top_Info(top_height, t));
					break;
				}
				if(stack.peek().height < top_height) {
					stack.pop();
				}
				else {
					sb.append(stack.peek().index + 1).append(" ");
					stack.push(new Top_Info(top_height, t));
					break;
				}
			}
			stack.push(new Top_Info(top_height, t));
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

class Top_Info {
	int height;
	int index;
	
	public Top_Info(int height, int index) {
		super();
		this.index = index;
		this.height = height;
	}
}
