package programmers.PM_괄호변환;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	public static String solution(String p) {
        String answer = "";
        
        if(isCorrect(p))
        	return p;
        answer = fix(p);
        
        return answer;
    }
	public static String fix(String p) {
		if(p.equals("")) {
			return "";
		}
		
		Queue<Character> Uqueue = new LinkedList<>();
        Queue<Character> Vqueue = new LinkedList<>();
        
        StringBuilder Usb = new StringBuilder();
        StringBuilder Vsb = new StringBuilder();
        
        int length = p.length();
        int close = 0;
        int open = 0;
        int flag = 0;
        
        for(int i = 0; i < length; i++) {
        	char val = p.charAt(i);
        	if(val == '(')
        		open++;
        	else
        		close++;
        	if(flag == 0)
        		Uqueue.offer(val);
        	else
        		Vqueue.offer(val);
        	
        	if(open == close) {
        		flag = 1;
        	}
        }
        
		while(!Uqueue.isEmpty()){
			Usb.append(Uqueue.poll());
		}
	
		while(!Vqueue.isEmpty()){
			Vsb.append(Vqueue.poll());
		}
		
		String U = Usb.toString();
		String V = Vsb.toString();
		
		if(isCorrect(U))
			return U + fix(V);
		else {
			StringBuilder sb = new StringBuilder();
			
			String str = "";
			str = "(" + fix(V) + ")";

			for(int i = 1; i < U.length() - 1; i++) {
				if(U.charAt(i) == '(')
					sb.append(')');
				else
					sb.append("(");
			}
			
			return str + sb.toString();
		}
	}
	
	public static boolean isCorrect(String s) {
		Stack<Character> stack = new Stack<>();
		int length = s.length();
		
		for(int i = 0; i < length; i++) {
        	char val = s.charAt(i);
        	
        	if(val == '(') 
        		stack.push(val);
        	else {
        		if(!stack.isEmpty())
        			stack.pop();
        		else 
        			return false;
        	}
        }
        if(!stack.isEmpty())
        	return false;
        return true;
	}

	public static void main(String[] args) {
		System.out.println(solution("()))((()"));
	}
}
