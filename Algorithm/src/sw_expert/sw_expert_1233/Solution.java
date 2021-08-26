package sw_expert.sw_expert_1233;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int testCase = 10;
		int flag = 0;
		int isAvailable = 0;
		for(int tc = 1; tc <= testCase; tc++) {
			int nodeNum = Integer.parseInt(br.readLine());
			char[] arr = new char[nodeNum + 1];
			
			for(int c = 1; c <= nodeNum; c++) {
				String[] msg = br.readLine().split(" ");
				arr[Integer.parseInt(msg[0])] = msg[1].charAt(0);
			}
			
			for(int r = 1; r <= nodeNum; r++) {
				if(arr[r] >= 48 && arr[r] <= 57) {
					if(r * 2 <= nodeNum || r * 2 + 1 <= nodeNum) {
						flag = 1;
						isAvailable = 0;
						break;
					}
				}
			}
			if(flag == 0)
				isAvailable = 1;
			sb.append("#").append(tc).append(" ").append(isAvailable).append("\n");
			flag = 0;
			isAvailable = 0;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}
