package sw_expert.sw_expert_1228;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {

	static int N,CMD;
	
	static List<String> srclist ;          

	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input/1228.txt"));
		Scanner sc = new Scanner(System.in);
		
        for(int t=1;t<=10;t++) {
        	srclist = new LinkedList<String>();  // 초기화 위치 주의한다.
        	N = sc.nextInt(); 
        	
        	for(int i=0;i<N;i++) {
        		srclist.add(sc.next());
        	}
    		
        	CMD = sc.nextInt(); 
        	sc.nextLine();
        	//명령문을 수행하여 원본을 수정한다. 지정한위치에 len개를 insert한다.
        	String msg = sc.nextLine();
        	StringTokenizer st = new StringTokenizer(msg,"I");
        	while(st.hasMoreTokens()) {
        		String data = st.nextToken();
        		StringTokenizer st1 = new StringTokenizer(data);
    			int index = Integer.parseInt(st1.nextToken());
    			int len = Integer.parseInt(st1.nextToken());
    			
    			ArrayList<String> subList = new ArrayList<>(len);
    			while(st1.hasMoreTokens()) {
					subList.add(st1.nextToken());
				}
        		srclist.addAll(index,subList);
        		
        	}
        	StringBuilder sb = new StringBuilder();
        	for(int i=0; i<10; i++) {
				sb.append(srclist.get(i)).append(" ");
			}

        	System.out.printf("#%d %s%n",t,sb.toString());
        }
	}
}

