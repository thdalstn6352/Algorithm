package sw_expert.sw_expert_1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] deltas = { {0, -1}, {0, 1}, {-1, 0} };
		int flag_left = 0;
		int flag_right = 0;
		
		//도착점의 초기 좌표
		int dest_y = 0;
		int dest_x = 99;
		
		int test_case = 10;
		int target_num = 1;
		
		for(int tc = 1; tc <= test_case; tc++) {
			int[][] ladder = new int[100][100];
			
			int case_num = Integer.parseInt(br.readLine());
			
            for (int i = 0; i < 100; i++) {
                String[] tempString = br.readLine().split(" ");
                for (int j = 0; j < 100; j++)
                    ladder[i][j] = Integer.parseInt(tempString[j]);
            }
			
			//도착점의 y좌표 구하기
            dest_x = 99;
			for(int i = 0; i < 100; i++) {
				if(ladder[dest_x][i] == 2)
					dest_y = i;
			}
			
			while(dest_x != 0) {
				for(int d = 0; d < deltas.length; d++) {
					if((flag_left == 1 && d == 1) || (flag_right == 1 && d == 0))
						continue;
					
					int nx = dest_x + deltas[d][0];
					int ny = dest_y + deltas[d][1];
					
					if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && ladder[nx][ny] == target_num) {
						dest_x = nx;
						dest_y = ny;
						if(d == 0) flag_left = 1;
						else if(d == 1)	flag_right = 1;
						
						else {
							flag_left = 0;
							flag_right = 0;
						}
						continue;
					}
				}
			}
			sb.append("#").append(case_num).append(" ").append(dest_y).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
