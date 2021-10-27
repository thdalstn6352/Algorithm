package baekjoon.BOJ_13335_트럭;

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
	
		String[] infos = br.readLine().split(" ");
		
		int n = Integer.parseInt(infos[0]);
		int w = Integer.parseInt(infos[1]);
		int L = Integer.parseInt(infos[2]);
		
		int[] trucks = new int[n];
		
		String[] truckInfo = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			trucks[i] = Integer.parseInt(truckInfo[i]);
		}
		
		
	}
	
}
