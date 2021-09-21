package util.MSTKruskal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTKruskalTest {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			//return this.weight - o.weight;
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int[] parents;
	
	private static void make() {
		for(int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int a) {
		if(parents[a] == a)
			return a;
		else
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
	

	static int V, E;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
	
		edgeList = new Edge[E];
		parents = new int[V];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(start, end, weight);
		}
		
		Arrays.sort(edgeList);
		
		make();
		
		int cnt = 0;
		int result = 0;
		
		for(Edge edge : edgeList) {
			if(unionSet(edge.from, edge.to)) {
				result += edge.weight;


			}
		}
		
		System.out.println(result);
	}
}

/*
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10

7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51

output==>175
*/
