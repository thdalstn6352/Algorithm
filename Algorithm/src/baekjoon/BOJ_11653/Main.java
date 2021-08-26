package baekjoon.BOJ_11653;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[] numbers;
	static List<Integer> primeNums = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int N = Integer.parseInt(br.readLine());
		
		getPrimeNum();
		int i = 0;
		while(N != 1) {
			while(N % primeNums.get(i) == 0) {
				sb.append(primeNums.get(i)).append("\n");
				N /= primeNums.get(i);
			}
			i++;
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		
	}
	public static void getPrimeNum() {
		numbers = new int[10000001];
		for(int i = 2; i < numbers.length; i++) {
			numbers[i] = i;
		}
		for(int j = 2; j < Math.sqrt(numbers.length); j++) {
			if(numbers[j] == 0)
				continue;

			for(int k = j + j; k < numbers.length; k+=j) {
				numbers[k] = 0;
			}
		}
		
		for(int idx = 0, num = 0; idx < numbers.length; idx++) {
			if(numbers[idx] == 0)
				continue;
			primeNums.add(numbers[idx]);
		}
	}
}
