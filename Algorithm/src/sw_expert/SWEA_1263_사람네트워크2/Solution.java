package sw_expert.SWEA_1263_사람네트워크2;

import java.util.*;
import java.io.*;
 
public class Solution {
    static final int INF = 9999999;
    static int[][] adjMatrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //테스트케이스 개수
         
        for(int tc=1;tc<=T;tc++) {
            int N = sc.nextInt(); // 사람 수
             
            //인접행렬
            adjMatrix = new int[N][N];
             
            //인접행렬 입력
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    adjMatrix[i][j] = sc.nextInt();
                     
                    //자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
                    if(i!=j && adjMatrix[i][j]==0) adjMatrix[i][j] = INF;
                }
            }
             
            for(int k=0;k<N;++k) {
                for(int i=0;i<N;++i) {
                    if(i==k) continue;
                    for(int j=0;j<N;++j) {
                        if(i==j || k==j) continue;
                        if(adjMatrix[i][j]>adjMatrix[i][k]+adjMatrix[k][j]) {
                            adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
                        }
                    }
                }
            }
             
            int min = Integer.MAX_VALUE;
             
            for(int i=0;i<N;i++) {
                int sum = 0;
                for(int j=0;j<N;j++) {
                    sum += adjMatrix[i][j];
                }
                min = Math.min(min, sum);
            }
             
            System.out.printf("#%d %d\n",tc,min);
        }
    }
}