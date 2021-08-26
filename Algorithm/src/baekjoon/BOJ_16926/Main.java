package baekjoon.BOJ_16926;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import javax.swing.text.AbstractDocument.LeafElement;

public class Main {
	static int N, M, CNT;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] arrayInfo = br.readLine().split(" ");
		N = Integer.parseInt(arrayInfo[0]);
		M = Integer.parseInt(arrayInfo[1]);
		CNT = Integer.parseInt(arrayInfo[2]);
		arr = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			String[] line = br.readLine().split(" ");
			for(int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(line[c]);
			}
		}
		for(int c = 0; c < CNT; c++) { 
			leftRotateArray(0, N-1, 0, M-1);
			//rightRotateArray(0, N-1, 0, M-1);
		}
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col <M; col++) {
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
	
	public static void leftRotateArray(int rs, int re, int cs, int ce) {
		if(rs >= re || cs >= ce) {
			return;
		}
		
		int temp = arr[rs][cs];
		for(int l = cs; l < ce; l++) {
			arr[rs][l] = arr[rs][l+1]; //<- 좌
		}
		for(int u = rs; u < re; u++) {
			arr[u][ce] = arr[u+1][ce]; // ^ 상
		}
		for(int r = ce; r > cs; r--) { 
			arr[re][r] = arr[re][r-1]; //-> 우
		}
		for(int d = re; d > rs; d--) {
			arr[d][cs] = arr[d-1][cs]; // v 하
		}
		arr[rs+1][cs] = temp;
		leftRotateArray(rs+1, re-1, cs+1, ce-1);
		
	}
	
	public static void rightRotateArray(int rs, int re, int cs, int ce) {
		if(rs >= re || cs >= ce) {
			return;
		}
		
		int temp = arr[rs][cs];
		for(int u = rs; u < re; u++) {
			arr[u][cs] = arr[u+1][cs];
		}
		for(int l = cs; l < ce; l++) {
			arr[re][l] = arr[re][l+1];
		}
		for(int d = re; d > rs; d--) {
			arr[d][ce] = arr[d-1][ce];
		}
		for(int r = ce; r > cs; r--) {
			arr[rs][r] = arr[rs][r-1];
		}
		arr[rs][cs+1] = temp;
		rightRotateArray(rs+1, re-1, cs+1, ce-1);
	}
}
