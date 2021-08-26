package ThisIsCodingTest.dfsNbfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//최단거리 문제로 너비우선 BFS   탐색으로 푸는 대표적인 문제이다.  Queue 이용
public class P100_미로_BFS {

	static char[][] G;
	static int[][] V;
   	static int X,Y;
   	static int startX,startY,endX,endY;
   	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input/p100.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		G = new char[X][Y];
		V = new int[X][Y];
        for(int i=0;i<X;i++) {
        	String s = br.readLine();
            for(int j=0;j<Y;j++) {
            	G[i][j]=s.charAt(j);
            }
        }
        //print();
        for(int i=0;i<X;i++) {
            for(int j=0;j<Y;j++) {
            	if(G[i][j]=='S') {
            		startX=i;
            		startY=j;
            	}
            	if(G[i][j]=='G') {
            		endX=i;
            		endY=j;
            	}
            }
        }
        
       V[startX][startY] = 1; 
       bfs(startX, startY);
       System.out.println(V[endX][endY]-1);
       print(); 
       print2(); 
	}
	
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static void bfs(int x,int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
//			if(current[0]==endX && current[1]==endY) {
//				break;
//			}
			for(int i=0;i<4;i++) {
				int count = V[current[0]][current[1]];
				int newX = current[0]+dx[i];
				int newY = current[1]+dy[i];
				if(newX>=0&&newX<X&&newY>=0&&newY<Y&&G[newX][newY]!='#'&&V[newX][newY]==0) {
		             V[newX][newY] = count+1;
		             queue.offer(new int[] {newX,newY});
				}
			}
		}
	}
		
		
	
    static void print() {
    	for(int i=0;i<X;i++) {
        	  System.out.println(Arrays.toString(G[i]));
        }
    	System.out.println("----------------------------------");

    }
    static void print2() {
    	for(int i=0;i<X;i++) {
        	  System.out.println(Arrays.toString(V[i]));
        }
    	System.out.println("----------------------------------");

    }
}

/*
 * 
 * 5 5
#S###
#...#
#.#.#
#....
###G#



*/
