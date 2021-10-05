package baekjoon.BOJ_15961_회전초밥;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N,d,k,c;
	static int redup, coupon;
	static Queue<Integer> queue = new LinkedList<>();
	static int maxChobab;
	
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
		boolean flag = false;
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			
			if(!flag) {
				if(queue.contains(sushi[i])) 
					redup++;
				
				else if(sushi[i] == c)
					coupon++;
				
				queue.add(sushi[i]);
			}
			
			if(queue.size() == k) {
				flag = true;
				maxChobab = k + 1 - redup - coupon;
	
			}
		}
//		System.out.println(queue);
//		System.out.println(maxChobab);
		calcCnt(sushi);
		System.out.println(maxChobab);
	}
	
	private static void calcCnt(int[] sushi) {

		for(int idx = 0; idx < N-1; idx++) {
			int prevValue = queue.poll();
			int nextValue = sushi[(idx + k) % N];
			if(prevValue == c)
				coupon--;
			else if(queue.contains(prevValue))
				redup--;
			
			if(queue.contains(nextValue)) 
				redup++;
			
			else if(nextValue == c)
				coupon++;
			
			queue.add(nextValue);
//			System.out.println(queue);
//			System.out.println(k + 1 - redup - coupon);
			maxChobab = Math.max(maxChobab, k + 1 - redup - coupon);
			if(maxChobab == k+1)
				return;
		}
	}
}
