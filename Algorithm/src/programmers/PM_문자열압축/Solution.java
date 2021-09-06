package programmers.PM_문자열압축;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Queue<String> queue = new LinkedList<>();
		
		String s = br.readLine();
		int length = s.length();
		int minLength = Integer.MAX_VALUE;
		
		for(int i = 1; i < length / 2; i++) {
			int flag = 0;
			int val = length / i;

			if(length % i != 0)
				flag = 1;

			int size = 0;

			if(val % 2 == 1) {
				size = val - 1;
				flag = 1;
			}
			else{
				size = val;
			}
			
			int len = size * i - i;
			
			for(int c = 0; c < len; c += (i+i)) {
				String msg1 = s.substring(c, c + i);
				String msg2 = s.substring(c + i, c + (2 * i));
				
				if(!queue.isEmpty()) {
					if(!queue.peek().equals(msg1)) {
						String queSize = Integer.toString(queue.size());
						sb.append(queSize).append(queue.poll());
						queue.clear();
					}
				}
				
				if(msg1.equals(msg2)) {
					queue.offer(msg1);
					queue.offer(msg2);
				}
				else {
					sb.append(msg1);
				}
				System.out.print(msg1 + " ");
				System.out.println(msg2);
			}
			if(flag == 1) {
				System.out.printf("나머지 : %s%n", s.substring(size * i));
			}
			
		}
	}
}
