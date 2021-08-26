package baekjoon.BOJ_1244;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int switch_num = sc.nextInt();
		
		int[] status = new int[switch_num];
		
		for(int i = 0; i < switch_num; i++) {
			status[i] = sc.nextInt();
		}
		
		int test_case = sc.nextInt();
		
		for(int j = 0; j < test_case; j++) {
			int sex = sc.nextInt();
			int num = sc.nextInt();
			
			if(sex == 1) {
				for(int x = num; x <= switch_num; x += num) {
					status[x - 1] = (status[x - 1] == 1) ? 0 : 1;
				}
			}
			else {
				int rep = (switch_num - num) > num - 1 ? num - 1 : (switch_num - num);

				for(int cnt = 1; cnt <= rep; cnt++) {
					if(status[num - 1 - cnt] == status[num - 1 + cnt]) {
						status[num - 1 - cnt] = (status[num - 1 - cnt] == 1) ? 0 : 1;
						status[num - 1 + cnt] = status[num - 1 - cnt];
						continue;
					}
					else
						break;
				}
				status[num - 1] = status[num - 1] == 1 ? 0 : 1;
			}
			
		}
		for(int cnt = 0; cnt < status.length; cnt++) {
			System.out.print(status[cnt] + " ");
			if((cnt + 1) % 20 == 0) 
				System.out.println();
		}

		sc.close();
		sc = null;
	}
}
