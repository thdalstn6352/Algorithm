package sw_expert.SWEA_3234;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	static int N, sum, count;
	static boolean[] isSelected;
	static int[] weights;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T; tc++) {
			sum = 0;
			
			N = Integer.parseInt(br.readLine());
			isSelected = new boolean[N];
			String[] lines = br.readLine().split(" ");
			weights = new int[lines.length];
			for(int i = 0; i < lines.length; i++) {
				weights[i] = Integer.parseInt(lines[i]);
				sum += weights[i];
			}
			Arrays.sort(weights);
			
			do {
				calc(0, 0, 0);
			}while(np(weights));
			
			sb.append("#").append(tc).append(" ").append(count).append("\n");
			count = 0;
		}
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
	 private static void calc(int idx, int sumL, int sumR) {
	        // 모든 추를 저울에 다 올렸다면
	        if (idx == N) {
	            count++;
	            return;
	        }
	        // 왼쪽 먼저 올리기
	        calc(idx + 1, sumL + weights[idx], sumR);
	        
	        // 오른쪽 총합에 현재 값을 더해도 왼쪽의 총합보다 작으면 
	        // 오른쪽에 무게를 추가하는 재귀를 돌려준다
	        if (sumR + weights[idx] <= sumL) {
	            calc(idx + 1, sumL, sumR + weights[idx]);
	        }
	 }
	 
	private static boolean np(int[] numbers) {
		int N = numbers.length;
		
		int i = N - 1;
		while(i > 0 && numbers[i-1] >= numbers[i]) {
			--i;
		}
		if(i == 0) {
			return false;
		}
		
		int j = N - 1;
		
		while(numbers[i-1] >= numbers[j]) 
			--j;
		
		swap(numbers, i-1, j);
		
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
