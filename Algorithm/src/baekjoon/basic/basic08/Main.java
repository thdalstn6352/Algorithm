package baekjoon.basic.basic08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		int command = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < command; i++) {
			String comm = br.readLine();
			if(comm.contains("push")) {
				String[] push = comm.split(" ");
				if(comm.contains("front"))
					push_front(Integer.parseInt(push[1]));
				else
					push_back(Integer.parseInt(push[1]));
			}
			else if(comm.contains("pop")) {
				if(comm.contains("front"))
					sb.append(pop_front()).append("\n");
				else
					sb.append(pop_back()).append("\n");
			}
			else if(comm.equals("size"))
				sb.append(size()).append("\n");
			else if(comm.equals("empty"))
				sb.append(empty()).append("\n");
			else if(comm.equals("front"))
				sb.append(front()).append("\n");
			else if(comm.equals("back"))
				sb.append(back()).append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	public static void push_front(int num) {
		list.add(0, num);
	}
	public static void push_back(int num) {
		list.add(num);
	}
	public static int pop_front() {
		if(empty() == 1) {
			return -1;
		}
		int num = list.get(0);
		list.remove(0);
		return num;
	}
	public static int pop_back() {
		if(empty() == 1) {
			return -1;
		}
		int num = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return num;
	}
	public static int size() {
		return list.size();
	}
	public static int empty() {
		if(size() == 0)
			return 1;
		return 0;
	}
	public static int front() {
		if(empty() == 1)
			return -1;
		return list.get(0);
	}
	public static int back() {
		if(empty() == 1)
			return -1;
		return list.get(list.size() - 1);
	}
}
