package ThisIsCodingTest.dfsNbfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P97_두더지굴_BFS_vertex {

	static int[][] G;
   	static int N;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input/p77.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		G = new int[N][N];
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
            	int x = Integer.parseInt(st.nextToken());
            	G[i][j]=x;
            }
        }
		
        
        
        //print();
        System.out.println("---------------------------");
          int cnt = 0;
          for (int i = 0; i <N; i++) {
          	for (int j = 0; j < N; j++) {
          		if(G[i][j]==1) {
          			cnt++;
          			bfs(i,j,cnt+1);
          		}
          	}
          }
          int[] size = new int[cnt]; 
          for (int i = 0; i <N; i++) {
            	for (int j = 0; j < N; j++) {
                   if(G[i][j]>1)size[G[i][j]-2]++;
            	}
          }
          Arrays.sort(size);
          //System.out.println(Arrays.toString(size));
          for(int i = size.length-1;i>=0;i--) {
        	  System.out.println(size[i]);
          }
          print();
	}
	
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};

	static void bfs(int x,int y,int no) {
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.offer(new Vertex(x, y));

		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			G[current.x][current.y]=no;
			
			for(int i=0;i<4;++i) {
				int newx =current.x+dx[i];
				int newy =current.y+dy[i];
				
				if(newx >= 0 && newx < N && newy >= 0 && newy <N && G[newx][newy]==1) {
					G[newx][newy] = no;
					queue.offer(new Vertex(newx, newy));
				}
			}
		}
		
		
	}
    static void print() {
    	for(int i=0;i<N;i++) {
        	  System.out.println(Arrays.toString(G[i]));
        }
    	System.out.println("----------------------------------");

    }
    static class Vertex{
    	int x;
    	int y;
		public Vertex(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Vertex [x=" + x + ", y=" + y + "]";
		}
    }
}

/*
 * 7
0 1 1 0 1 0 0
0 1 1 0 1 0 1
1 1 1 0 1 0 1
0 0 0 0 1 1 1
0 1 0 0 0 0 0
0 1 1 1 1 1 0
0 1 1 1 0 0 0
*/
