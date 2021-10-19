package util.subset;

import java.util.Scanner;
public class Subset {

	static int N,totalCnt;
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = 4;
		input = new int[] {0, 1, 2, 3};
		isSelected = new boolean[N];
		totalCnt = 0;
				
		generateSubset(0);
		System.out.println("경우의 수 : "+totalCnt);
	}

	private static void generateSubset(int cnt){

		if(cnt == N) {
			// 부분집합 완성
			totalCnt++;
			for (int i = 0; i < N; i++) {
				System.out.print((isSelected[i]?input[i]:"X")+" ");
			}
			System.out.println();
			return;
		}
		
		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}
	
	
	
	
	
	
	
}
