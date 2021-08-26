package baekjoon.BOJ_1074;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		String[] numbers = br.readLine().split(" ");
		N = Integer.parseInt(numbers[0]);
		int r = Integer.parseInt(numbers[1]);
		int c = Integer.parseInt(numbers[2]);
		
		int size = (int)Math.pow(2, N);
		searchAxis(size, r, c);
		System.out.println(cnt);
		
	}

	public static void searchAxis(int size,int row, int col) {
		int xAxis = size/2;
		int yAxis = size/2;
		
		if(size == 1)
			return;
		if(row < xAxis && col < yAxis) { // 1사분면
			searchAxis(size/2, row, col);
		}
		else if(row < xAxis && col >= yAxis) { // 2사분면
			cnt += (size / 2) * (size / 2) * 1; // 1사분면까지의 cnt수 더함
			searchAxis(size/2, row, col - yAxis);
		}
		else if(row >= xAxis && col < yAxis) { // 3사분면
			cnt += (size / 2) * (size / 2) * 2;
			searchAxis(size/2, row - xAxis, col);
		}
		else if(row >= xAxis && col >= yAxis) { // 4사분면
			cnt += (size / 2) * (size / 2) * 3;
			searchAxis(size/2, row - xAxis, col - yAxis);
		}
	}
}
