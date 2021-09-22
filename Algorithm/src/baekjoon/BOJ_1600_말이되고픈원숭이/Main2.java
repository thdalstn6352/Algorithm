package baekjoon.BOJ_1600_말이되고픈원숭이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
   static int[] dx = {0,0,1,-1, 2,2,-2,-2, 1,1,-1,-1};
   static int[] dy = {1,-1,0,0, 1,-1,1,-1, 2,-2,2,-2};
   static int[] dj = {0,0,0,0, 1,1,1,1, 1,1,1,1};
   
   static class Monkey{
      int x;
      int y;
      int jumpCnt;
      int time;
      public Monkey(int x, int y, int jumpCnt, int time) {
         super();
         this.x = x;
         this.y = y;
         this.jumpCnt = jumpCnt;
         this.time = time;
      }
      
   }
   
   static int K;
   static int X;
   static int Y;
   static int map[][];
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      K = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine(), " ");
      Y = Integer.parseInt(st.nextToken());
      X = Integer.parseInt(st.nextToken());
      map = new int[X][Y];
      
      for(int i = 0; i< X; i++) {
         st = new StringTokenizer(br.readLine(), " ");
         for(int j = 0; j< Y; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }// get map
      
      int res = bfs();
      System.out.println(res);
      br.close();
   }
   static private int bfs() {
      Queue<Monkey> Q= new LinkedList<>();
      boolean[][][] visit = new boolean[X][Y][K+1];
      
      Q.add(new Monkey(0,0,0,0));
      visit[0][0][0] = true;
      int basic = 0;
      
      while(!Q.isEmpty()) {
         Monkey curr = Q.poll();
         if(curr.x == X - 1 && curr.y == Y - 1)
        	 return curr.time;
         
         basic = 4;
         
         if(curr.jumpCnt < K)
        	 basic = 12;
         
         for(int i =0; i < basic; i++) {
            int nx = curr.x + dx[i];
            int ny = curr.y + dy[i];
            int nk = curr.jumpCnt + dj[i];
            if(nx < 0 || nx >= X || ny < 0 || ny >=Y || map[nx][ny] == 1|| visit[nx][ny][nk])
            	continue;
            
            visit[nx][ny][nk]=true;
            Q.add(new Monkey(nx,ny,nk,curr.time+1));
         }
            
      }
         
      return -1;
   }
}