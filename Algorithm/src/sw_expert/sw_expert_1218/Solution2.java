package sw_expert.sw_expert_1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution2 {
	
	static Stack<Character> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Map<Character, Character> bm = new HashMap<>();
	    bm.put('(', ')');
	    bm.put('[', ']');
	    bm.put('{', '}');
	    bm.put('<', '>');
	    
	    for (int i = 1; i <= 10; i++) {
	        Stack<Character> bs = new Stack<>();
	        int result = 1;
	        br.readLine();
	        for (char s : br.readLine().toCharArray()) {
	            if (s == '{' || s == '[' || s == '(' || s == '<') {
	                bs.push(s);
	                continue;
	            }
	            if (bs.isEmpty() || bm.get(bs.pop()) != s) {
	                result = 0;
	                break;
	            }
	        }
	        System.out.printf("#%d %d\n", i, result);
	    }
	}
}
