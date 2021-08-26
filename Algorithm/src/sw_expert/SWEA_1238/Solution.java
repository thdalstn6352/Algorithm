package sw_expert.SWEA_1238;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		int[][] map;
		boolean[] visited;
		for(int tc = 1; tc <= T; tc++) {
			map = new int[100][100];
			visited = new boolean[100];
			Queue<Node> queue = new LinkedList<>();
			Node maxNode = null;
			
 			String[] lines = br.readLine().split(" ");
			int NodeNum = Integer.parseInt(lines[0]);
			int StartNode = Integer.parseInt(lines[1]);
			String[] numbers = br.readLine().split(" ");
			
			for(int i = 0; i < NodeNum; i+=2) {
				int from = Integer.parseInt(numbers[i]);
				int to = Integer.parseInt(numbers[i+1]);
				map[from - 1][to - 1] = 1;
			}
			
			queue.offer(new Node(StartNode - 1, 0));
			visited[StartNode - 1] = true;
			
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				if(maxNode == null || maxNode.flag < node.flag) {
					maxNode = node;
				}
				else if(maxNode.flag == node.flag) {
					if(maxNode.value < node.value) {
						maxNode = node;
					}
				}

				int value = node.value;
				int flag = node.flag;
				
				for(int i = 0; i < 100; i++) {
					if(map[value][i] != 0 && visited[i] == false) {
						queue.offer(new Node(i, flag+1));
						visited[i] = true;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(maxNode.value + 1).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}

class Node {
	int value;
	int flag;
	
	public Node(int value, int flag) {
		super();
		this.value = value;
		this.flag = flag;
	}
}
