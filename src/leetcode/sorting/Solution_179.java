package leetcode.sorting;

import java.util.*;

public class Solution_179 {
    public String largestNumber(int[] nums) {
        // 숫자를 쪼개서 자리수까지 비교
        // 맨 앞자리만 비교하기
        // 앞자리를 어떻게 나타내지?
        // 32423 이런거 ->
        // int 배열을 string 배열로 바꿀까

        List<String> numbers = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            numbers.add(String.valueOf(nums[i]));
        }

        Collections.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("o1, o2 = " + o1 + ", " + o2);
                int i1 = Integer.parseInt(o1 + o2);  // 1113111113
                int i2 = Integer.parseInt(o2 + o1);  // 1113111311

                // 3 50

                if (i1 > i2) {
                    System.out.println(o1 + " " + o2);
                    System.out.println("o1.compareTo(o2) = " + o1.compareTo(o2));
                    if (Integer.parseInt(o1) < Integer.parseInt(o2))
                        return o1.compareTo(o2); // 그냥 순차 정렬
                    else
                        return o2.compareTo(o1);  // 반환을 어떻게가 중요  // complete
                } else {
                    System.out.println(o2 + " " + o1);
                    System.out.println("o2.compareTo(o1) = " + o2.compareTo(o1));
                    if (Integer.parseInt(o1) > Integer.parseInt(o2))
                        return o1.compareTo(o2);  // complete
                    else
                        return o2.compareTo(o1);
                }
            }
        });

        String res = "";
        for (String s : numbers) {
            System.out.print(s + " ");
            res += s;
        }

        return res;
    }
}
