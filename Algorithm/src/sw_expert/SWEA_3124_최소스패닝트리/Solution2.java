package sw_expert.SWEA_3124_최소스패닝트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] VE = br.readLine().split(" ");
			int V = Integer.parseInt(VE[0]);
			int E = Integer.parseInt(VE[1]);
			
			boolean[] visited = new boolean[V];
			int[][] adjMatrix = new int[V][V];
			int[] minEdge = new int[V];
			Arrays.fill(minEdge, Integer.MAX_VALUE);
			
			for(int i = 0; i < E; i++) {
				String[] msg = br.readLine().split(" ");
				int start = Integer.parseInt(msg[0]) - 1;
				int end = Integer.parseInt(msg[1]) - 1;
				int weight = Integer.parseInt(msg[2]);
				
				adjMatrix[start][end] = weight;
				adjMatrix[end][start] = weight;
			}
			
			long result = 0;
			minEdge[0] = 0;
			
			for(int i = 0; i < V; i++) {
				int min = Integer.MAX_VALUE;
				int minIdx = -1;
				
				for(int j = 0; j < V; j++) {
					if(!visited[j] && min > minEdge[j]) {
						min = minEdge[j];
						minIdx = j;
					}
				}
				
				visited[minIdx] = true;
				result += min; 
						
				for(int j = 0; j < V; j++) {
					if(!visited[j] && adjMatrix[minIdx][j] != 0 && adjMatrix[minIdx][j] < minEdge[j]) {
						minEdge[j] = adjMatrix[minIdx][j];
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}

}