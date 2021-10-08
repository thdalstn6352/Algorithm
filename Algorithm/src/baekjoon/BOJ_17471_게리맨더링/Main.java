package baekjoon.BOJ_17471_게리맨더링;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N;
	static Area[] person;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		person = new Area[N+1];
		
		String[] p = br.readLine().split(" ");
		for(int i = 1; i <= N; i++) {
			person[i] = new Area(Integer.parseInt(p[i-1]), new ArrayList<Integer>());
		}

		for(int j = 1; j <= N; j++) {
			String[] infos = br.readLine().split(" ");
			for(int k = 0; k < Integer.parseInt(infos[0]); k++) {
				person[j].adjList.add(Integer.parseInt(infos[k+1]));
			}
		}
		
		for(int comb = 1; comb <= N/2; comb++) {
			int[] Aarr = new int[comb];
			combination(0, 1, comb, Aarr);
		}
		
		min = min == Integer.MAX_VALUE ? -1 : min;
		System.out.println(min);
	}
	
	private static void combination(int cnt, int start, int R, int[] Aarr) {
		if(cnt == R) {
			calcPopulation(Aarr);
			return;
		}
		
		for(int i = start; i <= N; i++) {
			Aarr[cnt] = i;
			combination(cnt+1, i+1, R, Aarr);
		}
		
	}
	
	private static void calcPopulation(int[] Aarr) {
		List<Integer> aList = new ArrayList<>();
		List<Integer> bList = new ArrayList<>();

		for(int val : Aarr) {
			aList.add(val);
		}
		
		for(int i = 1; i <= N; i++) {
			if(!aList.contains(i))
				bList.add(i);
		}
		
		if(!isConnected(aList) || !isConnected(bList))
			return;
		
		int aArea = 0;
		int bArea = 0;
		
		for(int aPerson : aList) {
			aArea += person[aPerson].person;
		}
		for(int bPerson : bList) {
			bArea += person[bPerson].person;
		}
		
		min = Math.min(min, Math.abs(aArea - bArea));
	}
	
	private static boolean isConnected(List<Integer> list) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		queue.add(list.get(0));
		visited[list.get(0)]= true;
		
		while(!queue.isEmpty()) {
			int area = queue.poll();
			for(int adjArea : person[area].adjList) {
				if(!visited[adjArea] && list.contains(adjArea)) {
					queue.add(adjArea);
					visited[adjArea] = true;
				}
			}

		}
		
		for(int val : list) {
			if(!visited[val])
				return false;
		}
		return true;
		
	}
}

class Area {
	int person;
	List<Integer> adjList;
	
	public Area(int person, List<Integer> adjList) {
		super();
		this.person = person;
		this.adjList = adjList;
	}


	@Override
	public String toString() {
		return "Area [person=" + person + ", adjList=" + adjList + "]";
	}
	
}
