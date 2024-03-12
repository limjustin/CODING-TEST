package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1065 {  // https://www.acmicpc.net/problem/1065
    public static void main(String[] args) throws IOException {
        // 한 자리수 (1 ~ 9) - 모두 한수
        // 두 자리수 (10 ~ 99) - 모두 한수
        // 세 자리수 (100 ~ 999)
        // 네 자리수 (1000)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = 99;

        if (num == 1000)
            num = num - 1;

        if (num < 100) {
            result = num;
        } else {
            for (int i = 100; i <= num; i++) {
                int h = i / 100;
                int t = (i / 10) % 10;
                int o = i % 10;

                if ((double) (h + o) / 2 == t) {
                    // System.out.println(h + " " + t + " " + o);
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
