package baekjoon.basic.basic07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Integer> list = new ArrayList<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		for(int i = 1; i <= N; i++)
			list.add(i);
		sb.append("<");
		removePerson(0, K);
		sb.append(">");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
	
	public static void removePerson(int index, int K) {
		if(list.size() == 1) {
			sb.append(list.get(0));
			return;
		}
		int remove_index = (index + K - 1) % list.size();
		sb.append(list.get(remove_index)).append(",").append(" ");
		list.remove(remove_index);
		removePerson(remove_index, K);
	}
}
