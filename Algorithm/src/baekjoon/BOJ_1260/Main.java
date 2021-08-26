package baekjoon.BOJ_1260;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N, M, V;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] lines = br.readLine().split(" ");
		N = Integer.parseInt(lines[0]);
		M = Integer.parseInt(lines[1]);
		V = Integer.parseInt(lines[2]);
		
		List<Integer>[] nodes = new ArrayList[N+1];
		boolean[] visited = new boolean[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
		
		for(int idx = 0; idx < M; idx++) {
			String[] nums = br.readLine().split(" ");
			int from = Integer.parseInt(nums[0]);
			int to = Integer.parseInt(nums[1]);
			
			nodes[from].add(to);
			nodes[to].add(from);
		}
		
		for(int i = 1; i < N + 1; i++) {
			Collections.sort(nodes[i]);
		}
		
		dfs(nodes, V, visited);
		sb.append("\n");
		bfs(nodes);
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	private static void bfs(List<Integer>[] nodes) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		
		queue.offer(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int currNode = queue.poll();
			int size = nodes[currNode].size();
			
			sb.append(currNode).append(" ");
			
			for(int i = 0; i < size; i++) {
				if(!visited[nodes[currNode].get(i)]) {
					queue.offer(nodes[currNode].get(i));
					visited[nodes[currNode].get(i)] = true;
				}
			}
		}
	}
	
	
	private static void dfs(List<Integer>[] nodes, int current, boolean[] visited) {
		visited[current] = true;
		sb.append(current).append(" ");
		int size = nodes[current].size();
		
		for(int i = 0; i < size; i++) {
			if(!visited[nodes[current].get(i)])
				dfs(nodes, nodes[current].get(i), visited);
		}
	}
}

