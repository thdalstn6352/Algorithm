package util.combination;

import java.util.Arrays;

public class Combination {
	static int N = 9,R = 2; 
	static int[] input;
	static int[] numbers;
	
	public static void main(String[] args) {

		input = new int[]{1,2,3,4,5,6,7,8,9};
		numbers = new int[R];
		combination(0,0);
	}
		
	private static void combination(int cnt,int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i < N; i++) { // i : 인덱스
			numbers[cnt] = input[i];
			combination(cnt+1,i+1);
		}
	
	}
}
