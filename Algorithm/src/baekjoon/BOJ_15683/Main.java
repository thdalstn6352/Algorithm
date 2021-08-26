package baekjoon.BOJ_15683;

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
import java.util.Stack;

public class Main {
	static int N, M;
	static int[][] map;
	static int result = Integer.MAX_VALUE;
	
	static List<CCTV> list;
	static int[][] deltas = { {0, 1}, {-1, 0}, {0, -1}, {1, 0} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] msg = br.readLine().split(" ");
		N = Integer.parseInt(msg[0]);
		M = Integer.parseInt(msg[1]);
		map = new int[N][M];
		list = new ArrayList<>();
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(lines[c]);
				if(map[r][c] >= 1 && map[r][c] <= 5) {
					list.add(new CCTV(r, c, map[r][c]));
				}
				
			}
		}
		rotate(0, list.size(), new CCTV[list.size()]);
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
	
	public static void rotate(int idx, int size, CCTV[] cctvSelected) {
		if(idx == size) {
			int[][] copyMap = deepCopy(map);
			cctvUpdate(copyMap, cctvSelected);
			return;
		}
		
		CCTV cctvInfo = list.get(idx);
		
		int cctvType = cctvInfo.type;
		
		for(int i = 0; i < 4; i++) {
			CCTV cctv = new CCTV(cctvInfo.x, cctvInfo.y, cctvInfo.type);
			
			switch(cctvType) {
			case 1:
				cctv.direction.add(i);
				cctvSelected[idx] = cctv;
				rotate(idx+1, size, cctvSelected);
				break;
			case 2:
				if(i >= 2)
					return;
				cctv.direction.add(i);
				cctv.direction.add(i + 2);
				cctvSelected[idx] = cctv;
				rotate(idx+1, size, cctvSelected);
				break;
			case 3:
				cctv.direction.add(i);
				cctv.direction.add((i + 1) % 4);
				cctvSelected[idx] = cctv;
				rotate(idx+1, size, cctvSelected);
				break;
			case 4:
				cctv.direction.add(i);
				cctv.direction.add((i + 1) % 4);
				cctv.direction.add((i + 2) % 4);
				cctvSelected[idx] = cctv;
				rotate(idx+1, size, cctvSelected);
				break;
			case 5:
				if(i >= 1)
					return;
				cctv.direction.add(i);
				cctv.direction.add((i + 1) % 4);
				cctv.direction.add((i + 2) % 4);
				cctv.direction.add((i + 3) % 4);
				cctvSelected[idx] = cctv;
				rotate(idx+1, size, cctvSelected);
				break;
			}
		}
	}
	public static void cctvUpdate(int[][] copyMap, CCTV[] cctvSelected) {
		for(int i = 0; i < cctvSelected.length; i++) {
			CCTV c = cctvSelected[i];
			
			int size = c.direction.size();
			
			for(int d = 0; d < size; d++) {
				int direction = c.direction.get(d);
				int nx = c.x + deltas[direction][0];
				int ny = c.y + deltas[direction][1];
				
				while(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(copyMap[nx][ny] == 0) {
						copyMap[nx][ny] = 7;
					}
					
					else if(map[nx][ny] == 6) {
						break;
					}
					
					nx += deltas[direction][0];
					ny += deltas[direction][1];
				}
			}
		}
		result = Math.min(result, calcArea(copyMap));
	}
	
	public static int calcArea(int[][] area) {
		
		int count = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				//System.out.print(area[r][c]);
				if(area[r][c] == 0)
					count++;
			}
			//System.out.println();
		}
		//System.out.println("--------------");
		return count;
	}
	
	
	public static int[][] deepCopy(int[][] copy){
	        int[][] copyMap = new int[N][M];
		    
	        for(int i = 0; i < N; i++) {
	            for(int j = 0; j < M; j++) {
	                copyMap[i][j] = copy[i][j];  
	            }
	        }
	        return copyMap;
	}
}

class CCTV {
	int x;
	int y;
	int type;
	List<Integer> direction = new ArrayList<>();
	
	public CCTV(int x, int y, int type) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
	}

	@Override
	public String toString() {
		return "CCTV [x=" + x + ", y=" + y + ", type=" + type + ", direction=" + direction + "]";
	}

}