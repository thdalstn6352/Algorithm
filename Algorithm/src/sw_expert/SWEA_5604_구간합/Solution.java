package sw_expert.SWEA_5604_구간합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] nums = br.readLine().split(" ");
			int startNum = Integer.parseInt(nums[0]);
			int endNum = Integer.parseInt(nums[1]);
			int sum = 0;
			
			if(endNum >= 10) {
				int zeroTonine = 0;
				
				for(int i = 0; i < 10; i++) {
					zeroTonine += i;
				}
				
				int startRemain = startNum % 10;
				int endRemain = endNum % 10;
				
				
			}
			else {
				for(int i = startNum; i <= endNum; i++) {
					sum += i;
				}
			}
				
		}
	
	}
}
