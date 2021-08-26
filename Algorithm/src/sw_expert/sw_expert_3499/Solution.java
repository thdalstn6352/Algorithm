package sw_expert.sw_expert_3499;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		boolean flag;
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= test_case; tc++) {
			int cardNum = Integer.parseInt(br.readLine());
			String[] cards = br.readLine().split(" ");
			
			String[] result = new String[cardNum];
			int first = 0;
			int second = 0;
			if(cardNum % 2 == 1) 
				second = cardNum / 2 + 1;
			else
				second = cardNum / 2;
			
			flag = true;
			
			for(int i = 0; i < cardNum; i++) {
				if(flag) {
					result[i] = cards[first];
					first++;
					flag = false;
				}
				else {
					result[i] = cards[second];
					second++;
					flag = true;
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for(String value : result) {
				sb.append(value).append(" ");
			}
			sb.toString().trim();
			sb.append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}
