package util.permutation;

import java.util.Arrays;

public class NextPermutation {
	public static void main(String[] args) {
		
		int[] input = new int[] {1, 2, 4};
		
		Arrays.sort(input); //가장 작은 순열 만들기(1,4,7)
		
		do {
			System.out.println(Arrays.toString(input));
		}while(np(input));
	}
	
	//다음 큰 순열이 있으면 true, 없으면 false
	private static boolean np(int[] numbers) {
		int N = numbers.length;
		
		// step1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환위치(i-1) 찾기
		int i = N - 1;
		while(i > 0 && numbers[i-1] >= numbers[i]) {
			--i;
		}
		if(i == 0) {
			return false;
		}
		
		// step2. i-1 위치값과 교환할 큰 값 찾기
		int j = N - 1;
		
		while(numbers[i-1] >= numbers[j]) 
			--j;
		
		// step3. i-1위치값과 j위치값 교환
		swap(numbers, i-1, j);
		
		// step4. 꼭대기부터 맨뒤 까지 내림차순형태의 순열을 오름차순으로 처리
		int k = N - 1;
		while(i < k) {
			swap(numbers, i++, k--);
			
		}
		
		return true;
		
		
	}
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
