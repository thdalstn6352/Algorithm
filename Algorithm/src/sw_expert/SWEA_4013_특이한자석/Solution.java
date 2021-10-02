package sw_expert.SWEA_4013_특이한자석;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int[][] magnet;
	static boolean[] isTurn;
	static Queue<Magnet> magnetQueue;
	static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			magnet = new int[4][8];
			
			for(int r = 0; r < 4; r++) {
				String[] lines = br.readLine().split(" ");
				for(int c = 0; c < 8; c++) {
					magnet[r][c] = Integer.parseInt(lines[c]);
				}
			}
			
			for(int k = 0; k < K; k++) {
				magnetQueue = new LinkedList<>();
				String[] infos = br.readLine().split(" ");
				isTurn = new boolean[4];
				
				int magnetNum = Integer.parseInt(infos[0]);
				int dir = Integer.parseInt(infos[1]);
				
				compare(magnetNum - 1, dir);
				
				while(!magnetQueue.isEmpty()) {
					Magnet mag = magnetQueue.poll();
					turnMagnet(mag.idx, mag.dir);
				}
			}
			
			for(int i = 0; i < 4; i++) {
				sum += magnet[i][0] * Math.pow(2, i);
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
			sum = 0;
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	private static void compare(int idx, int dir) {
		Queue<Magnet> queue = new LinkedList<>();
		
		queue.add(new Magnet(idx, dir));
		magnetQueue.add(new Magnet(idx, dir));
		isTurn[idx] = true;
		
		while(!queue.isEmpty()) {
			Magnet m = queue.poll();
			for(int i = -1; i < 2; i+=2) {
				int nidx = m.idx + i;
				int ndir = -m.dir;
				if(isOk(m.idx, nidx) && !isTurn[nidx]) {
					queue.add(new Magnet(nidx, ndir));
					magnetQueue.add(new Magnet(nidx, ndir));
					isTurn[nidx] = true;
				}
			}
		}
	}
	
	private static boolean isOk(int cur, int next) {
		if(next < 0 || next > 3)
			return false;
		else {
			if(cur > next) {
				if(magnet[cur][6] == magnet[next][2])
					return false;
			}
			else
				if(magnet[cur][2] == magnet[next][6])
					return false;
		}
		return true;
	}
	
	private static void turnMagnet(int idx, int dir) {
		if(dir == 1) {
			int temp = magnet[idx][7];
			
			for(int i = 7; i > 0; i--) {
				//System.out.printf("magnet[%d][%d] = magnet[%d][%d]%n",idx, i, idx, i-1);
				magnet[idx][i] = magnet[idx][i-1];
			}
			magnet[idx][0] = temp;
		}
		else {
			int temp = magnet[idx][0];
			for(int i = 0; i < 7; i++) {
				magnet[idx][i] = magnet[idx][i+1];
			}
			magnet[idx][7] = temp;
		}
	}
	
}

class Magnet {
	int idx;
	int dir;
	
	public Magnet(int idx, int dir) {
		super();
		this.idx = idx;
		this.dir = dir;
	}
	
}
