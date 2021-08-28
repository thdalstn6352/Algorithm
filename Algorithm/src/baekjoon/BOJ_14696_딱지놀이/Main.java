package baekjoon.BOJ_14696_딱지놀이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int[] personA;
		int[] personB;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= N; tc++) {
			String[] Ainfo = br.readLine().split(" ");
			String[] Binfo = br.readLine().split(" ");
			personA = new int[5];
			personB = new int[5];
			
			for(int a = 1; a <= Integer.parseInt(Ainfo[0]); a++) {
				personA[Integer.parseInt(Ainfo[a])]++; 				
			}

			for(int b = 1; b <= Integer.parseInt(Binfo[0]); b++) {
				personB[Integer.parseInt(Binfo[b])]++; 				
			}
			
			if(personA[4] > personB[4]) {
				sb.append("A").append("\n");
			}
			else if(personA[4] < personB[4]) {
				sb.append("B").append("\n");
			}
			else {
				if(personA[3] > personB[3]) {
					sb.append("A").append("\n");
				}
				else if(personA[3] < personB[3]) {
					sb.append("B").append("\n");
				}
				else {
					if(personA[2] > personB[2]) {
						sb.append("A").append("\n");
					}
					else if(personA[2] < personB[2]) {
						sb.append("B").append("\n");
					}
					else {
						if(personA[1] > personB[1]) {
							sb.append("A").append("\n");
						}
						else if(personA[1] < personB[1]) {
							sb.append("B").append("\n");
						}
						else {
							sb.append("D").append("\n");
						}
					}
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
}
