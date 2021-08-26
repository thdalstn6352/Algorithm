package sw_expert.sw_expert_5215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	static Eval_Info eval_info;
	static List<Eval_Info> list;
	static boolean[] isSelected;
	static int ingreNum, calLimit, max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//테스트 케이스 수
		int testCase = Integer.parseInt(br.readLine());
		
		//데이터 입력
		for(int tc = 1; tc <= testCase; tc++) {
			
			String[] info = br.readLine().split(" ");
			
			//값 저장
			ingreNum = Integer.parseInt(info[0]); //재료의 수
			calLimit = Integer.parseInt(info[1]); //제한 칼로리
			
			//ArrayList객체 생성
			list = new ArrayList<Eval_Info>();
			isSelected = new boolean[ingreNum];
			
			//데이터 입력
			for(int i = 0; i < ingreNum; i++) {
				eval_info = new Eval_Info();
				String[] eval = br.readLine().split(" ");
				
				eval_info.score = Integer.parseInt(eval[0]);
				eval_info.cal = Integer.parseInt(eval[1]);
				list.add(eval_info);
			}
			
			//부분집합
			subset(0);
			
			//출력
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			
			//초기화
			max = 0;
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	public static void subset(int cnt) {
		if (cnt == ingreNum) {
			calc();
			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);
	}
	
	private static void calc() {
		int sumCal = 0;
		int sumScore = 0;
		
		for (int index = 0; index < ingreNum; index++) {
			if (isSelected[index]) {
				sumCal += list.get(index).cal;
				sumScore += list.get(index).score;
			}
		}
		if(sumCal <= calLimit) 
			max = Math.max(max, sumScore);
	}
}

class Eval_Info {
	int score;
	int cal;
	
	public Eval_Info() {
		super();
	}
}