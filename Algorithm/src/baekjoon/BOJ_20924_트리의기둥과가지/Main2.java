package baekjoon.BOJ_20924_트리의기둥과가지;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
	static int N, R;
	static List<Node>[] tree;
	static int pillarLength;
	static int branchLength;
	static int gigaNode;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] rootInfo = br.readLine().split(" ");
		N = Integer.parseInt(rootInfo[0]);
		R = Integer.parseInt(rootInfo[1]);
		
		if(N == 1) {
			sb.append(0).append(" ").append(0);
			bw.write(sb.toString());
			bw.flush();
			return;
		}
		visited = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			String[] nodeInfo = br.readLine().split(" ");
			int from = Integer.parseInt(nodeInfo[0]);
			int to = Integer.parseInt(nodeInfo[1]);
			int weight = Integer.parseInt(nodeInfo[2]);
		
			tree[from].add(new Node(to, weight));
			tree[to].add(new Node(from, weight));
		}

		calcPillarLength(R, 0);
		//visited = new boolean[N + 1];
		calcBranchLength(gigaNode, 0);
		
		sb.append(pillarLength).append(" ").append(branchLength);
		bw.write(sb.toString());
		bw.flush();
		
	}

	private static void calcPillarLength(int startNode, int weight) {
		// 일반적인 기가 노드 , 리프노드가 기가노드 
		if(tree[startNode].size() > 2 || (tree[startNode].size() == 2 && startNode == R) || (tree[startNode].size() == 1 && startNode != R)) {
			pillarLength = weight;
			gigaNode = startNode;
			return;
		}
		for(int i = 0; i < tree[startNode].size(); i++) {
			Node nextNode = tree[startNode].get(i);
			if(!visited[nextNode.dest]) {
				visited[startNode] = true;
				calcPillarLength(nextNode.dest, weight + nextNode.weight);
			}
		}
	}
	
	private static void calcBranchLength(int startNode, int weight) {
		if(tree[startNode].size() == 1) {
			//System.out.println("가지길이는 : " + weight);
			branchLength = Math.max(branchLength, weight);
			return;
		}
		
		for(int i = 0; i < tree[startNode].size(); i++) {
			Node nextNode = tree[startNode].get(i);
			if(!visited[nextNode.dest]) {
				visited[startNode] = true;
				calcBranchLength(tree[startNode].get(i).dest, weight + tree[startNode].get(i).weight);
			}
		}
	}
}

//class Node {
//	int dest;
//	int weight;
//	public Node(int dest, int weight) {
//		super();
//		this.dest = dest;
//		this.weight = weight;
//	}
//}
