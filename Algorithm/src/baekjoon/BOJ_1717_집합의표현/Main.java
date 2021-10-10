package baekjoon.BOJ_1717_집합의표현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] parents;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		
		parents = new int[N+1];
		make();
		
		for(int i = 0; i < M; i++) {
			String[] lines = br.readLine().split(" ");
			
			int func = Integer.parseInt(lines[0]);
			int a = Integer.parseInt(lines[1]);
			int b = Integer.parseInt(lines[2]);
			
			if(func == 0) {
				union(a, b);
			}
			else if(func == 1) {
				if(find(a) == find(b))
					sb.append("YES").append("\n");
				else
					sb.append("NO").append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	private static void make() {
		for(int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)
			return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
