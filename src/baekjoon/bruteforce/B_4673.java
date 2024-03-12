package baekjoon.bruteforce;

import java.io.IOException;

public class B_4673 {  // https://www.acmicpc.net/problem/4673
    public static void main(String[] args) {
        boolean[] result = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            // System.out.println("i = " + i);

            int num = i;
            int addNum = 0;

            while (num > 0) {
                // System.out.println("num % 10 = " + num % 10);
                addNum = addNum + (num % 10);
                num = num / 10;
            }

            // System.out.println("i + addNum = " + (i + addNum));
            if ((i + addNum) > 10000)
                continue;

            result[(i + addNum)] = true;
        }

        for (int i = 1; i <= 10000; i++) {
            if (!result[i])
                System.out.println(i);
        }
    }
}
