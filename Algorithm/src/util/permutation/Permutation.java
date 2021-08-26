package util.permutation;

import java.util.Arrays;

public class Permutation {

	static int N = 6, R = 4; 
	static int[] numbers;
	static int[] input;
	static boolean[] isSelected;
	static int count;
	
	public static void main(String[] args) {
		input = new int[]{1, 2, 3, 4, 5, 6};
		numbers = new int[R];
		isSelected = new boolean[N];
	
		permutation(0);
		System.out.println(count);
	}
	
	private static void permutation(int cnt) {
		if(cnt == R) {
			count++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수들이 들어있는 배열모든 원소에 대해 시도
		for (int i = 0; i < N; i++) { // i : 인덱스
			if(isSelected[i]) {
				continue; // 인덱스에 해당하는 수가 사용중인 수면 다음 수로.
			}
			numbers[cnt] = input[i];
			//System.out.printf("numbers[%d] = input[%d]%n", cnt, i);
			isSelected[i] = true;
			
			// 다음 자리순열 뽑으로 gogo
			permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}
}