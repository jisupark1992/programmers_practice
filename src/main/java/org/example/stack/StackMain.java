package org.example.stack;

import org.example.array.*;

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
    }
}