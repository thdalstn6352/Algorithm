package baekjoon.BOJ_11576;

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
		
		String[] msg = br.readLine().split(" ");
		
		int A = Integer.parseInt(msg[0]);
		int B = Integer.parseInt(msg[1]);
		
		int length = Integer.parseInt(br.readLine());
		int sum = 0;
		String[] nums = br.readLine().split(" ");
		for(int i = 0; i < length; i++) {
			int num = Integer.parseInt(nums[i]) * (int)Math.pow(A, length - 1 - i);
			sum += num;
		}
		
		while(sum != 0) {
			int remain = sum % B;
			stack.push(remain);
			sum /= B;
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
		
	}
}
