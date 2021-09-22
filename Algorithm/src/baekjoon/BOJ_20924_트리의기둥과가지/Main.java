package baekjoon.BOJ_20924_트리의기둥과가지;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N, R;
	static List<Node>[] adjList;
	static List<Node>[] tree;
	static int pillarLength;
	static int branchLength;
	static int gigaNode;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] rootInfo = br.readLine().split(" ");
		N = Integer.parseInt(rootInfo[0]);
		R = Integer.parseInt(rootInfo[1]);
		
		
		adjList = new ArrayList[N + 1];
		tree = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			String[] nodeInfo = br.readLine().split(" ");
			int from = Integer.parseInt(nodeInfo[0]);
			int to = Integer.parseInt(nodeInfo[1]);
			int weight = Integer.parseInt(nodeInfo[2]);
		
			adjList[from].add(new Node(to, weight));
			adjList[to].add(new Node(from, weight));
		}
		makeTree(R, R);
		//System.out.println(tree[4]);
		calcPillarLength(R, 0);
		calcBranchLength(gigaNode, 0);
		
		sb.append(pillarLength).append(" ").append(branchLength);
		bw.write(sb.toString());
		bw.flush();
		
	}
	private static void makeTree(int childNode, int parentNode) {
		for(int i = 0; i < adjList[childNode].size(); i++) {
			int nextNode = adjList[childNode].get(i).dest;
			int nextWeight = adjList[childNode].get(i).weight;
			if(nextNode != parentNode) {
				tree[childNode].add(new Node(nextNode, nextWeight));
				makeTree(nextNode, childNode);
			}
		}
	}
	private static void calcPillarLength(int startNode, int weight) {
		if(tree[startNode].size() != 1) {
			pillarLength = weight;
			gigaNode = startNode;
			return;
		}
		Node nextNode = tree[startNode].get(0);
		calcPillarLength(nextNode.dest, weight + nextNode.weight);
	}
	
	private static void calcBranchLength(int startNode, int weight) {
		if(tree[startNode].isEmpty()) {
			//System.out.println("가지길이는 : " + weight);
			branchLength = Math.max(branchLength, weight);
			return;
		}
		
		for(int i = 0; i < tree[startNode].size(); i++) {
			calcBranchLength(tree[startNode].get(i).dest, weight + tree[startNode].get(i).weight);
		}
	}
}

class Node {
	int dest;
	int weight;
	public Node(int dest, int weight) {
		super();
		this.dest = dest;
		this.weight = weight;
	}
}
