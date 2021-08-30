package jungol.JO_1037_오류교정;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int changeX = 0;
		int changeY = 0;
		int flag = 0;
		
		for(int r = 0; r < N; r++) {
			String[] msg = br.readLine().split(" ");
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(msg[c]);
			}
		}
		
		for(int r = 0; r < N; r++) {
			int sum = 0;
			for(int c = 0; c < N; c++) {
				sum += map[r][c];
			}
			if(sum % 2 != 0) {
				flag++;
				changeX = r+1;
			}
		}
		if(flag > 1) {
			System.out.println("Corrupt");
			return;
		}
		flag = 0;
		
		for(int c = 0; c < N; c++) {
			int sum = 0;
			for(int r = 0; r < N; r++) {
				sum += map[r][c];
			}
			if(sum % 2 != 0) {
				flag++;
				changeY = c+1;
			}
		}
		if(flag > 1) {
			System.out.println("Corrupt");
			return;
		}
		
		if(changeX == 0 && changeY == 0) {
			System.out.println("OK");
		}
		else if(changeX != 0 && changeY != 0){
			System.out.printf("Change bit (%d,%d)",changeX, changeY);
		}
		else {
			System.out.println("Corrupt");
		}
	}
}
