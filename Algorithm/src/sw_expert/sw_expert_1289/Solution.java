package sw_expert.sw_expert_1289;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T;
		T=sc.nextInt();
		int count = 0;
		int flag = 1;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String msg = sc.next();
			count = 0;
			flag = 1;
			for(int i = 0; i < msg.length(); i++) {
				if((msg.charAt(i) - '0') == flag) {
					flag -= 1;
					flag = Math.abs(flag);
					count++;
				}
					
			}
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(count);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}