package baekjoon.BOJ_13300;

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
		
		Class[] classes = new Class[6];
		
		for(int i = 0; i < 6; i++) {
			classes[i] = new Class();
		}
		String[] infos = br.readLine().split(" ");
		
		int N = Integer.parseInt(infos[0]);
		int K = Integer.parseInt(infos[1]);
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			String[] people = br.readLine().split(" ");
			int sex = Integer.parseInt(people[0]);
			int grade = Integer.parseInt(people[1]);
			
			if(sex == 0) 
				classes[grade -1].woman++;
			
			else 
				classes[grade -1].man++;
		}

		for(int i = 0; i < 6; i++) {
			Class ban = classes[i];
			
			if(ban.woman % K == 0) {
				count += ban.woman / K;
			}
			else {
				if(ban.woman != 0) {
					count += ban.woman / K + 1;
				}
			}
			
			if(ban.man % K == 0) {
				count += ban.man / K;
			}
			else {
				if(ban.man != 0) {
					count += ban.man / K + 1;
				}
			}
		}
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
}

class Class {
	int woman;
	int man;
	
	@Override
	public String toString() {
		return "Class [woman=" + woman + ", man=" + man + "]";
	}
	
	
	
}
