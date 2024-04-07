package leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution_56 {
    public int[][] merge(int[][] intervals) {
        // interval의 end 값이 다른 interval의 start 값보다 크다면?
        // 두 interval 합치기
        // 근데 그 탐색을 어떻게 할거임?

        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        List<List<Integer>> result = new ArrayList<>();

        int idx = 0;
        int resIdx = 0;
        while (idx < intervals.length) {
            if (idx + 1 >= intervals.length) {
                result.add(List.of(intervals[idx][0], intervals[idx][1]));
                break;
            }

            int endNode = intervals[idx][1];
            int startNode = intervals[idx + 1][0];

            if (endNode >= startNode) {
                mergeIntervals(intervals[idx], intervals[idx + 1]);
                idx++;
            } else {
                result.add(List.of(intervals[idx][0], intervals[idx][1]));
                resIdx++;
                idx++;
            }
        }

        int[][] resultArray = new int[result.size()][2];

        int i = 0;
        for (List<Integer> r : result) {

            resultArray[i][0] = r.get(0);
            resultArray[i][1] = r.get(1);
            i++;
        }

        return resultArray;
    }

    private void mergeIntervals(int[] i1, int[] i2) {
        int newStartNode = i1[0];
        int newEndNode = Math.max(i1[1], i2[1]);

        i2[0] = newStartNode;
        i2[1] = newEndNode;
    }

}
