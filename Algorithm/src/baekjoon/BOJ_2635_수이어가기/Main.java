package baekjoon.BOJ_2635_수이어가기;

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
	
		int num = Integer.parseInt(br.readLine());
		int max = 0;
		List<Integer> maxList = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = num; i >= num /2; i--) {
			int count = 2;
			list.add(num);
			list.add(i);
			for(int j = 0; ; j++) {
				if(list.get(j) - list.get(j + 1) < 0) {
					if(count > max) {
						max = count;
						maxList.clear();
						maxList.addAll(list);
					}
					list.clear();
					break;
				}
				list.add(list.get(j) - list.get(j + 1));
				count++;
			}
		}
		sb.append(max).append("\n");
		
		for(int i : maxList) {
			sb.append(i).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}
