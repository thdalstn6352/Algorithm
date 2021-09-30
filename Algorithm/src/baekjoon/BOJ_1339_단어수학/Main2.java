package baekjoon.BOJ_1339_단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String text = br.readLine();
			for(int j = 0; j < text.length(); j++) {
				char key = text.charAt(j);
				
				if(map.get(key) == null) {
					map.put(key, (int)Math.pow(10, text.length() - j - 1));
				}
				else {
					map.put(key, map.get(key) +  (int)Math.pow(10, text.length() - j - 1));
				}
			}
		}
		
		List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		int sum = 0;
		int value = 9;
		for(Map.Entry<Character, Integer> entry : entryList){
			sum += entry.getValue() * value;
			value--;
		}
		System.out.println(sum);

	}
}
