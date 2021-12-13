package baekjoon.BOJ_1759;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	static int L, C;
	static char[] charArr, res; 
	static boolean[] isSelected;
	static List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');
	static List<String> result = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] msg = br.readLine().split(" ");
		
		L = Integer.parseInt(msg[0]);
		C = Integer.parseInt(msg[1]);
	
		charArr = new char[C];
		isSelected = new boolean[C];
		res = new char[L];
		
		String[] chars = br.readLine().split(" ");
		
		for(int i = 0; i < chars.length; i++) {
			charArr[i] = chars[i].charAt(0);
		}
		
		permutation(0);
		
		Collections.sort(result);
		for(String s : result) {
			sb.append(s).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
	
	private static void permutation(int cnt) {
		if(cnt == L) {
			int vowelCnt = 0;
			for(int i = 0; i < L; i++) {
				if(vowel.contains(res[i]))
					vowelCnt++;
			}
			if(vowelCnt >= 1 && vowelCnt <= L - 2) {
				result.add(String.valueOf(res));
			}
			return;
		}
		
		for(int i = 0; i < C; i++) {
			if(isSelected[i])
				continue;
			res[cnt] = charArr[i];
			
			if(cnt >= 1) {
				if(res[cnt - 1] > res[cnt]) {
					continue;
				}
			}
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	
}
