package baekjoon.BOJ_14501_퇴사;

import java.util.Scanner;

public class Main2 {
	static int N;
	static Day[] day;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		day = new Day[N];
		
		for(int i = 0; i < N; i++) {
			day[i] = new Day(sc.nextInt(), sc.nextInt());
		}
		
		for(int i = 0; i < N; i++) {
			if(i + day[i].T <= N) {
				combination(i + day[i].T, day[i].P);
			}
		}
		
		System.out.println(max);
		sc.close();
		sc = null;
	}
	
	private static void combination(int start, int sum) {
		
		for(int i = start; i < N; i++) {
			if(i + day[i].T <= N) {
				sum += day[i].P;
				combination(i + day[i].T, sum);
				sum -= day[i].P;
			}
		}
		max = Math.max(max, sum);
	}
}


class Day {
	int T;
	int P;

	public Day(int t, int p) {
		super();
		T = t;
		P = p;
	}
	
}