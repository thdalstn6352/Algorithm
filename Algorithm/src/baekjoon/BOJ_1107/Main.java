package baekjoon.BOJ_1107;

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
		List<Integer> list = new ArrayList<Integer>();
		
		int[] isAvailable = new int[10];
		int startChannel = 100;
		int buttonCnt = Integer.MAX_VALUE;
		
		String N = br.readLine();
		int crackNum = Integer.parseInt(br.readLine());
		
		System.out.println(Integer.parseInt(N) == 99);
		String[] msg = br.readLine().split(" ");
		
		for(String s : msg) {
			isAvailable[Integer.parseInt(s)] = 1;
		}
		
		// 1. ++ or --로 이동
		buttonCnt = Math.min(buttonCnt, Math.abs(startChannel) - Integer.parseInt(N));
		
		// 2. 번호 누를 수 있을 경우
		int count = 0;
		
		
		
		for(int i = 0; i < N.length(); i++) {
			int value = N.charAt(i) - '0';
			if(isAvailable[value] != 0) {
			}
			count++;
		}
		if(count == N.length()) {
			System.out.println(count);
			return;
		}
			
	}
	
}
