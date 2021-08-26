package sw_expert.SWEA_6808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	static List<Integer> manList;
	static List<Integer> womanList;
	//static List<Integer> permuList;
	static int[] permuArr;
	
	static boolean[] isSelected;
	static int manWin;
	static int womanWin;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= testCase; tc++) {
			manList = new ArrayList<Integer>();
			womanList = new ArrayList<Integer>();
			//permuList = new ArrayList<Integer>();
			permuArr = new int[9];
			isSelected = new boolean[9];
			
			String[] manCards = br.readLine().split(" ");
			for(int c = 0; c < manCards.length; c++) {
				manList.add(Integer.parseInt(manCards[c]));
			}
			
			for(int i = 1; i <= 18; i++) {
				if(manList.contains(i))
					continue;
				womanList.add(i);
			}
			permutation(0);
			sb.append("#").append(tc).append(" ").append(manWin).append(" ").append(womanWin).append("\n");
			manWin = 0;
			womanWin = 0;
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	private static void permutation(int cnt) {
		if(cnt == 9) {
			int manSum = 0;
			int womanSum = 0;
			for(int index = 0; index < 9; index++) {
				int manValue = manList.get(index);
				int womanValue = permuArr[index];
				
				if(manValue > womanValue) 
					manSum += manValue + womanValue; 
				else if(manValue < womanValue)
					womanSum += manValue + womanValue; 
			}
			if(manSum > womanSum)
				manWin++;
			else if(womanSum > manSum)
				womanWin++;
			
			return;
		}
		// 가능한 모든 수들이 들어있는 배열모든 원소에 대해 시도
		for (int i = 0; i < 9; i++) { // i : 인덱스
			if(isSelected[i]) continue; // 인덱스에 해당하는 수가 사용중인 수면 다음 수로.
			
			permuArr[cnt] = womanList.get(i);
			isSelected[i] = true;
			
			// 다음 자리순열 뽑으로 gogo
			permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}
}
