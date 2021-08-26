package sw_expert.sw_expert_5215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	static Eval_Info2 eval_info;
	static List<Eval_Info2> list;
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
			
			//리스트 생성
			list = new ArrayList<Eval_Info2>();
			//isSelected = new boolean[ingreNum];
			
			//리스트 추가
			for(int i = 0; i < ingreNum; i++) {
				eval_info = new Eval_Info2();
				String[] eval = br.readLine().split(" ");
				
				eval_info.score = Integer.parseInt(eval[0]);
				eval_info.cal = Integer.parseInt(eval[1]);
				list.add(eval_info);
			}
			
			//부분집합
			subset(0, 0, 0);
			
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
	
	public static void subset(int cnt, int cal, int score) {
		if(cal > calLimit)
			return;
		
		
		if (cnt == ingreNum) {
			max = Math.max(max, score);
			return;
		}
		int curCal = list.get(cnt).cal;
		int curScore = list.get(cnt).score;
		
		subset(cnt + 1, cal + curCal, score + curScore); //자신 포함
		subset(cnt + 1, cal, score); //자신 포함x
	}
	
}

class Eval_Info2 {
	int score;
	int cal;
	
	public Eval_Info2() {
		super();
	}
}