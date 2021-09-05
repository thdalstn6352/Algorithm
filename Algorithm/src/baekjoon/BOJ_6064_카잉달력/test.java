package baekjoon.BOJ_6064_카잉달력;

public class test {
	public static void main(String[] args) {
		// 2*x % 8 = 1 // 8*y % 2 = 1
		
		int x = 1;
		
		while(true) {
			if((2 * x) % 8 == 1) {
				System.out.println(x);
				break;
			}
			x++;
		}
	}
}


// 8 2 4 2
//
//x = 4(mod 8)
//x = 2(mod 2)
//
