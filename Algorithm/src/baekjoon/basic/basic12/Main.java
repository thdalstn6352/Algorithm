package baekjoon.basic.basic12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> sequence = new Stack<Integer>();
		Stack<Integer> save = new Stack<Integer>();
		Stack<Integer> result = new Stack<Integer>();
		
		int size = Integer.parseInt(br.readLine());
		String[] string = br.readLine().split(" ");
		
		for(String s : string) {
			int key = Integer.parseInt(s);
			sequence.push(key);
			if(map.containsKey(key))
				map.replace(key, map.get(key) + 1);
			else
				map.put(key, 1);
		}
		while(!sequence.isEmpty()) {
			int num = map.get(sequence.peek());
			
			if(save.isEmpty()) {
				save.push(sequence.pop());
				result.push(-1);
				continue;
			}
			
			if(num < map.get(save.peek())) {
				result.push(save.peek());
				save.push(sequence.pop());
			}
			else {
				save.pop();
			}
		}
		while(!result.isEmpty())
			sb.append(result.pop()).append(" ");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
		
	}
	
}
