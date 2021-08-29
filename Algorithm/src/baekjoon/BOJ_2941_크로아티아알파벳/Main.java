package baekjoon.BOJ_2941_크로아티아알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String msg = br.readLine();
		boolean[] check = new boolean[msg.length()];
		
		int count = 0;
		
		for(int i = 0; i < msg.length() - 1; i++) {
			if(check[i])
				continue;
			
			check[i] = true;
			if(msg.charAt(i) == 'l' || msg.charAt(i) == 'n') {
				if(msg.charAt(i+1) == 'j') {
					check[i+1] = true;
				}
			}
			
			else if(msg.charAt(i) == 'c' || msg.charAt(i) == 's' || msg.charAt(i) == 'z') {
				if(msg.charAt(i) == 'c') {
					 if(msg.charAt(i+1)== '-')
						 check[i+1] = true;
				}
				
				if(msg.charAt(i+1) == '=') {
					check[i+1] = true;
				}
			}
			else if(msg.charAt(i) == 'd'){
				if(msg.charAt(i+1) == '-')
					check[i+1] = true;
				else if(msg.charAt(i+1) == 'z') {
					if(i != (msg.length() - 2)) {
						if(msg.charAt(i+2) == '=') {
							check[i+1] = true;
							check[i+2] = true;
						}
					}
				}
			}
			count++;
		}
		if(!check[msg.length() - 1])
			count++;
		System.out.println(count);
	}
}
