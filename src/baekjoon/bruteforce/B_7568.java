package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 7568
 * https://www.acmicpc.net/problem/7568
 */

public class B_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> weights = new ArrayList<>();
        List<Integer> heights = new ArrayList<>();

        int[] ranks = new int[n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] s = line.split(" ");

            weights.add(Integer.parseInt(s[0]));
            heights.add(Integer.parseInt(s[1]));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 내가 덩치가 더 크면 그 친구들을 줄여야지
                if (weights.get(i) > weights.get(j) && heights.get(i) > heights.get(j))
                    ranks[j]++;

                if (weights.get(i) < weights.get(j) && heights.get(i) < heights.get(j))
                    ranks[i]++;
            }
        }

        for (int rank : ranks) {
            System.out.print((rank + 1) + " ");
        }
    }
}
