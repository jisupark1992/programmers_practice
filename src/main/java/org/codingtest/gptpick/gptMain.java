package org.codingtest.gptpick;


import java.util.Arrays;

public class gptMain {
    public static void main(String[] args) {

        int[] arr = {2, 7, 10, 15};
        int target = 17;
        System.out.println("결과 : " + Arrays.toString(gptOneDay.solution2(arr, target)));

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target2 = -1;
        System.out.println("결과 : " + gptTwoDay.solution(nums, target2));

        int num = 5;
        System.out.println("결과 : " + gpThreeDay.recursiveCall(num));
    }
}