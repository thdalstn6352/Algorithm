package baekjoon.BOJ_2527_직사각형;

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
		
		for(int tc = 1; tc <= 4; tc++) {
			String[] rectangles = br.readLine().split(" ");
			int x1 = Integer.parseInt(rectangles[0]);
			int y1 = Integer.parseInt(rectangles[1]);
			int p1 = Integer.parseInt(rectangles[2]);
			int q1 = Integer.parseInt(rectangles[3]);
			
			int x2 = Integer.parseInt(rectangles[4]);
			int y2 = Integer.parseInt(rectangles[5]);
			int p2 = Integer.parseInt(rectangles[6]);
			int q2 = Integer.parseInt(rectangles[7]);

			if((p1 == x2 && q1 == y2) || (p2 == x1 && y2 == q1) || (p2 == x1 && q2 == y1) || (p1 == x2 && q2 == y1))
				System.out.println("c");
			else if((p1 == x2 && q1 != y2) || (p2 == x1 && y2 != q1) || (p2 != x1 && q2 == y1) || (p1 != x2 && q1 == y2)) {
				if((q1 < y2 || q2 < y1) || (p2 < x1 || p1 < x2))
					System.out.println("d");
				else
					System.out.println("b");
			}
			else if(p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1)
				System.out.println("d");
			else
				System.out.println("a");
			
		}
	}
}
