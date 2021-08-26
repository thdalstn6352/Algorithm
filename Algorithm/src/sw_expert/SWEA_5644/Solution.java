package sw_expert.SWEA_5644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	static int[] moveA, moveB;
	static int[][] deltas = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int moveCnt, batteryNum, chargeSum;
	static User userA, userB;
	static List<BatteryInfo> batteryList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= testCase; tc++) {
			
			batteryList = new ArrayList<>();
			
			String[] msg = br.readLine().split(" ");
			moveCnt = Integer.parseInt(msg[0]);
			batteryNum = Integer.parseInt(msg[1]);
			
			// 사용자 처음 위치
			userA = new User(0, 0);
			userB = new User(9, 9);
			
			// 사용자별 이동 방향 (0 - N 이므로 N+1칸 설정)
			moveA = new int[moveCnt + 1];
			moveB = new int[moveCnt + 1];
			
			String[] userA_info = br.readLine().split(" ");
			String[] userB_info = br.readLine().split(" ");
			
			for(int i = 0; i < userA_info.length; i++) {
				moveA[i] = Integer.parseInt(userA_info[i]);
				moveB[i] = Integer.parseInt(userB_info[i]);
			}
			
			// 배터리센터의 정보
			for(int bn = 1; bn <= batteryNum; bn++) {
				BatteryInfo batteryInfo = new BatteryInfo();
				
				String[] batInfo = br.readLine().split(" ");
				
				batteryInfo.y = Integer.parseInt(batInfo[0]) - 1;
				batteryInfo.x = Integer.parseInt(batInfo[1]) - 1;
				batteryInfo.c = Integer.parseInt(batInfo[2]);
				batteryInfo.p = Integer.parseInt(batInfo[3]);
				
				batteryList.add(batteryInfo);
			}
			
			// 이동
			for(int m = 0; m <= moveCnt; m++) {
//				System.out.println("T = " + m);
//				System.out.println(userA.x +" " +userA.y);
//				System.out.println(userB.x +" " +userB.y);
				moveNcharge();
				userA.x += deltas[moveA[m]][0];
				userA.y += deltas[moveA[m]][1];
				
				userB.x += deltas[moveB[m]][0];
				userB.y += deltas[moveB[m]][1];
				
			}
			sb.append("#").append(tc).append(" ").append(chargeSum).append("\n");
			chargeSum = 0;
		}
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
	
	public static void moveNcharge() {
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();
		int max = 0;
		
		for(int b = 0; b < batteryNum; b++) {
			int AtoBattery = Math.abs(userA.x - batteryList.get(b).x) + Math.abs(userA.y - batteryList.get(b).y);
			int BtoBattery = Math.abs(userB.x - batteryList.get(b).x) + Math.abs(userB.y - batteryList.get(b).y);
			
			if(AtoBattery <= batteryList.get(b).c) {
				listA.add(b);
			}
			if(BtoBattery <= batteryList.get(b).c) {
				listB.add(b);
			}
		}
		
		if(listA.size() == 0 && listB.size() == 0) {
			return;
		}
		else if(listA.size() == 0 && listB.size() != 0) {
			for(int b : listB) {
				max = Math.max(max, batteryList.get(b).p);
			}
		}
		else if(listA.size() != 0 && listB.size() == 0) {
			for(int a : listA) {
				max = Math.max(max, batteryList.get(a).p);
			}
		}
		else {
			int sumA = 0;
			int sumB = 0;
			for(int a: listA) {
				for(int b: listB) {
					if(a == b) {
						int chargeAmount = batteryList.get(a).p;
						sumA = chargeAmount / 2;
						sumB = chargeAmount / 2;
					}
					else {
						sumA = batteryList.get(a).p;
						sumB = batteryList.get(b).p;
					}
					
					max = Math.max(max, sumA + sumB);
				}
			}
		}
		
		chargeSum += max;
		return;
	}
}
class User {
	int x;
	int y;
	
	public User(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
class BatteryInfo {
	int x;
	int y;
	int c;
	int p;
	
	public BatteryInfo() {
		super();
	}
	
}
