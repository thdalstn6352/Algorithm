package baekjoon.BOJ_1244_스위치켜고끄기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		int[] switches = new int[T];
		
		String[] msg = br.readLine().split(" ");
		
		for(int i = 0; i < T; i++) {
			switches[i] = Integer.parseInt(msg[i]);
		}
		
		int studentNum = Integer.parseInt(br.readLine());
		for(int s = 0; s < studentNum; s++) {
			String[] info = br.readLine().split(" ");
			int sex = Integer.parseInt(info[0]);
			int value = Integer.parseInt(info[1]);
		
			if(sex == 1) {
				for(int idx = value; idx <= T; idx+=value) {
					switches[idx-1] = (switches[idx-1] + 1) % 2;
				}
			}
			
			else {
				int size = Math.min(T - value, value - 1);
				switches[value - 1] = (switches[value - 1] + 1) % 2;
				
				for(int i = 1; i <= size; i++) {
					if(switches[value - 1 - i] == switches[value - 1 + i]) {
						switches[value - 1 - i] = (switches[value - 1 - i] + 1) % 2;
						switches[value - 1 + i] = (switches[value - 1 + i] + 1) % 2;
					}
					else
						break;
				}
			}
		}
		for(int cnt = 0; cnt < switches.length; cnt++) {
			System.out.print(switches[cnt] + " ");
			if((cnt + 1) % 20 == 0) 
				System.out.println();
		}
		
//		for(int i = 0; i < T; i++) {
//			sb.append(switches[i]);
//			if(i != T - 1)
//				sb.append(" ");
//		}
//		bw.write(sb.toString().trim());
//		bw.flush();
//		
//		bw.close();
//		br.close();
//		
//		bw = null;
//		br = null;
		
	}
}
