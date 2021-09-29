package baekjoon.BOJ_1701_Cubeditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		
		String text = br.readLine();
		
		while(text.length() >= 2) {
			char[] textArr = text.toCharArray();
			int tLength = text.length();
			int[] pi = new int[tLength];
			
			for(int i = 1, j = 0; i < tLength; i++){
		        while(j > 0 && textArr[i] != textArr[j]) {
		        	j = pi[j-1];  
		        }
		        if(textArr[i] == textArr[j]) 
		        	pi[i] = ++j;
		    }
			

			Arrays.sort(pi);
			max = Math.max(max, pi[tLength - 1]);
			
			text = text.substring(1);
		}
		System.out.println(max);
	}
}
