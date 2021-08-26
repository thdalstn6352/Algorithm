package sw_expert.SWEA_1251_하나로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Solution {
	static List<Edge> edgeList;
	static List<Node> nodeList;
	static Node[] parents;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			edgeList = new ArrayList<>();
			nodeList = new ArrayList<>();
			parents = new Node[N];
			
			String[] xAxis = br.readLine().split(" ");
			String[] yAxis = br.readLine().split(" ");
			
			double E = Double.parseDouble(br.readLine());
			
			for(int i = 0; i < N; i++) {
				int x = Integer.parseInt(xAxis[i]);
				int y = Integer.parseInt(yAxis[i]);
				
				nodeList.add(new Node(x, y, i));
				parents[i] = new Node(x, y, i); //Make함수 역할
			}
			
			
			for(int from = 0; from < N; from++) {
				for(int to = from + 1; to < N; to++) {
					double dist = Math.sqrt(Math.pow(nodeList.get(from).x - nodeList.get(to).x, 2) + Math.pow(nodeList.get(from).y - nodeList.get(to).y, 2));
					
					double weight = E * dist * dist;
					edgeList.add(new Edge(nodeList.get(from), nodeList.get(to), weight)); 
					
				}
			}
			
			Collections.sort(edgeList);
			
			int cnt = 0;
			double result = 0;
			
			for(Edge edge : edgeList) {
				if(unionSet(edge.from, edge.to)) {
					result += edge.weight;
					if(++cnt == N - 1)
						break;
				}
			}
			long res = Math.round(result);
			sb.append("#").append(tc).append(" ");
			sb.append(res);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
	
	}
	static class Node {
		int x;
		int y;
		int flag;
		
		public Node(int x, int y, int flag) {
			super();
			this.x = x;
			this.y = y;
			this.flag = flag;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + flag;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (flag != other.flag)
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", flag=" + flag + "]";
		}
		
	}
	
	static class Edge implements Comparable<Edge>{
		Node from;
		Node to;
		double weight;

		public Edge(Node from, Node to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}
	
	private static Node findSet(Node a) {
	//	System.out.println(parents[a.flag] + "==?" + a);
		if(parents[a.flag].equals(a)) {
	//		System.out.println("true");
			return a;
		}
		else
	//		System.out.println("false");
			return parents[a.flag] = findSet(parents[a.flag]);
	}
	
	private static boolean unionSet(Node a, Node b) {
		Node aRoot = findSet(a);
		Node bRoot = findSet(b);
//		System.out.printf("aRoot = ");
//		System.out.println(aRoot);
//		System.out.printf("bRoot = ");
//		System.out.println(bRoot);
		
//		System.out.println(parents[bRoot.flag]);
		if(aRoot.equals(bRoot)) {
			return false;
		}
		parents[bRoot.flag] = aRoot;
//		System.out.println(parents[bRoot.flag]);
//		System.out.println("=================");
		return true;
	}
	
}
