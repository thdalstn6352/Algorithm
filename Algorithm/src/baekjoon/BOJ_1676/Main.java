package baekjoon.BOJ_1676;

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
		
		int count = 0;
		String num = br.readLine();
		
		BigInteger sum = fact(num);
		char[] sumChar = sum.toString().toCharArray();
		
		for(int i = sumChar.length - 1; i >=0; i--) {
			
			if(sumChar[i] == '0')
				count++;
			else
				break;
		}
		
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw=null;
		br=null;
	}
	public static BigInteger fact(String num) {
		BigInteger n = new BigInteger(num);
		
		if(n.toString() == "1" || n.toString() == "0")
			return new BigInteger("1");
		BigInteger sub = new BigInteger("1");

		return n.multiply(fact(n.subtract(sub).toString()));
		
	}
}
