package baekjoon.BOJ_16935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int N, M, COMMAND_NUM;
	static int[][] arr;
	static int[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] msg = br.readLine().split(" ");
		N = Integer.parseInt(msg[0]);
		M = Integer.parseInt(msg[1]);
		COMMAND_NUM = Integer.parseInt(msg[2]);
		arr = new int[N][M];
		list = new int[COMMAND_NUM];
		
		for(int r = 0; r < N; r++) {
			String[] lines = br.readLine().split(" ");
			for(int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(lines[c]);
			}
		}
		
		String[] line = br.readLine().split(" ");
		for(int num = 0; num < COMMAND_NUM; num++) {
			list[num] = Integer.parseInt(line[num]);
		}
		
		for(int comm : list) {
			switch(comm) {
			case 1: 
				UpToDown();
				break;
			case 2:
				LeftToRight();
				break;
			case 3:
				Rotate90ToRight();
				break;
			case 4:
				Rotate90ToLeft();
				break;
			case 5:
				MoveSubArrToRight();
				break;
			case 6:
				MoveSubArrToLeft();
				break;
			default:
				System.out.println("오류");
			}
		}
		
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col <arr[0].length; col++) {
				sb.append(arr[row][col]).append(" ");
			}
			sb.toString().trim();
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
		
	}
	
	public static void UpToDown( ) {
		for(int i = 0; i < N / 2; i++) {
			int[] temp = arr[i];
			arr[i] = arr[N - i - 1];
			arr[N - i - 1] = temp;
		}
	}
	public static void LeftToRight( ) {
		for(int[] rowArr : arr) {
			for(int i = 0; i < M / 2; i++) {
				int temp = rowArr[i];
				rowArr[i] = rowArr[M - i - 1];
				rowArr[M - i - 1] = temp;
			}
		}
		
	}
	public static void Rotate90ToRight( ) {
		int[][] newArr = new int[M][N];
		
		for(int col = 0; col < M; col++) {
			for(int row = 0; row < N; row++) {
				newArr[col][row] = arr[N - 1 - row][col];
			}
		}
		arr = newArr;
		N = arr.length;
		M = arr[0].length;
	}
	public static void Rotate90ToLeft( ) {
		int[][] newArr = new int[M][N];
		
		for(int col = M - 1; col >= 0; col--) {
			for(int row = 0; row < N; row++) {
				newArr[M - 1 - col][row] = arr[row][col];
			}
		}
		arr = newArr;
		N = arr.length;
		M = arr[0].length;
	}
	public static void MoveSubArrToRight( ) {
		int[][] subArr = new int[N/2][M/2];
		for(int r = 0; r < N/2; r++) {
			for(int c = 0; c < M/2; c++) {
				subArr[r][c] = arr[r][c];
			}
		}
		
		for(int r = 0; r < N/2; r++) {
			for(int c = 0; c < M/2; c++) {
				arr[r][c] = arr[r + (N/2)][c];
			}
		}
		
		for(int r = N/2; r < N; r++) {
			for(int c = 0; c < M/2; c++) {
				arr[r][c] = arr[r][c + (M/2)];
			}
		}
		
		for(int r = N/2; r < N; r++) {
			for(int c = M/2; c < M; c++) {
				arr[r][c] = arr[r - (N/2)][c];
			}
		}
		
		for(int r = 0; r < N/2; r++) {
			for(int c = M/2; c < M; c++) {
				arr[r][c] = subArr[r][c - (M/2)];
			}
		}
	}
	public static void MoveSubArrToLeft( ) {
		int[][] subArr = new int[N/2][M/2];
		for(int r = 0; r < N/2; r++) {
			for(int c = 0; c < M/2; c++) {
				subArr[r][c] = arr[r][c];
			}
		}
		
		for(int r = 0; r < N/2; r++) {
			for(int c = 0; c < M/2; c++) {
				arr[r][c] = arr[r][c + (M/2)];
			}
		}
		
		for(int r = 0; r < N/2; r++) {
			for(int c = M/2; c < M; c++) {
				arr[r][c] = arr[r + (N/2)][c];
			}
		}
		
		for(int r = N/2; r < N; r++) {
			for(int c = M/2; c < M; c++) {
				arr[r][c] = arr[r][c - (M/2)];
			}
		}
		
		for(int r = N/2; r < N; r++) {
			for(int c = 0; c < M/2; c++) {
				arr[r][c] = subArr[r - (N/2)][c];
			}
		}
		
		
		
		
	}
}
