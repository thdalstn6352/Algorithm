package sw_expert.sw_expert_3499;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		boolean flag;
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= test_case; tc++) {
			int cardNum = Integer.parseInt(br.readLine());
			String[] cards = br.readLine().split(" ");

			Stack<String> Fstack = new Stack<String>();
			Stack<String> Sstack = new Stack<String>();
			Stack<String> Result = new Stack<String>();
			
			//반복 수
			int ret = 0;
			
			//짝수 홀수에 따른 반복수 변경
			if(cardNum % 2 != 0) {
				ret = cardNum / 2 + 1;
				flag = true;
			}
			else {
				ret =  cardNum / 2;
				flag = false;
			}
					
			for(int i = 0; i < cardNum; i++) {
				if(i < ret) {
					Fstack.push(cards[i]);
				}
				else {
					Sstack.push(cards[i]);
				}
			}
			
			//짝수일때는 Sstack부터 pop
			//홀수일때는 Fstack부터 pop
			while(!Fstack.isEmpty() || !Sstack.isEmpty()) {
				if(flag) {
					Result.push(Fstack.pop());
					flag = false;
				}
				else {
					Result.push(Sstack.pop());
					flag = true;
				}
			}
			System.out.println(Result);
			
			sb.append("#").append(tc).append(" ");
			while(!Result.isEmpty()) {
				sb.append(Result.pop()).append(" ");
			}
			sb.toString().trim();
			sb.append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
}
