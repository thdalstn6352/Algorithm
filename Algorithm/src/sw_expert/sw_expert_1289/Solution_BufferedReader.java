package sw_expert.sw_expert_1289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_BufferedReader {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		int count;
		int flag;
		
		for(int i = 1; i <= test_case; i++) {
			String msg = br.readLine();
			count = 0;
			flag = 1;
			
			for(int index = 0; index < msg.length(); index++) {
				if((msg.charAt(index) - '0') == flag) {
					flag -= 1;
					flag = Math.abs(flag);
					count++;
				}
					
			}
			sb.append("#");
			sb.append(i);
			sb.append(" ");
			sb.append(count);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
