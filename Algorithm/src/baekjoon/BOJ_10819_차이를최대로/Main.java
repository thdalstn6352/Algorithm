package baekjoon.BOJ_10819_차이를최대로;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] input = new int[N];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);
		do {
			int sum = 0;
			for(int i = 0; i < N - 1; i++) {
				sum += Math.abs((input[i] - input[i+1]));
			}
			max = Math.max(max, sum);
		}while(np(input));
		
		System.out.println(max);
	}
	
	private static boolean np(int[] input) {
		int i = N - 1;
		while(i > 0 && input[i - 1] >= input[i])
			i--;
		
		if(i == 0)
			return false;
		
		int j = N - 1;
		
		while(input[i - 1] >= input[j])
			j--;
		
		swap(input, i - 1, j);
		
		int k = N - 1;
		
		while(i < k)
			swap(input, i++, k--);
		return true;
	}
	
	private static void swap(int[] input, int i , int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
