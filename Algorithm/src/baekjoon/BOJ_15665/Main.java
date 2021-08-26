package baekjoon.BOJ_15665;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
	static int N, R;
	static int[] numbers;
	static int[] inputs;
	static int flag;
	static Set<String> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] msg = br.readLine().split(" ");
		N = Integer.parseInt(msg[0]);
		R = Integer.parseInt(msg[1]);
		inputs = new int[N];
		numbers = new int[R];
		
		set = new LinkedHashSet<String>();
		
		String[] nums = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(nums[i]);
		}
		Arrays.sort(inputs);
		
		permutation(0);
		
		set.forEach(System.out::println);

		bw = null;
		br = null;
	}
	
	public static void permutation(int cnt) {
		if(cnt == R) {
			StringBuilder sb = new StringBuilder();
			for(int num : numbers)
				sb.append(num).append(" ");
			set.add(sb.toString());
			return;
		}
		
		for(int i = 0; i < N; i++) {
			numbers[cnt] = inputs[i];
			permutation(cnt+1);
		}
	}
}