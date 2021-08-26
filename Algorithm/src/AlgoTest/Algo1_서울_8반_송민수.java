package AlgoTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Algo1_서울_8반_송민수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		List<Character> list = new ArrayList<>();
		list.add('a');
		list.add('e');
		list.add('i');
		list.add('o');
		list.add('u');
		
		String msg = br.readLine();
		
		for(int i = 0; i < msg.length(); i++) {
			if(list.contains(msg.charAt(i))) {
				sb.append(msg.charAt(i));
				i+=2;
				continue;
			}
			sb.append(msg.charAt(i));
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
