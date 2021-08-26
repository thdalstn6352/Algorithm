package sw_expert.SWEA_11005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	static int N, R;
	static int result;
	static boolean[] isSelected;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			R = N / 2;
			isSelected = new boolean[N];
			map = new int[N][N];
			result = Integer.MAX_VALUE;
			
			for(int r = 0; r < N; r++) {
				String[] lines = br.readLine().split(" ");
				
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(lines[c]);
				}
			}
			
			combination(0, 0);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == R) {
			calcSynergy();
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(isSelected[i])
				continue;
			isSelected[i] = true;
			combination(cnt+1, i+1);
			isSelected[i] = false;
			
		}
	}
	
	public static void calcSynergy() {
		List<Integer> F_list = new ArrayList<>();
		List<Integer> S_list = new ArrayList<>();
		
		for(int i = 0; i < N; i ++) {
			if(isSelected[i])
				F_list.add(i);
			else
				S_list.add(i);
		}
		
		result = Math.min(result, Math.abs(synergyCheck(F_list) - synergyCheck(S_list)));
		
	}
	
	public static int synergyCheck(List<Integer> list) {
		int sum = 0;
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = i; j < list.size(); j++) {
				sum += map[list.get(i)][list.get(j)] + map[list.get(j)][list.get(i)];
			}
		}
		return sum;
	}
	
}
