package sw_expert.SWEA_7465;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] lines = br.readLine().split(" ");
			N = Integer.parseInt(lines[0]);
			M = Integer.parseInt(lines[1]);
			parents = new int[N + 1];
			
			makeSet();
			
			for(int i = 0; i < M; i++) {
				String[] relation = br.readLine().split(" ");
				int from = Integer.parseInt(relation[0]);
				int to = Integer.parseInt(relation[1]);
				
				unionSet(from, to);
			}
			
			for(int j = 0; j < N + 1; j++) {
				int temp = findSet(j);
			}
			
			for(int i : parents) {
				set.add(i);
			}
			
			sb.append("#").append(tc).append(" ").append(set.size() - 1).append("\n");
			set.clear();
		}
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
	
	private static void makeSet() {
		for(int i = 1; i <= N; i++) {
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
		parents[bRoot] = aRoot;
		return true;
	}
}
