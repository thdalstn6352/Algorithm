package baekjoon.BOJ_2491_수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int num = Integer.parseInt(br.readLine());
		int[] numArr = new int[num];
		
		String[] nums = br.readLine().split(" ");
		
		for(int i = 0; i < num; i++) {
			numArr[i] = Integer.parseInt(nums[i]);
		}
		
		int flag = 0; // 0 :커질때  1:작아질때 2: 같을때
		int count = 0;
		int maxCnt = 0;
		
		for(int i = 0; i < num - 1; i++) {
			if(numArr[i] < numArr[i+1])
				flag = 0;
			else if(numArr[i] > numArr[i+1])
				flag = 1;
			else
				flag = 2;
			count = 1;
			//System.out.println("====================");
			//System.out.printf("%d와 %d 비교 => %d%n",numArr[i], numArr[i+1], flag);
			
			for(int j = i + 1; j < num - 1; j++) {
				if(flag == 2) {
					if(numArr[j] > numArr[j+1]) {
						flag = 1;
					}
					else if(numArr[j] < numArr[j+1]) {
						flag = 0;
					}
					else {
						flag = 2;
					}
				}
				else if(flag == 0) {
					if(numArr[j] > numArr[j+1]) {
						count++;
						Math.max(maxCnt, count);
						break;
					}
				}
				else if(flag == 1) {
					if(numArr[j] < numArr[j+1]) {
						count++;
						Math.max(maxCnt, count);
						break;
					}
				}
				count++;
				
			}
			maxCnt = Math.max(maxCnt, count);
		}
		System.out.println(maxCnt);
		
	
	}
}
