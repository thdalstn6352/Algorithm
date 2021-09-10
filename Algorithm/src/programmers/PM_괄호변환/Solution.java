package programmers.PM_괄호변환;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	public static String solution(String p) {
        String answer = "";
        
        // 올바른 괄호의 경우
        if(isCorrect(p))
        	return p;
        
        answer = fix(p);
        
        return answer;
    }
	public static String fix(String p) {
		// 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
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
        
        // 2. 문자열을 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
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
        
        // Queue -> String
		while(!Uqueue.isEmpty()){
			Usb.append(Uqueue.poll());
		}
	
		while(!Vqueue.isEmpty()){
			Vsb.append(Vqueue.poll());
		}
		
		String U = Usb.toString();
		String V = Vsb.toString();
		
		// 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
		if(isCorrect(U))
			return U + fix(V);
		
		// 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
		else {
			StringBuilder sb = new StringBuilder();
//			4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
//			4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
//			4-3. ')'를 다시 붙입니다.
			String str = "";
			str = "(" + fix(V) + ")";

//			4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
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
