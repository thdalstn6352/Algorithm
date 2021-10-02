package baekjoon.BOJ_11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
	static int N, M;
	static Integer[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		int group = N;
		
		parents = new Integer[N+1];
		make();
		
		for(int i = 0; i < M; i++) {
			String[] infos = br.readLine().split(" ");
			int num1 = Integer.parseInt(infos[0]);
			int num2 = Integer.parseInt(infos[1]);
			
			if(!union(num1, num2))
				continue;
			group--;
			
		}
		System.out.println(group);
	}
	
	private static void make() {
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		else {
			if(bRoot > aRoot)
				parents[bRoot] = aRoot;
			else
				parents[aRoot] = bRoot;
			return true;
		}
	}
}
