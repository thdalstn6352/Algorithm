package baekjoon.BOJ_10824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] command = br.readLine().split(" ");
		
		String AB = command[0] + command[1];
		String CD = command[2] + command[3];
		
		BigInteger result1 = new BigInteger(AB);
		BigInteger result2 = new BigInteger(CD);
		
		
		sb.append(result1.add(result2));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}
