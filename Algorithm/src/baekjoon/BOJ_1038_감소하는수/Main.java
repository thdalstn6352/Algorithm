package baekjoon.BOJ_1038_감소하는수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static List<Long> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());		
		list = new ArrayList<Long>();
		
		for (int i = 0; i < 10; i++) {
			calc(i);
		}
		
		Collections.sort(list);
		int size = list.size();
		
		if(N >= size) 
			System.out.println(-1);
		else
			System.out.println(list.get(N));
	}
	
	public static void calc(long num) {
		list.add(num);
		
		for (int idx = 0; idx < 10; idx++) {
			if (num % 10 > idx) {
				calc((num * 10) + idx);
			}
			else
				break;
		}
	}
}
