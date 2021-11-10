package baekjoon.BOJ_2565_전깃줄;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Wire> wireList = new ArrayList<Wire>();
        int[] dp = new int[N];
        int max = 0;

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            wireList.add(new Wire(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
        //시작하는 전깃줄을 기준으로 정렬
        Collections.sort(wireList);

        //LIS 알고리즘
        for(int i = 0; i < N; i++) {
            //모든 dp배열 1로 초기화
            dp[i] = 1;
            //현재 전깃줄 이전의 모든 전깃줄과 비교
            for(int j = 0; j < i; j++) {
                if(wireList.get(j).start < wireList.get(i).start && wireList.get(j).end < wireList.get(i).end) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(N - max);
    }
}
class Wire implements Comparable<Wire>{
    int start;
    int end;

    public Wire(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Wire o) {
        return this.start - o.start;
    }

    @Override
    public String toString() {
        return "Wire{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}