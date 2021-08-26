package baekjoon.basic.basic02;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		sc.nextLine();
		
		for(int c = 0; c < cnt; c++) {
			StringTokenizer stk = new StringTokenizer(sc.nextLine(), " ");
			while(stk.hasMoreTokens()) {
				char[] msg = stk.nextToken().toCharArray();
				for(int i = 0; i < msg.length / 2; i++) {
					char temp = msg[i];
					msg[i] = msg[msg.length - 1 - i];
					msg[msg.length - 1 - i] = temp; 
				}
				System.out.print(String.valueOf(msg) + " ");
			}
		}
		
		sc.close();
	}
	
}
