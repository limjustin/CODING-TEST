package leetcode.greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < people.length - 1; i++) {
//            for (int j = i; j < people.length - 1; j++) {
//
//            }


        }

        return people;
    }

    private void swap2DArr(int[][] people, int a, int b) {
        int tempFirst = people[a][0];
        people[a][0] = people[b][0];
        people[b][0] = tempFirst;

        int tempSecond = people[a][1];
        people[a][1] = people[b][1];
        people[b][1] = tempSecond;
    }
}
