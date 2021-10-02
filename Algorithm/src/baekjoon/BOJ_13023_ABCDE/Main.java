package baekjoon.BOJ_13023_ABCDE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N, M;
	static int[] parents;
	static List<Integer>[] list;
	static boolean answer;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		list = new ArrayList[N];
		visited = new boolean[N];
		
		for(int idx = 0; idx < N; idx++) {
			list[idx] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			String[] relations = br.readLine().split(" ");
			int friend1 = Integer.parseInt(relations[0]);
			int friend2 = Integer.parseInt(relations[1]);
			
			list[friend1].add(friend2);
			list[friend2].add(friend1);
		}
		
		for(int i = 0; i < N; i++) {
			if(!answer)
				dfs(i, 1);
		}
		if(answer)
			System.out.println(1);
		else
			System.out.println(0);
	}
	
	private static void dfs(int start, int depth) {
		if(depth == 5) {
			answer = true;
			return;
		}
		visited[start] = true;
		for(int friend : list[start]) {
			int nextFriend = friend;
			if(!visited[nextFriend])
				dfs(nextFriend, depth+1);
		}
		visited[start] = false;
	}
}
