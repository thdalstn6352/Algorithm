package baekjoon.BOJ_10430;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] numbers = br.readLine().split(" ");
		
		int A = Integer.parseInt(numbers[0]);
		int B = Integer.parseInt(numbers[1]);
		int C = Integer.parseInt(numbers[2]);
		
		int result1 = (A + B) % C;
		int result2 = ((A % C) + (B % C)) % C;
		int result3 = (A * B) % C;
		int result4 = ((A % C) * (B % C)) % C;
		
		sb.append(result1).append("\n");
		sb.append(result2).append("\n");
		sb.append(result3).append("\n");
		sb.append(result4);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}
