package sw_expert.sw_expert_1225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int test_case = 10;
		
		for(int c = 1; c <= test_case; c++) {
			int tc = Integer.parseInt(br.readLine());
			String[] number = br.readLine().split(" ");
			
			for(String num : number) {
				queue.offer(Integer.parseInt(num));
			}
			
			OUTER: while(true) {
				for(int i = 1; i <= 5; i++) {
					int dequeValue = queue.poll();
					int enqueValue = dequeValue - i;
					
					if(enqueValue <= 0) {
						queue.offer(0);
						break OUTER;
					}
					queue.offer(enqueValue);
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for(int j = 0; j < 8; j++)
                sb.append(queue.poll()).append(" ");
            sb.append("\n");
            queue.clear();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}
