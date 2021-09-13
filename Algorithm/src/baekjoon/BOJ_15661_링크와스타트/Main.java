package baekjoon.BOJ_15661_링크와스타트;

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
		sumbset(0);
		System.out.println(min);
	}
	
	private static void sumbset(int cnt) {
		if(cnt == N) {
			teamSelect();
			if(startTeam.size() == N || linkTeam.size() == N)
				return;
			
			min = Math.min(min, calcAbility());
			return;
		}
		
		visited[cnt] = true;
		sumbset(cnt+1);
		visited[cnt] = false;
		sumbset(cnt+1);
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
		
		for(int i = 0; i < startTeam.size(); i++) {
			for(int j = 0; j < startTeam.size(); j++) {
				startTeamAbility += map[startTeam.get(i)][startTeam.get(j)];
			}
		}

		for(int i = 0; i < linkTeam.size(); i++) {
			for(int j = 0; j < linkTeam.size(); j++) {
				linkTeamAbility += map[linkTeam.get(i)][linkTeam.get(j)];
			}
		}
		
		startTeam.clear();
		linkTeam.clear();
		return Math.abs(startTeamAbility - linkTeamAbility);
	}
}
