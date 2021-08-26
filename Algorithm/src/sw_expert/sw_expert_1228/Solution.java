package sw_expert.sw_expert_1228;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		List<String> list = new LinkedList<String>();
		List<String> list2 = new LinkedList<String>();
		List<String> insertList;

		int testCase = 1;
		for(int tc = 1; tc <= testCase; tc++) {
			int passwordNum = Integer.parseInt(br.readLine());
			String[] passwords = br.readLine().split(" ");
			for(String password : passwords) {
				list.add(password);
			}
			
			int commandNum = Integer.parseInt(br.readLine());
			//listArray = new ArrayList<>();
			
			String[] commands = br.readLine().split("I");
			
			for(String command : commands) {
				String[] comm = command.trim().split(" ");
				System.out.printf("명령어 길이는: %d%n",comm.length);
				for(int i = 0; i < comm.length; i++) {
					System.out.println(comm[i]);
				}

				System.out.println("========");
				

			}
			
			//System.out.println(listArray);
			
		}
		
	}
}
