package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int result = 0;

        // input : int N, String[] words
        for (String word : words) {
            boolean[] visited = new boolean[26];
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 97;
                if (!visited[idx]) {
                    if (i == word.length() - 1) {
                        result += 1;
                        break;
                    }

                    if (word.charAt(i) != word.charAt(i + 1))
                        visited[idx] = true;

                } else {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
