package sw_expert.SWEA_1859_백만장자;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] msg = br.readLine().split(" ");
			int max = 0;
			long sum = 0;
			max = Integer.parseInt(msg[N - 1]);
			
			for(int i = N - 2; i >= 0; i--) {
				int val = Integer.parseInt(msg[i]);
				
				if(max >= val) {
					sum += max - val;
				}
				else {
					max = val;
				}
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
}
