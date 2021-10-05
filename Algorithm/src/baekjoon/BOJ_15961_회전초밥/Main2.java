package baekjoon.BOJ_15961_회전초밥;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
	static int N,d,k,c;
	static int redup, coupon;
	static int maxChobab;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] Ndkc = br.readLine().split(" ");
		N = Integer.parseInt(Ndkc[0]);
		d = Integer.parseInt(Ndkc[1]);
		k = Integer.parseInt(Ndkc[2]);
		c = Integer.parseInt(Ndkc[3]);
		
		int[] sushi = new int[N];
		visited = new int[d+1];
		
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		calcCnt(sushi);
		System.out.println(maxChobab);
	}
	
	private static void calcCnt(int[] sushi) {
		int total = 0;
		
		for(int i = 0; i < k; i++) {
			if(visited[sushi[i]] == 0)
				total++;
			visited[sushi[i]]++;
		}
		if(visited[c] == 0)
			maxChobab = Math.max(maxChobab, total+1);
		else
			maxChobab = Math.max(maxChobab, total);
		
		for(int idx = 0; idx < N-1; idx++) {
			visited[sushi[idx]]--;
			if(visited[sushi[idx]] == 0)
				total--;
			visited[sushi[(idx + k) % N]]++;
			if(visited[sushi[(idx + k) % N]] == 1)
				total++;
			
			if(visited[c] == 0)
				maxChobab = Math.max(maxChobab, total+1);
			else
				maxChobab = Math.max(maxChobab, total);
			
			if(maxChobab == k+1)
				return;
		}
	}
}
