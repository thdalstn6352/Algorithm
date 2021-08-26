package baekjoon.BOJ_17406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

public class Main {
	static int N, M, ROTATE_NUM;
	static int[][] arr;
	//static int[][] arrCopy;
	static Permu[] list;
	static boolean[] isSelected;
	static int min = Integer.MAX_VALUE;
	static int [][] numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] arrayInfo = br.readLine().split(" ");
		N = Integer.parseInt(arrayInfo[0]);
		M = Integer.parseInt(arrayInfo[1]);
		ROTATE_NUM = Integer.parseInt(arrayInfo[2]);
		
		arr = new int[N][M];
		list = new Permu[ROTATE_NUM];
		isSelected = new boolean[ROTATE_NUM];
		
		for(int r = 0; r < N; r++) {
			String[] line = br.readLine().split(" ");
			for(int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(line[c]);
			}
		}

		for(int tc = 0; tc < ROTATE_NUM; tc++) {
			Permu permu = new Permu();
			
			String[] lines = br.readLine().split(" ");
			int r = Integer.parseInt(lines[0]); // 3
			int c = Integer.parseInt(lines[1]); // 4
			int s = Integer.parseInt(lines[2]); // 2
			
			permu.rs = r - s - 1; //0
			permu.cs = c - s - 1; //1
			permu.re = r + s - 1; //4
			permu.ce = c + s - 1; //5
			
			list[tc] = permu;
		}
		permutation(0);
		sb.append(min);
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
	
	public static void permutation(int cnt) {
		if(cnt == ROTATE_NUM) {
			for(int row = 0; row < N; row++) {
				int sum = IntStream.of(arr[row]).sum();
				min = Math.min(min, sum);
			}
			return;
		}

		for (int i = 0; i < ROTATE_NUM; i++) {
			if(isSelected[i]) continue; 
			
			rightRotateArray(list[i].rs, list[i].re, list[i].cs, list[i].ce); 
			isSelected[i] = true;
			
			permutation(cnt+1); //arr초기화 상태
			leftRotateArray(list[i].rs, list[i].re, list[i].cs, list[i].ce);
			isSelected[i] = false;
		}
	}
}

class Permu {
	int rs;
	int re;
	int cs;
	int ce;
}