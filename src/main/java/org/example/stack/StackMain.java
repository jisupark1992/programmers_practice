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
    }
}