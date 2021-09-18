package util.MSTPrim;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MSTPrimWithHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] VE = br.readLine().split(" ");
			int V = Integer.parseInt(VE[0]);
			int E = Integer.parseInt(VE[1]);
		
			boolean[] visited = new boolean[V];
			List<Edge>[] edgeList = new ArrayList[V];
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			
			for(int i = 0; i < V; i++) {
				edgeList[i] = new ArrayList<Edge>();
			}
					
			for(int i = 0; i < E; i++) {
				String[] edges = br.readLine().split(" ");
				int start = Integer.parseInt(edges[0]) - 1;
				int end = Integer.parseInt(edges[1]) - 1;
				int weight = Integer.parseInt(edges[2]);
				
				edgeList[start].add(new Edge(end, weight));
				edgeList[end].add(new Edge(start, weight));
				
			}
			
			long result = 0;
			
			for(Edge e : edgeList[0]) {
				pq.add(e);
			}
			visited[0] = true;
			
			
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				
				if(visited[edge.to])
					continue;
				visited[edge.to] = true;
				result += edge.weight;
	
				for(Edge e : edgeList[edge.to]) {
					if(visited[e.to])
						continue;
					pq.add(e);
				}
				
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}

}

class Edge implements Comparable<Edge> {
	int to;
	int weight;
	
	public Edge(int to, int weight) {
		super();
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
	
}


/*
1
3 3
1 2 1
2 3 2
1 3 3
*/