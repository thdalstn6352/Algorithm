package baekjoon.BOJ_2491_수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
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
		
		int count1 = 1;
		int count2 = 1;
		int maxCnt = 0;
		
		for(int i = 0; i < num - 1; i++) {
			if(numArr[i] > numArr[i+1]) {
				maxCnt = Math.max(maxCnt, count1);
				count1 = 0;
			}
			if(numArr[num - 1 - i] > numArr[num - 2 - i]) {
				maxCnt = Math.max(maxCnt, count2);
				count2 = 0;
			}
			count1++;
			count2++;
		}
		maxCnt = Math.max(maxCnt, count1);
		maxCnt = Math.max(maxCnt, count2);
		
		sb.append(maxCnt);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}
