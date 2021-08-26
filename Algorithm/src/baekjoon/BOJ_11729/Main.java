package baekjoon.BOJ_11729;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int flag = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num_disks = Integer.parseInt(br.readLine());
		
		BigInteger b = new BigInteger("2"); 
		BigInteger res = b.pow(num_disks).subtract(BigInteger.ONE);      
		System.out.println(res);
		
		
		if(num_disks <= 20)
			hanoi(num_disks, 1, 3);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	public static void hanoi(int num_disks, int target, int destination){
		System.out.printf("%d hanoi(%d, %d, %d)%n",flag, num_disks, target, destination);
		int temp = 6 - target - destination;
		if(num_disks == 0)
			return;
		hanoi(num_disks - 1, target, temp);
		System.out.printf("%d move(%d, %d, %d)%n", flag, num_disks, target, destination);
		move(target, destination);
		hanoi(num_disks - 1, temp, destination);
		flag++;
	}
	
	public static void move(int target, int destination){
		sb.append(target);
		sb.append(" ");
		sb.append(destination);
		sb.append("\n");		
	}
}
