package baekjoon.BOJ_1946_신입사원;

import java.util.*;
import java.io.*;

public class Main2 {
	static int T, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{
			N = Integer.parseInt(br.readLine());
			int[] rank = new int[N+1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				rank[a] = b;
			}

			int count = 0;
			int last = 1;
			for (int i = 1; i <= N; i++) {
				if (rank[last] >= rank[i]) {
					last = i;
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
