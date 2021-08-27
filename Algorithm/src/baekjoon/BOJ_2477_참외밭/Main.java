package baekjoon.BOJ_2477_참외밭;

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
	
		int T = Integer.parseInt(br.readLine());
		int[] numArr = new int[5];
		Point[] pointArr = new Point[6];
		int maxIndex = 0;
		int max = 0;
		
		int subX = 0;
		int subY = 0;
		int flag = 0;
		
		for(int t = 0; t < 6; t++) {
			String[] nums = br.readLine().split(" ");
			int dir = Integer.parseInt(nums[0]);
			int value = Integer.parseInt(nums[1]);
			if(max < value) {
				maxIndex = t;
				max = value;
			}
			pointArr[t] = new Point(dir, value);
		}
		
		for(int t = maxIndex; t < maxIndex + 6; t++) {
			int index = pointArr[t % 6].dir;
			int value = pointArr[t % 6].value;
			
			if(numArr[index] != 0) {
				if(flag == 1)
					subY = numArr[index];
				else {
					subX = value;
					flag = 1;
				}
			}
			else
				numArr[index] = value;
		}
		
		int Area = (Math.max(numArr[1], numArr[2]) * Math.max(numArr[3], numArr[4])) - (subX * subY);
		int res = Area * T;
		
		sb.append(res);
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}

}

class Point {
	int dir;
	int value;
	
	public Point(int dir, int value) {
		super();
		this.dir = dir;
		this.value = value;
	}
}