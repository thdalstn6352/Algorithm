package baekjoon.BOJ_5568_카드놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int n, k;
	static String[] numbers;
	static String[] result;
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		numbers = new String[n];
		result = new String[k];
		
		for(int i = 0; i < n; i++) {
			numbers[i] = br.readLine();
		}
		permutation(0, 0);
		System.out.println(set.size());
	}
	
	private static void permutation(int cnt, int flag) {
		if(cnt == k) {
			StringBuilder sb = new StringBuilder();
			for(String s : result) {
				sb.append(s);
			}
			set.add(sb.toString());
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if((flag & 1 << i) != 0)
				continue;
			result[cnt] = numbers[i];
			permutation(cnt+1, (flag | 1 << i));
		}
	}
}
