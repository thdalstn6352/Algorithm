package sw_expert.sw_expert_2001;

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
		int[][] deltas = { {0, 1}, {1,0} };
						//   우		우하	하
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] nm = br.readLine().split(" ");
			int N = Integer.parseInt(nm[0]);
			int M = Integer.parseInt(nm[1]);
			int sum = 0;
			int max = 0;
			int[][] arr = new int[N][N];
			
			// 데이터 받아옴
			for(int r = 0; r < N; r++) {
				String[] msg = br.readLine().split(" ");
				for(int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(msg[c]);
				}
			}
			
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					int nx = row + deltas[1][0] * (M - 1);
					int ny = col + deltas[0][1] * (M - 1);

					if(nx < N && ny < N) {
						for(int x = row; x < M + row; x++) {
							for(int y = col; y < M + col; y++) {
								sum += arr[x][y];
							}
						}
						max = Math.max(max, sum);
						sum = 0;
					}
					else {
						break;
					}
					
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
}
