package sw_expert.SWEA_6808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	static List<Integer> manList;
	static List<Integer> womanList;
	static int[] permuArr;
	static int flag;
	
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
			permuArr = new int[9];
			
			String[] manCards = br.readLine().split(" ");
			for(int c = 0; c < manCards.length; c++) {
				manList.add(Integer.parseInt(manCards[c]));
			}
			
			for(int i = 1; i <= 18; i++) {
				if(manList.contains(i))
					continue;
				womanList.add(i);
			}
			permutation(0, 0);
			sb.append("#").append(tc).append(" ").append(manWin).append(" ").append(womanWin).append("\n");
			manWin = 0;
			womanWin = 0;
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	private static void permutation(int cnt, int flag) {
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

		for (int i = 0; i < 9; i++) {
			if((flag & 1<<i) != 0) continue;
			
			permuArr[cnt] = womanList.get(i);
			
			permutation(cnt+1, (flag | 1<<i));
		}
		
	}
}
