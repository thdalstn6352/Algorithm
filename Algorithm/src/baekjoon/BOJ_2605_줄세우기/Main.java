package baekjoon.BOJ_2605_줄세우기;

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
	
		List<Integer> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		String[] msg = br.readLine().split(" ");
		
		for(int i = 1; i <= N; i++) {
			int val = Integer.parseInt(msg[i-1]);
			if(val == 0)
				list.add(i);
			else {
				list.add(i - 1 - val, i);
			}
		}
		for(int i : list)
			sb.append(i).append(" ");
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}

}
