package ThisIsCodingTest.dfsNbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Juice {
	static int N, M;
	static int[][] map;
	static boolean[][] isSelected;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] numbers = br.readLine().split(" ");
		N = Integer.parseInt(numbers[0]);
		M = Integer.parseInt(numbers[1]);
		map = new int[N][M];
		//isSelected = new int[N][M];
		int result = 0;
		
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(dfs(r, c) == true)
					result++;
			}
		}
		System.out.println(result);
	
	}
	
	public static boolean dfs(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) {
			return false;
		}
		
		if(map[x][y] == 0) {
			map[x][y] = 1;
			dfs(x - 1, y);
			dfs(x + 1, y);
			dfs(x, y - 1);
			dfs(x, y + 1);
			return true;
		}
		return false;
		
	}

}
