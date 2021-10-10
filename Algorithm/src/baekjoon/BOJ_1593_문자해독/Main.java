package baekjoon.BOJ_1593_문자해독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] gs = br.readLine().split(" ");
		int g = Integer.parseInt(gs[0]);
		int s = Integer.parseInt(gs[1]);
		
		char[] W = br.readLine().toCharArray();
		char[] S = br.readLine().toCharArray();
		
		int[] target = new int[52];
		int[] result = new int[52];
		int answer = 0;
		
		for(char c : W) {
			int val = c >= 'a' ? c - 'a' : c - 'A' + 26;
			target[val]++;
		}
		
		for(int i = 0; i < g; i++) {
			int val = S[i] >= 'a' ? S[i] - 'a' : S[i] - 'A' + 26;
			result[val]++;
		}
		if(isCorrect(target, result))
			answer++;
		
		for(int idx = g; idx < s; idx++) {
			int pre = S[idx - g] >= 'a' ? S[idx - g] - 'a' : S[idx - g] - 'A' + 26;
			int next = S[idx] >= 'a' ? S[idx] - 'a' : S[idx] - 'A' + 26;
			result[pre]--;
			result[next]++;
			
			if(isCorrect(target, result))
				answer++;
		}
		System.out.println(answer);
		
	}
	
	private static boolean isCorrect(int[] target, int[] result) {
		for(int i = 0; i < 52; i++) {
			if(target[i] != result[i])
				return false;
		}
		return true;
	}
}
