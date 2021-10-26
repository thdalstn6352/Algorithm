package baekjoon.BOJ_2567_용액;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] numbers = br.readLine().split(" ");
        int[] nums = new int[N];

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }

        int min = Integer.MAX_VALUE;
        Liquids liquids = null;

        OUTER:for(int i = 0; i < N; i++) {
            int start = i + 1;
            int end = N - 1;
            while(start <= end) {
                int mid = (start + end) / 2;
                int sum = nums[i] + nums[mid];

                if(min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    liquids = new Liquids(nums[i], nums[mid]);
                    if(Math.abs(sum) == 0)
                        break OUTER;
                }
                if(sum < 0) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }

        sb.append(liquids.liquid1).append(" ").append(liquids.liquid2);
        bw.write(sb.toString());
        bw.flush();

    }
}

class Liquids {
    int liquid1;
    int liquid2;

    public Liquids(int liquid1, int liquid2) {
        this.liquid1 = liquid1;
        this.liquid2 = liquid2;
    }
}