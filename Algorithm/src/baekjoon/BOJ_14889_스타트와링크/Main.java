package baekjoon.BOJ_14889_스타트와링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N, R;
	static boolean[] visited;
	static int[][] map;
	static List<Integer> startTeam;
	static List<Integer> linkTeam;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		R = N / 2;
		startTeam = new ArrayList<>();
		linkTeam = new ArrayList<>();
		visited = new boolean[N];
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(lines[c]);
			}
		}
		combination(0, 0);
		System.out.println(min);
	}
	
	private static void combination(int start, int cnt) {
		if(cnt == R) {
			teamSelect();
			min = Math.min(min, calcAbility());
		}
		
		for(int i = start; i < N; i++) {
			visited[i] = true;
			combination(i+1, cnt+1);
			visited[i] = false;
		}
	}
	
	private static void teamSelect() {
		for(int i = 0; i < N; i++) {
			if(visited[i] == true) {
				startTeam.add(i);
			}
			else
				linkTeam.add(i);
		}
	}
	
	private static int calcAbility() {
		int startTeamAbility = 0;
		int linkTeamAbility = 0;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < R; j++) {
				startTeamAbility += map[startTeam.get(i)][startTeam.get(j)];
				linkTeamAbility += map[linkTeam.get(i)][linkTeam.get(j)];
			}
		}
		startTeam.clear();
		linkTeam.clear();
		return Math.abs(startTeamAbility - linkTeamAbility);
	}
}
