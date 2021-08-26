package baekjoon.BOJ_1978;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] nums;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		nums = new int[num];
		String[] numbers = br.readLine().split(" ");
		
		for(int i = 0; i < numbers.length; i++) {
			nums[i] = Integer.parseInt(numbers[i]);
		}
		isPrime();
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw=null;
		br=null;
	}
	
	public static void isPrime() {
		for(int n : nums) {
			if(n == 1)
				continue;
			if(n == 2) {
				count++;
				continue;
			}
			OUTER:if(n % 2 == 1) {
				for(int i = 2; i < n/2; i++) {
					if(n % i == 0)
						break OUTER;
				}
				count++;
			}
		}
	}
}
