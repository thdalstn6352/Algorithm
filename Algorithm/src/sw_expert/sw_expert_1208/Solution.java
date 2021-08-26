package sw_expert.sw_expert_1208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[100];
		
		int test_case = 10;
		
		for(int i = 0; i < test_case; i++) {
			int dump_cnt = Integer.parseInt(br.readLine());
			String[] msg = br.readLine().split(" ");
			
			for(int j = 0; j < 100; j++) {
				arr[j] = Integer.parseInt(msg[j]);
			}
			
			Arrays.sort(arr);
			
			for(int cnt = 0; cnt < dump_cnt; cnt++) {
				arr[0] += 1;
				arr[99] -= 1;
				
				if(arr[0] <= arr[1] && arr[99] >= arr[98]) {
					continue;
				}
				else {
					
					Arrays.sort(arr);
				}
			}
			sb.append("#").append(i+1).append(" ").append(arr[99] - arr[0]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
