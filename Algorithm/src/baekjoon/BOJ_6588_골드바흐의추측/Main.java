package baekjoon.BOJ_6588;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] primeNumbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		primeNumbers = new int[1000001];
		int flag = 0;
		getPrime();
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0)
				break;
			
			for(int i = 2; i < primeNumbers.length; i++) {
				if(primeNumbers[i] != 0 && primeNumbers[num - i] != 0) {
					flag = 1;
					sb.append(num).append(" ").append("=").append(" ").append(primeNumbers[i]).append(" ").append("+").append(" ").append(primeNumbers[num - i]).append("\n");
					break;
				}
			}
			if(flag == 0)
				sb.append("Goldbach's conjecture is wrong.").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void getPrime() {
		for(int i = 2; i <= 1000000; i++) {
			primeNumbers[i] = i;
		}
		for(int i = 2; i <= Math.sqrt(1000000); i++) {
			for(int j = i+i; j <= 1000000; j+=i) {
				primeNumbers[j] = 0;
			}
		}
		for(int i = 2; i <= 1000000; i++) {
			if(primeNumbers[i] == 0)
				continue;
		}
	}
}
