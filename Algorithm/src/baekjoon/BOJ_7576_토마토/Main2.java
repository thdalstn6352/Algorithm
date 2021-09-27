package baekjoon.BOJ_7576_토마토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
   public static void main(String[] args) throws Exception {
      tomato t = new tomato();
      t.start();
   }
}

class tomato {
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st = null;
   
   int N, M, zero, map[][], answer, drow[] = {1, -1, 0, 0}, dcol[] = {0, 0, 1, -1};
   LinkedList<node> one = new LinkedList<node>();
   
   void get_data() throws Exception {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      
      map = new int[N][M];
      zero = 0;
      answer = 0;
      
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < M; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
            if (map[i][j] == 0) zero++;
            else if (map[i][j] == 1) one.add(new node(i, j, 0));
         }
      }
   }
   
//   boolean check(int r, int c) {
//	  
////      if (r < 0 || c < 0 || r >= N || c >= M || map[r][c] != 0) return false;
////      return true;
//   }
   
   void bfs() {
      if (zero == 0) return;
      Queue<node> queue = new LinkedList<node>();
      
      for (int i = 0; i < one.size(); i++) {
    	 node n = one.get(i);
         queue.offer(n);
      }
      
      while (!queue.isEmpty()) {
         node n = queue.poll();
         int count = n.count;
         for (int i = 0; i < 4; i++) {
            int r = n.row + drow[i];
            int c = n.col + dcol[i];
            if (r >= 0 && r < N && c >= 0 && c < M && map[r][c] == 0) {
               queue.offer(new node(r, c, count + 1));
               map[r][c] = 1;
               zero--;
            }
         }
         answer = n.count;
      }
      if (zero != 0) answer = -1;
   }
   
   void start() throws Exception {
      get_data();
      bfs();
      System.out.println(answer);
   }
   
}

class node {
   int row, col, count;

   public node(int row, int col, int count) {
      super();
      this.row = row;
      this.col = col;
      this.count = count;
   }
}