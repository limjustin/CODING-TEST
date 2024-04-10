package baekjoon.dynamic_programming;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        long res = 1;


        for (int i = 1; i <= N; i++) {
            res = res * M;
            M = M - 1;
        }

        for (int j = N; j >= 1; j--) {
            res = res / N;
            N = N - 1;
        }

        System.out.println(res);
    }
}
