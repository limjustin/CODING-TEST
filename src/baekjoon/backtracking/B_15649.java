package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_15649 {
//    public static void main(String[] args) throws IOException {
//        long beforeTime = System.currentTimeMillis();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//
//        int n = Integer.parseInt(input[0]);
//        int m = Integer.parseInt(input[1]);
//
//        // List<Integer> numbers = new ArrayList<>();
//        int[] numbers = new int[8];
//        for (int i = 1; i <= n; i++) {
//            // numbers.add(i);
//            numbers[i - 1] = i;
//        }
//
//        Map<Integer, int[]> graph = new HashMap<>();
//        for (int i = 1; i <= n; i++) {
//            graph.put(i, numbers);
//        }
//
//        for (int i = 1; i <= n; i++) {
//            dfs(graph, new ArrayList<>(), m, i);
//        }
//
//        long afterTime = System.currentTimeMillis();
//        System.out.println("Time : " + (afterTime - beforeTime));
//    }
//
//    public static void dfs(Map<Integer, Map<Integer, int[]> graph, List<Integer> discovered, int m, int v) {
//        discovered.add(v);
//
//        if (discovered.size() == m)
//            printList(discovered);
//
//        for (Integer w : graph.get(v)) {
//            if (v == w)
//                continue;
//
//            if (!discovered.contains(w)) {
//                dfs(graph, discovered, m, w);  // 재귀로 리스트 그대로 안 받아오는게 핵심이었네
//                discovered.remove(discovered.size() - 1);
//            }
//        }
//    }
//
//    public static void printList(List<Integer> integers) {
//        for (Integer i : integers)
//            System.out.print(i + " ");
//        System.out.println();
//    }

    private static int n;
    private static int m;

    private static int[] sequence;
    private static boolean[] visited;

    // HashMap 그래프 만들어서 탐색하는 방식 : 시간 초과
    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        sequence = new int[8];
        visited = new boolean[8];

        for (int i = 1; i <= n; i++) {
            sequence[i] = i;
        }

        dfs(0);

        long afterTime = System.currentTimeMillis();
        System.out.println("Time : " + (afterTime - beforeTime));
    }

    public static void dfs(int cnt) {
        if (cnt == m) {
            for (int index = 0; index < m; index++) {
                System.out.print(sequence[index] + " ");
            }
            System.out.println();
        } else {
            for (int index = 1; index <= n; index++) {
                if (!visited[index]) {
                    visited[index] = true;
                    sequence[cnt] = index;
                    dfs(cnt + 1);
                    visited[index] = false;
                }
            }
        }
    }
}
