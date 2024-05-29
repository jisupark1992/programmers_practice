package org.example.stack;

import java.util.Arrays;

public class StackMain {
    public static void main(String[] args) {
        System.out.println("--------------------스택 6_3_8 올바른 괄호 Start--------------------");
        String s = "(()())()";
        System.out.println("입력 값 : " + s + ", 결과 : " + 올바른_괄호.solution(s));
        s = ")()(";
        System.out.println("입력 값 : " + s + ", 결과 : " + 올바른_괄호.solution(s));
        System.out.println("--------------------스택 6_3_8 올바른 괄호 End--------------------");
        System.out.println("--------------------스택 6_3_9 10진수를 2진수로 변환하기 Start--------------------");
        int decimal = 123456789;
        System.out.println("입력 값 : " + decimal + ", 결과 : " + 진수_변환하기.solution(decimal));
        System.out.println("--------------------스택 6_3_9 10진수를 2진수로 변환하기 End--------------------");
        System.out.println("--------------------스택 6_4_10 괄호 회전하기 Start--------------------");
        s = "[](){}";
        System.out.println("입력 값 : " + s + ", 결과 : " + 괄호_회전하기.solution(s));
        s = "}]()[{";
        System.out.println("입력 값 : " + s + ", 결과 : " + 괄호_회전하기.solution(s));
        System.out.println("--------------------스택 6_4_10 괄호 회전하기 End--------------------");
        System.out.println("--------------------스택 6_4_11 짝지어 제거하기 Start--------------------");
        s = "baabaa";
        System.out.println("입력 값 : " + s + ", 결과 : " + 짝지어_제거하기.solution(s));
        System.out.println("--------------------스택 6_4_11 짝지어 제거하기 End--------------------");
        System.out.println("--------------------스택 6_4_12 주식 가격 Start--------------------");
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println("결과 : " + Arrays.toString(주식_가격.solution(prices)));
        System.out.println("--------------------스택 6_4_12 주식 가격 End--------------------");
    }
}