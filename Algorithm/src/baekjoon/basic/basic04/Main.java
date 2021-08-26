package baekjoon.basic.basic04;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int num = 1;
		Stack<Integer> stack = new Stack<Integer>();
		
		
		int test_case = sc.nextInt();
		
		for(int i = 0; i < test_case; i++) {
			int value = sc.nextInt();
			if(value >= num) {
				for(int cnt = num; cnt <= value; cnt++) {
					stack.push(num);
					sb.append("+").append("\n");
					num++;
				}
			}
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-").append("\n");
			
		}
		System.out.println(sb.toString());
		
		sc.close();
		sc = null;
	}

}
