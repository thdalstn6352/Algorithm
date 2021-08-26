package baekjoon.BOJ_1212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String num = br.readLine();
		if(num.equals("0")) {
			System.out.println(0);
			return;
		}
		for(char c : num.toCharArray()) {
			int value = c - '0';
			for(int i = 4; i >=1; i /= 2) {
				queue.offer(value / i);
				value %= i;
			}
		}
		
		while(queue.peek() == 0)
			queue.poll();
		
		while(!queue.isEmpty()) {
			sb.append(queue.poll());
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
		
	}
	
}
