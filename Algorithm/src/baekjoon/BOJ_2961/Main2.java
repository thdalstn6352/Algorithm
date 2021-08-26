package baekjoon.BOJ_2961;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
	static IngreInfo2 ingreInfo;
	static IngreInfo2[] ingreArr;
	static int ingreNum;
	static boolean[] isSelected;
	static int DiffMin = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		ingreNum = Integer.parseInt(br.readLine());
		ingreArr = new IngreInfo2[ingreNum];
		
		for(int in = 0; in < ingreNum; in++) {
			ingreInfo = new IngreInfo2();
			isSelected = new boolean[ingreNum];
			
			String[] ingre = br.readLine().split(" ");
			ingreInfo.sour = Integer.parseInt(ingre[0]);
			ingreInfo.bitter = Integer.parseInt(ingre[1]);
			ingreArr[in] = ingreInfo;
		}
		
		generateSubset(0);
		sb.append(DiffMin);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	private static void generateSubset(int cnt){
		if(cnt == ingreNum) {
			// 부분집합 완성
			int SourMul = 1;
			int BitterSum = 0;
			int Diff = -1;
			int totalCnt = 0;
			
			for (int i = 0; i < ingreNum; i++) {
				if(isSelected[i]) {
					SourMul *= ingreArr[i].sour;
					BitterSum += ingreArr[i].bitter;
					totalCnt++;
				}
			}
			//재료를 하나도 사용하지 않을 경우
			if(totalCnt == 0)
				return;
			
			Diff = Math.abs(SourMul - BitterSum);
			
			DiffMin = Math.min(DiffMin, Diff);
			return;
		}
		
		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}
}

class IngreInfo2 {
	int sour;
	int bitter;
	
	public IngreInfo2() {
		super();
	}
}
