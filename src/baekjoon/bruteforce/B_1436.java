package baekjoon.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/1436
public class B_1436 {

    public static void main(String[] args) throws IOException {
        // 666 1666 2666 3666 4666 5666 6660 6661 6662 .. 6669 7666 10666 11666 12666 65666 60666 36663
        // 첫번째 생각 : 반복문 돌리기 -> 시간 초과 발생할 가능성 너무 큼
        int num = 666;
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < 3000000; i++) {
            String numStr = Integer.toString(num);
            // boolean contains = numStr.contains("666");
            // System.out.println("contains = " + contains);
            if (Integer.toString(num).contains("666"))
                results.add(num);
            num++;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        System.out.println(results.get(i - 1));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(results.get(i - 1));
    }
}