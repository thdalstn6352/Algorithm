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
		
		String s = br.readLine();
		int length = s.length();
		int minLength = Integer.MAX_VALUE;
		if(length == 1) {
			System.out.println(1);
			return;
		}
		for(int i = 1; i <= length / 2; i++) {
			StringBuilder sb = new StringBuilder();
			int len = 0;
			String target = "";
			int flag = 0;
			int count = 1;
			int val = length / i;
			
			if(length % i != 0)
				flag = 1;
			
			int size = val * i;
			
			for(len = 0; len <= size - i; len+=i) {
				String msg = s.substring(len, len + i);
				//System.out.println(msg);
				if(target.equals(msg)) {
					count++;
				}
				else {
					if(count > 1) {
						sb.append(count);
					}
					sb.append(target);
					target = msg;
					count = 1;
				}
				
				if(len == size - i) {
					if(count > 1) {
						sb.append(count);
					}
					sb.append(target);
				}
			}
			if(flag == 1) {
				sb.append(s.substring(len));
			}
			minLength = Math.min(minLength, sb.toString().length());
		}
		System.out.println(minLength);
	}
}
