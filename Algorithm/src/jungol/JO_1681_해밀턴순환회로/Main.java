package jungol.JO_1681_해밀턴순환회로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int minLength = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(lines[c]);
			}
		}
		visited[0] = true;
		dfs(0, 0, 0);
		System.out.println(minLength);
		
	}
	
	private static void dfs(int start, int weight, int cnt) {
		if(weight > minLength)
			return;
		
		if(cnt == N -1) {
			if(map[start][0] == 0)
				return;
			weight += map[start][0];
			minLength = Math.min(minLength, weight);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && map[start][i] != 0) {
				visited[i] = true;
				dfs(i, weight + map[start][i], cnt+1);
				visited[i] = false;
			}
			
		}
	}
}
