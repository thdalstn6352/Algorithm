package baekjoon.BOJ_17087;

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
		
		String[] lines = br.readLine().split(" ");
		int testCase = Integer.parseInt(lines[0]);
		int currLoc = Integer.parseInt(lines[1]);
		int maxDist = 0;
		String[] numbers = br.readLine().split(" ");
		
		List<Integer> list = new ArrayList<Integer>();
		
		
		for(int tc = 0; tc < testCase; tc++) {
			list.add(Math.abs(currLoc - Integer.parseInt(numbers[tc])));
		}
		
		maxDist = list.get(0);
		
		for(int i = 1; i < list.size(); i++) {
			maxDist = getGCD(maxDist, list.get(i));
			
		}
		

		sb.append(maxDist);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
		
		
	}
	
	public static int getGCD(int num1, int num2) {
		if(num1 % num2 == 0) 
			return num2;
		return getGCD(num2, num1 % num2);
	}
}
