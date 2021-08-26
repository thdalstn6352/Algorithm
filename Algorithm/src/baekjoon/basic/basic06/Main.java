package baekjoon.basic.basic06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int test_case = Integer.parseInt(br.readLine());
		
		
		for(int tc = 0; tc < test_case; tc++) {
			String[] string = br.readLine().split(" ");
			String method = string[0];
			if(method.equals("push")) {
				int num = Integer.parseInt(string[1]);
				push(num);
			}
			
			if(method.equals("pop")) pop();
			if(method.equals("size")) size();
			if(method.equals("empty")) empty();
			if(method.equals("front")) front();
			if(method.equals("back")) back();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	public static void push(int num) {
		list.add(num);
	}
	
	public static void pop() {
		if(list.size() == 0) {
			sb.append("-1").append("\n");
		}
		else {
			sb.append(list.get(0)).append("\n");
			list.remove(0);
		}
		
	}
	
	public static void size() {
		sb.append(list.size()).append("\n");
	}
	
	public static void empty() {
		if(list.size() == 0)
			sb.append("1").append("\n");
		else
			sb.append("0").append("\n");
	}
	
	public static void front() {
		if(list.size() == 0)
			sb.append("-1").append("\n");
		else
			sb.append(list.get(0)).append("\n");
	}
	
	public static void back() {
		if(list.size() == 0)
			sb.append("-1").append("\n");
		else
			sb.append(list.get(list.size() - 1)).append("\n");
	}
}
