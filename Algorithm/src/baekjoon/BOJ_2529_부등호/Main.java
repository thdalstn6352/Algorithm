package baekjoon.BOJ_2529_부등호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] numbers;
	static int[] input;
	static boolean[] visited;
	static String[] signs;
	static int flag;
	static int[] temp;
	static String min, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		visited = new boolean[10];
		input = new int[10];
		for(int i = 0; i < 10; i++) {
			input[i] = i;
		}
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N+1];
		temp = new int[N+1];
		
		signs = br.readLine().split(" ");
		
		for(int i = 0; i < 10; i++) {
			visited[i] = true;
			numbers[0] = i;
			permutation(1);
			visited[i] = false;
		}
		
		max = ArrayToString(temp);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void permutation(int cnt) {
		if(cnt == N + 1) {
			if(flag == 0) {
				min = ArrayToString(numbers);
				flag = 1;
			}
			for(int i = 0; i < N+1; i++) {
				temp[i] = numbers[i];
			}
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(visited[i])
				continue;
			
			if(signs[cnt - 1].equals(">")) {
				if(numbers[cnt - 1] > i) {
					numbers[cnt] = i;
					visited[i] = true;
					permutation(cnt + 1);
					visited[i] = false;
				}
				else {
					continue;
				}
			}
			else { // "<"
				if(numbers[cnt - 1] < i) {
					numbers[cnt] = i;
					visited[i] = true;
					permutation(cnt + 1);
					visited[i] = false;
				}
				else {
					continue;
				}
			}
		}
	}
	private static String ArrayToString(int[] values) {
		StringBuilder sb = new StringBuilder();
		for(int val : values)
			sb.append(val);
		return sb.toString();
	}
}
