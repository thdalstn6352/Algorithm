package baekjoon.BOJ_2212_센서;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		String[] msg = br.readLine().split(" ");
		int[] sensor = new int[N];
		
		for(int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(msg[i]);
		}
		
		Arrays.sort(sensor);
		
		int[] sensorDiff = new int[N - 1];
		
		for(int j = 0; j < N - 1; j++) {
			sensorDiff[j] = sensor[j+1] - sensor[j];
		}
		
		Arrays.sort(sensorDiff);
		
		int answer = 0;
		
		for(int s = 0; s < N - K; s++) {
			answer += sensorDiff[s];
		}
		
		System.out.println(answer);
		
	}
}
