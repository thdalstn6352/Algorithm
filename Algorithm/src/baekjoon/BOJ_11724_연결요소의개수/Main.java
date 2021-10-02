package baekjoon.BOJ_11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N, M;
	static List<Integer>[] list;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int idx = 0; idx <= N; idx++) {
			list[idx] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			String[] infos = br.readLine().split(" ");
			int num1 = Integer.parseInt(infos[0]);
			int num2 = Integer.parseInt(infos[1]);
			
			list[num1].add(num2);
			list[num2].add(num1);
		}
		for(int i = 1 ; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	private static void dfs(int idx) {
		visited[idx] = true;
		
		for(int val : list[idx]) {
			if(!visited[val])
				dfs(val);
		}
	}
}
