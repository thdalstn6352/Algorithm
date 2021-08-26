package sw_expert.SWEA_3289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] msg = br.readLine().split(" ");
			
			N = Integer.parseInt(msg[0]);
			M = Integer.parseInt(msg[1]);
			
			parents = new int[N + 1];
			makeSet();
			
			sb.append("#").append(tc).append(" ");
			
			for(int i = 0; i < M; i++) {
				String[] nums = br.readLine().split(" ");
				int Oper = Integer.parseInt(nums[0]);
				int a = Integer.parseInt(nums[1]);
				int b = Integer.parseInt(nums[2]);
				
				if(Oper == 0) {
					unionSet(a, b);
				}
				else {
					if(findSet(a) == findSet(b))
						sb.append(1);
					else
						sb.append(0);
				}
			}
			sb.append("\n");
			System.out.println(Arrays.toString(parents));
		}
		bw.write(sb.toString());
		bw.flush();
		
		
	}
	
	private static void makeSet() {
		for(int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}
	
	private static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot)
			return false;
		else 
			parents[bRoot] = aRoot;
		return true;
	}
	
}
