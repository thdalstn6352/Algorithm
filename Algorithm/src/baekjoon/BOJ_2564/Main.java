package baekjoon.BOJ_2564;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		List<Shop> list = new ArrayList<>();
		Shop user = null;
		
		String[] blockSize = br.readLine().split(" ");
		int col = Integer.parseInt(blockSize[0]);
		int row = Integer.parseInt(blockSize[1]);
		
		
		int shopNum = Integer.parseInt(br.readLine());
		
		for(int idx = 0; idx < shopNum + 1; idx++) {
			String[] shopInfo = br.readLine().split(" ");
			int dir = Integer.parseInt(shopInfo[0]);
			int dist = Integer.parseInt(shopInfo[1]);
			
			if(idx != shopNum) // 상점의 정보
				list.add(new Shop(dir, dist, row, col));
			else { // 유저의 정보
				user = new Shop(dir, dist, row, col);
			}
		}
		int sum = 0;
		
		if(user.dir == 1 || user.dir == 2) { // 북쪽, 남쪽에 유저가 있을경우
			for(Shop s : list) {
				if(Math.abs(user.row - s.row) == row) { // 마주보고 있을 경우
					sum += Math.min(user.dist + s.dist + row, col - user.dist + col - s.dist + row);
				}
				else {
					sum += Math.abs(user.row - s.row) + Math.abs(user.col - s.col);
				}
			}
		}
		else {
			for(Shop s : list) { // 동쪽, 서쪽에 유저가 있을경우
				if(Math.abs(user.col - s.col) == col) { // 마주보고 있을 경우
					sum += Math.min(user.dist + s.dist + col, row - user.dist + row - s.dist + col);
				}
				else {
					sum += Math.abs(user.row - s.row) + Math.abs(user.col - s.col);
				}
			}
		}
		
		sb.append(sum);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}

class Shop {
	int dir;
	int dist;
	int row;
	int col;
	
	public Shop(int dir, int dist, int row, int col) {
		super();
		this.dir = dir;
		
		switch(this.dir) 
		{
		case 1:
			this.row = 0;
			this.col = dist;
			break;
		case 2:
			this.row = row;
			this.col = dist;
			break;
		case 3:
			this.row = dist;
			this.col = 0;
			break;
		case 4:
			this.row = dist;
			this.col = col;
			break;
		}
		this.dist = dist;
	}

}
