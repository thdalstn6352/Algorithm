package baekjoon.BOJ_1339_단어수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Main {
	static int N, R;
	static Map<Character, Integer> map = new HashMap<>();
	static char[] alpha;
	static String[] numbers;
	static int max;
	static int Lengthflag = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		HashSet<Character> set = new HashSet<>();
		N = Integer.parseInt(br.readLine());
		numbers = new String[N];
		
		for(int i = 0; i < N; i++) {
			String text = br.readLine();
			numbers[i] = text;
			if(text.length() != 1)
				Lengthflag = 0;
			
			for(int j = 0; j < text.length(); j++) {
				set.add(text.charAt(j));
			}
		}
		R = set.size();
		alpha = new char[R];
		
		Iterator<Character> iter = set.iterator();
		int idx = 0;
		while(iter.hasNext()) {
		   alpha[idx] = iter.next();
		   idx++;
		}
		permutation(0, 0);
		System.out.println(max);
	}
	
	private static void permutation(int cnt, int flag) {
		if(cnt == R) {
			//System.out.println(map);
			int sum = 0;
			for(int i = 0; i < N; i++) {
				char[] values = numbers[i].toCharArray();
				int length = values.length;
				for(int j = 0; j < length; j++) {
					sum += (map.get(values[j]) * Math.pow(10, length - j - 1));
				}
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 10 - R; i <= 9; i++) {
			if((flag & 1 << i) != 0)
				continue;
			map.put(alpha[cnt], i);
			permutation(cnt+1, (flag | 1 << i));
			if(Lengthflag == 1)
				break;
		}
	}
}
