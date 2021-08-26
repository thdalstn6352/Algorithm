package baekjoon.BOJ_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		//5로 나누어 떨어질 경우 가장 최솟값
		if(num % 5 == 0) {
			System.out.println(num/5);
			return;
		}
		
		//5와 3으로 만들 수 있는 수
		int size = num / 5;
		int value = 0;
		
		for(int i = size; i > 0; i--) {
			int cnt = 0;
			value = num - (i*5);
			
			if(value % 3 == 0) {
				cnt = i + (value / 3);
				System.out.println(cnt);
				return;
			}
		}
		
		//3으로만 만들 수 있는 수
		if(num % 3 == 0) {
			System.out.println(num / 3);
			
		}
		//모두 안될 경우
		else {
			System.out.println(-1);
		}
		return; 
	}
}
