package chapter11.data_stucture.stack_queue;

import java.util.Stack;

public class problem42_올바른_괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if(c == '(') stack.push(c);
            if (c == ')') {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
