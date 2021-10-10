package baekjoon.BOJ_3584_가장가까운조상;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			parents = new int[N+1];
			make();
			
			for(int i = 0; i < N-1; i++) {
				String[] infos = br.readLine().split(" ");
				parents[Integer.parseInt(infos[1])] = Integer.parseInt(infos[0]);
			}
			
			String[] target = br.readLine().split(" ");
			
			int num1 = Integer.parseInt(target[0]);
			int num2 = Integer.parseInt(target[1]);
			
			sb.append(lca(num1, getDepth(num1), num2, getDepth(num2))).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		
	}
	
	private static void make() {
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a];
	}
	
	private static int lca(int a, int depthA, int b, int depthB) {
		if(depthA > depthB) {
			while(depthA != depthB) {
				a = find(a);
				depthA--;
			}
		}
		else if(depthA < depthB) {
			while(depthA != depthB) {
				b = find(b);
				depthB--;
			}
		}
		
		while(a != b) {
			a = find(a);
			b = find(b);
		}

		return a;
	}
	
	private static int getDepth(int a) {
		int depth = 0;
		
		while(true) {
			if(a == parents[a])
				break;
			depth++;
			a = find(a);
		}
		
		return depth;
	}
}
