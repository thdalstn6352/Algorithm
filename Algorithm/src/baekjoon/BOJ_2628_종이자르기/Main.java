package baekjoon.BOJ_2628_종이자르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		List<Integer> seroList = new ArrayList<>();
		List<Integer> garoList = new ArrayList<>();
		
		List<Integer> ResSero = new ArrayList<>();
		List<Integer> ResGaro = new ArrayList<>();
		
		String[] size = br.readLine().split(" ");
		int sero = Integer.parseInt(size[0]);
		int garo = Integer.parseInt(size[1]);

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] msg = br.readLine().split(" ");
			int dir = Integer.parseInt(msg[0]);
			int value = Integer.parseInt(msg[1]);
			
			if(dir == 0)
				garoList.add(value);
			else
				seroList.add(value);
		}
		
		Collections.sort(seroList);
		Collections.sort(garoList);
		
		for(int i = 0; i < garoList.size(); i++) {
			int target = garoList.get(i);
			if(ResGaro.isEmpty()) {
				ResGaro.add(target);
				ResGaro.add(garo - target);
			}
			else {
				ResGaro.set(i, target - garoList.get(i - 1));
				ResGaro.add(garo - target);
			}
		}
		
		for(int i = 0; i < seroList.size(); i++) {
			int target = seroList.get(i);
			if(ResSero.isEmpty()) {
				ResSero.add(target);
				ResSero.add(sero - target);
			}
			else {
				ResSero.set(i, target - seroList.get(i - 1));
				ResSero.add(sero - target);
			}
		}
		if(ResSero.size() == 0)
			ResSero.add(sero);
		if(ResGaro.size() == 0)
			ResGaro.add(garo);
		
		int area = Collections.max(ResGaro) * Collections.max(ResSero);
		//System.out.println(ResGaro);
		//System.out.println(ResSero);
		sb.append(area);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}
