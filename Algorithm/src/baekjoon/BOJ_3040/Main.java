package baekjoon.BOJ_3040;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] dwarfArr;
	static int[] realDwarfArr;
	static int flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	
		int dwarfNum = 9;
		dwarfArr = new int[dwarfNum];
		realDwarfArr = new int[7];
		
		for(int dn = 0; dn < dwarfNum; dn++) {
			dwarfArr[dn] = Integer.parseInt(br.readLine());
		}
		combination(0, 0);
		
		
		bw.write(sb.substring(0, sb.toString().length() - 1));
		bw.flush();
	}
	
	public static void combination(int cnt, int start) {
		if(flag == 1)
			return;
		
		if(cnt == 7) {
			int sum = IntStream.of(realDwarfArr).sum();
			if(sum == 100) {
				flag = 1;
				for(int dwarf: realDwarfArr)
					sb.append(dwarf).append("\n");
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			realDwarfArr[cnt] = dwarfArr[i];
			combination(cnt+1, i+1);
		}
	}
}
