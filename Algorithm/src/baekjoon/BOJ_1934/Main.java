package baekjoon.BOJ_1934;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int gcd;
	static int lcm;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= testCase; tc++) {
			String[] numbers = br.readLine().split(" ");
			
			int num1 = Integer.parseInt(numbers[0]);
			int num2 = Integer.parseInt(numbers[1]);
			
			if(num1 > num2)
				GCD(num1, num2);
			else
				GCD(num2, num1);
			LCM(num1, num2);
			
			sb.append(lcm).append("\n");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	public static void GCD(int num1, int num2) {
		int remain = num1 % num2;
		if(remain == 0) {
			gcd = num2;
			return;
		}
		GCD(num2, remain);
	}
	
	public static void LCM(int num1, int num2) {
		lcm = gcd * (num1 / gcd) * (num2 / gcd);
	}
}
