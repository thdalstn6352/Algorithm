package baekjoon.BOJ_1932_정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
	
		int[][] nums = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < r + 1; c++) {
			nums[r][c] = Integer.parseInt(lines[c]);
			}
		}
		
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				nums[i-1][j] += Math.max(nums[i][j], nums[i][j + 1]);
			}
		}
		System.out.println(nums[0][0]);
    }
}