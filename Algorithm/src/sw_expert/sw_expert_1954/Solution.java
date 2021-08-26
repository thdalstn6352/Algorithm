package sw_expert.sw_expert_1954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		int num;
		int[][] deltas = { {0, 1}, {1, 0} ,{0, -1}, {-1, 0} };
							//우	하		좌		상
						
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int i = 0; i < test_case; i++) {
			num = 1;
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int dir = 0;
			int x = 0;
			int y = 0;
			
			for(int cnt = 0; cnt < N * N; cnt++) {
				arr[x][y] = num;
				x += deltas[dir][0];
				y += deltas[dir][1];
				num++;
				
				if((x < 0 || x >= N || y < 0 || y >= N) || (arr[x][y] != 0)) {
					x -= deltas[dir][0];
					y -= deltas[dir][1];
					
					dir = (dir + 1) % 4; // deltas 인덱스 4->0
					
					x += deltas[dir][0];
					y += deltas[dir][1];
				}
			}
			
			System.out.printf("#%d%n",i+1);
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					System.out.print(arr[r][c] + " ");
				}
				System.out.println();
			}
		}
	}
}
