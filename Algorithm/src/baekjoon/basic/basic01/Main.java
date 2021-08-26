package baekjoon.basic.basic01;

import java.util.Scanner;

public class Main {

	public static int[] stack;
	public static int size;
	
	
	public void push(int num) {
		stack[size] = num;
		size++;
	}
	public int pop() {
		if(size == 0 || stack[size-1] == 0) {
			return -1;
		}
		else {
			int result = stack[size-1];
			stack[size-1] = 0;
			size--;
			return result;
		}
	}
	public int size() {
		return size;
	}
	
	public int empty() {
		if(size == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int top() {
		if(size == 0)
			return -1;
		else
			return stack[size-1];
	}
	
	public void Stack() {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int iter = sc.nextInt();
		stack = new int[iter];

		for(int i = 0; i < iter; i++) {
			String command = sc.next();
			
			switch(command) {
			case "push":
				int num = sc.nextInt();
				push(num);
				break;
			case "pop":
				sb.append(pop());
				sb.append("\n");
				break;
			case "size":
				sb.append(size());
				sb.append("\n");
				break;
			case "empty":
				sb.append(empty());
				sb.append("\n");
				break;
			case "top":
				sb.append(top());
				sb.append("\n");
				break;
			default:
				System.out.println("에러");
			}
		}
		System.out.println(sb);
		sc.close();
		sc = null;
	}
	
	public static void main(String[] args) {
		Main st = new Main();
		st.Stack();
	}
}
