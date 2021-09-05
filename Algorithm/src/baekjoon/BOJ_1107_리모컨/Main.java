package baekjoon.BOJ_1107_리모컨;

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
		
		int[] isBroken = new int[10];
		int startChannel = 100;
		int buttonCnt = Integer.MAX_VALUE;
		
		int targetNum = Integer.parseInt(br.readLine());
		int crackNum = Integer.parseInt(br.readLine());
		
		String[] msg = br.readLine().split(" ");
		
		for(String s : msg) {
			isBroken[Integer.parseInt(s)] = 1;
		}
		
		// 1. ++ or --로 이동
		buttonCnt = Math.abs(startChannel - targetNum);
		
		// 2. 번호 누를 수 있을 경우
	
		// 9를 제외한 모든 수가 망가졌을 경우 최대 999999번의 클릭이 요구된다.
		for(int i = 0; i < 999999; i++) {
			//0 to 999999 완전탐색
			String value = String.valueOf(i);
			int length = value.length();
			boolean isAvailable = true;
			
			for(int l = 0; l < length; l++) {
				//모든 자리의 수가 망가졌는지 확인
				int val = value.charAt(l) - '0';
				if(isBroken[val] == 1) {
					isAvailable = false;
					break;
				}
			}
			
			//모두 누를 수 있는 경우 해당 번호를 누른 수(length)와 target수와 현재 누른 번호의 차이(targetNum - i)의 합과 비교
			if(isAvailable) {
				buttonCnt = Math.min(buttonCnt, length + Math.abs(targetNum - i));
			}
		}
		
		sb.append(buttonCnt);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
	
}
