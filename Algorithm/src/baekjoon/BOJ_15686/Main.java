package baekjoon.BOJ_15686;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int M;
	static int N;
	static int LIMIT_CNT;
	static int total_distance = Integer.MAX_VALUE;
	static int[][] map;
	static HomePoint homePoint;
	static ChickenPoint chickenPoint;
	static List<HomePoint> homeList;
	static List<ChickenPoint> chickenList;

	//static HomePoint[] homeArr;
	static ChickenPoint[] chickenArr;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] msg = br.readLine().split(" ");
		N = Integer.parseInt(msg[0]);
		M = Integer.parseInt(msg[1]);
		map = new int[N][N];
		homeList = new ArrayList<HomePoint>();
		chickenList = new ArrayList<ChickenPoint>();
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < N; c++) {
				
				if(lines[c].equals("1")) {
					homeList.add(new HomePoint(r, c));
				}
				else if(lines[c].equals("2")) {
					chickenList.add(new ChickenPoint(r, c));
				}
				
				map[r][c] = Integer.parseInt(lines[c]);
			}
		}
		
		for(int index = 1; index <= M; index++) {
			chickenArr = new ChickenPoint[index];
			LIMIT_CNT = index;
			combination(0, 0);
		}
		sb.append(total_distance);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	private static void combination(int cnt,int start) {
		if(cnt == LIMIT_CNT) {
			int total = 0;
			for(int i = 0; i < homeList.size(); i++) {
				int min_distance = Integer.MAX_VALUE;			
				for(int j = 0; j < chickenArr.length; j++) {
					
					int xAxis = Math.abs(homeList.get(i).x - chickenArr[j].x);
					int yAxis = Math.abs(homeList.get(i).y - chickenArr[j].y);

					min_distance = Math.min(min_distance, xAxis + yAxis);
				}
				total += min_distance;
			}
			total_distance = Math.min(total_distance, total);
			return;
		}
		
		for (int i = start; i < chickenList.size(); i++) { // i : 인덱스
			chickenArr[cnt] = chickenList.get(i);
			combination(cnt+1,i+1);
		}
	
	}
	
}

class HomePoint {
	int x;
	int y;
	
	public HomePoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}

class ChickenPoint {
	int x;
	int y;
	
	public ChickenPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
