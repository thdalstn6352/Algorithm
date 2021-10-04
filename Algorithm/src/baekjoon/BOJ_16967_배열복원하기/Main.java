package baekjoon.BOJ_16967_배열복원하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int H, W, X, Y;
	static int[][] A, B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] HWXY = br.readLine().split(" ");
		H = Integer.parseInt(HWXY[0]);
		W = Integer.parseInt(HWXY[1]);
		X = Integer.parseInt(HWXY[2]);
		Y = Integer.parseInt(HWXY[3]);
		B = new int[H+X][W+Y];
		A = new int[H][W];
		
		for(int r = 0; r < H + X; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < W + Y; c++) {
				int value = Integer.parseInt(lines[c]);
				B[r][c] = value;
			}
		}

		for(int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++) {
				A[r][c] = B[r][c];
				if(r >= X && c >= Y)
					A[r][c] = A[r][c] - A[r-X][c-Y];
				
				sb.append(A[r][c]).append(" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
