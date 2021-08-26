package ThisIsCodingTest.dfsNbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dudugi {
	static int N;
	static int[][] map;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int result = 0;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		List<Integer> list = new ArrayList<>();
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(lines[c]);
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(dfs(r, c) == true) {
					result++;
					list.add(sum);
					sum = 0;
				}
			}
		}
		sb.append(result).append("\n");
		Collections.reverse(list);
		for(int i : list) {
			sb.append(i).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	
	}
	
	public static boolean dfs(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) 
			return false;
		if(map[x][y] == 1) {
			sum += 1;
			map[x][y] = 0;
			dfs(x - 1, y);
			dfs(x + 1, y);
			dfs(x, y - 1);
			dfs(x, y + 1);
			return true;
		}
		return false;
	}
}
