package baekjoon.BOJ_2458_키순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int INF = 999999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[][] adjMatrix = new int[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				//if(r != c)
					adjMatrix[r][c] = INF;
			}
		}
		for(int i = 0; i < M; i++) {
			String[] lines = br.readLine().split(" ");
			int a = Integer.parseInt(lines[0]) - 1;
			int b = Integer.parseInt(lines[1]) - 1;
			
			adjMatrix[a][b] = 1;
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				if(i == k)
					continue;
				for(int j = 0; j < N; j++) {
					if(j == k || i == j)
						continue;
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j])
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
				}
			}
		}
		int result = 0;
        for(int i = 0; i < N; i++) {
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(adjMatrix[i][j] != INF || adjMatrix[j][i] != INF) 
                	count++;
            }
            if(count == N - 1) 
            	result++;
        }
        System.out.println(result);
	}
}
