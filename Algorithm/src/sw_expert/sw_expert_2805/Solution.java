package sw_expert.sw_expert_2805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	static int[][] arr;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//test case 수
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= test_case; tc++) {
			//배열의 크기
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			int sum = 0;
			//총 반복 횟수
			int iter = (N / 2) + 1;
			
			//시작 위치
			int start_x = N / 2;
			int start_y = 0;
			
			//다음 x좌표
			int x1 = start_x;
			int x2 = start_x;
			
			// 데이터 생성
			for(int r = 0; r < N; r++) {
				String value = br.readLine();
				for(int c = 0; c < N; c++) {
					arr[r][c] = value.charAt(c) - '0';
				}
			}

			// 반복 시작
			for(int i = 0; i < iter; i++) {
				int y = start_y;
				
				if( i == 0) {
					for(int j = 0; j < N - (i*2); j++, y++) {
						sum += arr[start_x][y];
					}
				}
				else {
					x1 -= 1;
					x2 += 1;
					for(int j = 0; j < N - (i*2); j++, y++) {
						sum += arr[x1][y];
						sum += arr[x2][y];
					}
				}
				start_y++;
			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}
