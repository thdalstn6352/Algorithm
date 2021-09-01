package programmers.PM_메뉴리뉴얼;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	static int size;
	static int R;
	static List<Character> list;
	static char[] menu;
	static MenuComb[] menuComb;
	static Map<String, Integer> map;
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		map = new HashMap<>();
		
		
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] courses = {2, 3, 4};
		
		menuComb = new MenuComb[courses.length];
		
		for(int i = 0; i < courses.length; i++) {
			R = courses[i];
			menu = new char[R];
			char[] order = orders[i].toCharArray();
			Arrays.sort(order);
			
			combination(0, 0, order);
			
		}
		
	}
	
	private static void combination(int cnt,int start, char[] order) {
		if(cnt == R) {
			if(map.get(menu.toString()) != null)

			
			return;
		}
		
		for (int i = start; i < size; i++) { // i : 인덱스
			menu[cnt] = order[i];
			combination(cnt+1, i+1, order);
		}
	
	}
}

class MenuComb {
	String msg;
	int cnt;
	
	public MenuComb(String msg, int cnt) {
		super();
		this.msg = msg;
		this.cnt = cnt;
	}
}
