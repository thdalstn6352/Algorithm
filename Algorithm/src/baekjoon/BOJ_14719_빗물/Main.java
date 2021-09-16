package baekjoon.BOJ_14719_빗물;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] size = br.readLine().split(" ");
		
		int H = Integer.parseInt(size[0]);
		int W = Integer.parseInt(size[1]);
		
		String[] b = br.readLine().split(" ");
		int[] buildings = new int[W];
		int upperBound = 0;
		
		for(int i = 0; i < b.length; i++) {
			buildings[i] = Integer.parseInt(b[i]);
		}
		
		for(int idx = 1; idx < W - 1; idx++) {
			int LeftMax = 0;
			int RightMax = 0;
			
			for(int left = 0; left < idx; left++) {
				LeftMax = Math.max(LeftMax, buildings[left]);
			}
			
			for(int right = W - 1; right > idx; right--) {
				RightMax = Math.max(RightMax, buildings[right]);
			}
			
			upperBound += Math.max(0,  Math.min(LeftMax, RightMax) - buildings[idx]);
		}
		
		System.out.println(upperBound);
		
		
	}
}
