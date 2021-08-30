package jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int testCase = Integer.parseInt(br.readLine());
		int[][] temp = new int[testCase][2];
		
		for(int tc = 0; tc < testCase; tc++) {
			String[] temps = br.readLine().split(" ");
			temp[tc][0] = Integer.parseInt(temps[0]);
			temp[tc][1] = Integer.parseInt(temps[1]);
		}
		
		Arrays.sort(temp, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int refriCnt = 1;
		int max_temp = temp[0][1];
		
		for(int i = 1; i < testCase; i++) {
			if(max_temp < temp[i][0]) {
				refriCnt++;
				max_temp = temp[i][1];
			}
		}
		sb.append(refriCnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		bw = null;
		br = null;
		System.out.println(refriCnt);
		
	}
}
