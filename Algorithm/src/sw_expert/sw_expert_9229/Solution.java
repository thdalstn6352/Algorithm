package sw_expert.sw_expert_9229;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	static List<Integer> list;
	static int[] numbers;
	static int snackNum, weightLimit;
	static int max = -1;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//테스트 케이스 수
		int testCase = Integer.parseInt(br.readLine());
		
		//데이터 입력
		for(int tc = 1; tc <= testCase; tc++) {
			list = new ArrayList<Integer>();
			numbers = new int[2];
			
			String[] info = br.readLine().split(" ");
			snackNum = Integer.parseInt(info[0]);
			weightLimit = Integer.parseInt(info[1]);
			
			//리스트 생성
			
			String[] snacks = br.readLine().split(" ");

			for(String snack : snacks) {
				
				list.add(Integer.parseInt(snack));
			}
			//부분집합
			combination(0,0);
			
			//출력
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			
			//초기화
			max = -1;
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	public static void combination(int cnt, int start) {
		int sum = 0;
		if (cnt == 2) {
			sum = numbers[0] + numbers[1];
			if(sum <= weightLimit)
				max = Math.max(max, sum);
			return;
		}
		
		for(int i = start; i < snackNum; i++) {
			numbers[cnt] = list.get(i);
			combination(cnt+1, i+1);
		}
	}
	
}
