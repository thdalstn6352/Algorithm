package baekjoon.BOJ_2304;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int area;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		List<Pillar> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int highestPillarHeight = Integer.MIN_VALUE;
		Pillar highestPillar = null;
		
		for(int i = 0; i < N; i++) {
			String[] pillars = br.readLine().split(" ");
			int startX = Integer.parseInt(pillars[0]);
			int height = Integer.parseInt(pillars[1]);
			Pillar pillar = new Pillar(startX, height);
			
			if(highestPillarHeight < height) {
				highestPillarHeight = height;
				highestPillar = pillar;
			}
			list.add(pillar);
		}
		
		Collections.sort(list);
		// 가장 높은 기둥의 인덱스
		int idx = list.indexOf(highestPillar);
		
		// 왼쪽 시작
		Pillar LhighPillar = list.get(0);
		
		for(int i = 1; i <= idx; i++) {
			int currAxis = list.get(i).x;
			int currHeight = list.get(i).y;
			
			if(LhighPillar.y <= currHeight) {
				area += (currAxis - LhighPillar.x) * LhighPillar.y;
				LhighPillar = list.get(i);
			}
		}
		
		// 오른쪽 시작
		Pillar RhighPillar = list.get(N - 1);
		
		for(int i = N - 2; i >= idx; i--) {
			int currAxis = list.get(i).x;
			int currHeight = list.get(i).y;
			
			if(RhighPillar.y <= currHeight) {
				area += (RhighPillar.x - currAxis) * RhighPillar.y;
				RhighPillar = list.get(i);
			}
		}
		
		area += list.get(idx).y;
		System.out.println(area);
	}
}

class Pillar implements Comparable<Pillar>{
	int x;
	int y;
	
	public Pillar(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pillar o) {
		return this.x - o.x;
	}
}
