package baekjoon.BOJ_15686;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
	static int M;
	static int N;
	static int LIMIT_CNT;
	static int ChickenToHomeMinDist = Integer.MAX_VALUE;
	static int[][] map;
	static HomePoint2 homePoint;
	static ChickenPoint2 chickenPoint;
	static List<HomePoint2> homeList;
	static List<ChickenPoint2> chickenList;

	static ChickenPoint2[] chickenArr;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] msg = br.readLine().split(" ");
		N = Integer.parseInt(msg[0]);
		M = Integer.parseInt(msg[1]);
		map = new int[N][N];
		homeList = new ArrayList<HomePoint2>();
		chickenList = new ArrayList<ChickenPoint2>();
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < N; c++) {
				
				if(lines[c].equals("1")) {
					homeList.add(new HomePoint2(r, c));
				}
				else if(lines[c].equals("2")) {
					chickenList.add(new ChickenPoint2(r, c));
				}
				map[r][c] = Integer.parseInt(lines[c]);
			}
		}
		
		for(int index = 1; index <= M; index++) {
			chickenArr = new ChickenPoint2[M];
			LIMIT_CNT = index;
			combination(0, 0);
		}
		
		sb.append(ChickenToHomeMinDist);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	private static void combination(int cnt,int start) {
		if(cnt == M) {
			calcDistance();
			return;
		}
		
		for (int i = start; i < chickenList.size(); i++) { // i : 인덱스
			chickenArr[cnt] = chickenList.get(i);
			combination(cnt+1,i+1);
		}
	
	}
	
	private static int getDistance(HomePoint2 homeAxis, ChickenPoint2 chickenAxis) {
		int xAxis = Math.abs(homeAxis.x - chickenAxis.x);
		int yAxis = Math.abs(homeAxis.y - chickenAxis.y);
		return xAxis + yAxis;
	}
	
	private static void calcDistance() {
		int ChickenToHomeDistSum = 0;
		
		for(int i = 0; i < homeList.size(); i++) { //집의 수만큼 반복
			int min_distance = Integer.MAX_VALUE;			
			for(int j = 0; j < chickenArr.length; j++) { //치킨집 수만큼 반복
				min_distance = Math.min(min_distance, getDistance(homeList.get(i), chickenArr[j]));
			}
			ChickenToHomeDistSum += min_distance;
		}
		ChickenToHomeMinDist = Math.min(ChickenToHomeMinDist, ChickenToHomeDistSum);
	}
}

class HomePoint2 {
	int x;
	int y;
	
	public HomePoint2(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}

class ChickenPoint2 {
	int x;
	int y;
	
	public ChickenPoint2(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
