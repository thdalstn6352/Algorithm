package baekjoon.BOJ_2116;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int T, res;
	static int[][] dices;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		T = Integer.parseInt(br.readLine());
		dices = new int[T][6];
		
		for(int tc = 0; tc < T; tc++) {
			String[] diceNums = br.readLine().split(" ");
			
			for(int i = 0; i < 6; i++)
				dices[tc][i] = Integer.parseInt(diceNums[i]);
		}
		
		for(int bottomIdx = 0; bottomIdx < 6; bottomIdx++) {
			int topValue = getTopNum(bottomIdx, 0);
			calc(topValue, 0, 0);
		}
		
		sb.append(res);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	private static int calc(int topValue, int diceNum, int max) {
		if(diceNum == T) {
			res = Math.max(res, max);
			return 1;
		}
		
		int bottomValue = topValue;
		int bottomIdx = 0;
		
		for(int i = 0; i < dices[diceNum].length; i++) {
			if(bottomValue == dices[diceNum][i]) {
				bottomIdx = i;
				break;
			}
		}
		
		int top = getTopNum(bottomIdx, diceNum);
		
		int maxDice = 0;
		for(int i : dices[diceNum]) {
			if(i != bottomValue && i != top) {
				maxDice = Math.max(maxDice, i);
			}
		}
		
		return calc(top, diceNum+1, max+maxDice);
	}
	
	private static int getTopNum(int bottomIdx, int idx) {
		int topValue = 0;
		
		// 밑면: 0 1 2 3 4 5
		// 윗면: 5 3 4 1 2 0
		
		if(bottomIdx == 0 || bottomIdx == 5) {
			topValue = dices[idx][5 - bottomIdx];
		}
		else if(bottomIdx == 1 || bottomIdx == 3) {
			topValue = dices[idx][4 - bottomIdx];
		}
		else {
			topValue = dices[idx][6 - bottomIdx];
		}
		
		return topValue;
	}
}
