package jungol.JO_1681_해밀턴순환회로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
   public static void main(String[] args) throws Exception {
      delivery d = new delivery();
      d.start();
   }
}

class delivery {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
     
    int N, map[][], per_num[], answer;
    boolean selected[];
     
    void get_data() throws Exception {
        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
         
        map = new int[N][N];
        per_num = new int[N];
        selected = new boolean[N];
         
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
     
    void permut(int count, int sum) {      //방문지점 순열
        if (count == N) {
            sum += map[per_num[N - 1]][0];
            if (sum < answer) answer = sum;
            return;
        }
        for (int i = 1; i < N; i++) {
            if (selected[i]) continue;
            if (answer <= sum + map[per_num[count - 1]][i]) continue;      //도중에 가중치가 answer보다 더 커지면 패스
            per_num[count] = i;
            sum += map[per_num[count - 1]][i];
            selected[i] = true;
            permut(count + 1, sum);
            sum -= map[per_num[count - 1]][i];
            selected[i] = false;
        }
    }
     
    void fw() {      //플로이드 워샬 정렬
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                for (int k = 0; k < N; k++) {
                    if (i == k || j == k) continue;
                    if (map[j][i] == 0 || map[i][k] == 0) continue;
                    if (map[j][k] == 0) map[j][k] = map[j][i] + map[i][k];
                    else map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }
    }
     
    boolean check() {      // 완전그래프인지 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)continue;
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }
     
    void start() throws Exception {
        get_data();
        fw();
        if (check()) permut(1, 0);
        else answer = 0;
         
        System.out.println(answer);
    }
}