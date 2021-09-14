package util.combination;

import java.util.Arrays;

public class Combination {
	static int N = 6,R = 3; 
	static int[] input;
	static int[] numbers;
	static int count;
	
	public static void main(String[] args) {

		input = new int[N];
		for(int i = 0; i < N; i++) {
			input[i] = i + 1;
		}
		numbers = new int[R];
		combination(0,0);
		System.out.println(count);
	}
		
	private static void combination(int cnt,int start) {
		if(cnt == R) {
			count++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i < N; i++) { // i : 인덱스
			numbers[cnt] = input[i];
			combination(cnt+1,i+1);
		}
	
	}
}
