package sw_expert.sw_expert_1233;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
	static Queue<Integer> queue = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		
		int testCase = 10;
		int flag = 0;
		int isAvailable = 0;
		
		for(int tc = 1; tc <= testCase; tc++) {
			int nodeNum = Integer.parseInt(br.readLine());
			char[] arr = new char[nodeNum + 1];
			
			for(int c = 1; c <= nodeNum; c++) {
				String[] msg = br.readLine().split(" ");
				arr[Integer.parseInt(msg[0])] = msg[1].charAt(0);
			}
		}
	}
	
	public void bfs2() {		
		int current  = 0, level = 0, size = 0;
		
		while(!queue.isEmpty()) {
			size = queue.size();
			
			System.out.print("level" + level + ":");
//			while(--size >= 0) {
//				current = queue.poll();
//				System.out.print(nodes[current] + " ");
//				//왼쪽 자식이 있다면
//				if(current * 2 <= lastIndex) 
//					queue.offer(current*2);
//				//오른쪽 자식이 있다면
//				if(current * 2 + 1 <= lastIndex)
//					queue.offer(current * 2 + 1);
//			}
			System.out.println();
			++level;
			
		}
	}
}
