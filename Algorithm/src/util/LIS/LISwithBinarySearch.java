package util.LIS;

import java.util.Arrays;
import java.util.Scanner;

public class LISwithBinarySearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr= new int[N];
		int[] LIS = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		int size = 0;
		for(int i = 0; i < N; i++) {
			int pos = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i])) - 1;
			LIS[pos] = arr[i];
			
			if(pos == size) {
				size++;
			}
			
			if(max < LIS[i]) max = LIS[i];
		}
		
		System.out.println(size);
	}
}
