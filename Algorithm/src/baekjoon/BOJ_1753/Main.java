package baekjoon.BOJ_1753;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int V, E;
	static List<Node>[] nodes;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] lines = br.readLine().split(" ");
		
		V = Integer.parseInt(lines[0]);
		E = Integer.parseInt(lines[1]);
	
		int start = Integer.parseInt(br.readLine());
		nodes = new ArrayList[V+1];
		dist = new int[V+1];
		
		
		for(int i = 1; i < V+1; i++) {
			nodes[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < E; i++) {
			String[] nums = br.readLine().split(" ");
			
			int from = Integer.parseInt(nums[0]);
			int to = Integer.parseInt(nums[1]);
			int weight = Integer.parseInt(nums[2]);
			
			nodes[from].add(new Node(to, weight));
		}
		
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);

		dijkstra(start);
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == INF)
				sb.append("INF");
			else
				sb.append(dist[i]);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	
	}
	private static void dijkstra(int start) {
		Queue<Node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];
		queue.offer(new Node(start, 0));
		dist[start] = 0;

		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			int current = curNode.end;
			
			if(visited[current] == true)
				continue;
			visited[current] = true;
			
			
			for(Node node : nodes[current]) {
				if(dist[node.end] > dist[current] + node.weight) {
					dist[node.end] = dist[current] + node.weight;
					queue.offer(new Node(node.end, dist[node.end]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int end;
	int weight;
	
	public Node(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
	
}