package baekjoon.BOJ_2563;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int paperNum = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		int count = 0;
		
		for(int p = 0; p < paperNum; p++) {
			String[] msg = br.readLine().split(" ");
			int axisX = Integer.parseInt(msg[0]);
			int axisY = Integer.parseInt(msg[1]);
			
			for(int x = axisX; x < axisX + 10; x++) {
				for(int y = axisY; y < axisY + 10; y++) {
					if(paper[x][y] == 1)
						continue;
					paper[x][y] = 1;
					count++;
				}
			}
		}
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
		
	}
}
