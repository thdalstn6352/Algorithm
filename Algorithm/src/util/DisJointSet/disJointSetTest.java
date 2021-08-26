package util.DisJointSet;

import java.util.Arrays;

public class disJointSetTest {
	static int N;
	static int[] parents;
	
	private static void make() {
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int a) {
		if(parents[a] == a)
			return a;
		else
			return parents[a] = findSet(parents[a]);
	}
	
	private static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		N = 5;
		parents = new int[N];
		
		make();
		System.out.println(unionSet(0, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(unionSet(2, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(unionSet(3, 2));
		System.out.println(Arrays.toString(parents));
		System.out.println(unionSet(4, 3));
		System.out.println(Arrays.toString(parents));
		
		System.out.println("============find==============");
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents));
		
	}
}
