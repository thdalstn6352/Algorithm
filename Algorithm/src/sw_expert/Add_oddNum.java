package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

public class Add_oddNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] datas = new int[10];
		int sum = 0;
		int testcase_num = sc.nextInt();
		int[] result = new int[testcase_num];
		
		
		for(int i = 0; i < testcase_num; i++) {
			sum = 0;
			for(int j = 0; j < 10; j++) {
				int data = sc.nextInt();
				if(data % 2 == 1) {
					sum += data; 
				}else {
					continue;
				}
			}
			result[i] = sum;
		}
		for(int cnt = 0; cnt < testcase_num; cnt++)
			System.out.printf("#%d %d%n",cnt+1, result[cnt]);
		
		sc.close();
	}
}
