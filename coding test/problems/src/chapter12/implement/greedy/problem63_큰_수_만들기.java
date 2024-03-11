package chapter12.implement.greedy;

import java.util.Stack;
import java.util.stream.Collectors;

public class problem63_큰_수_만들기 {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = number.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            while (!stack.isEmpty() && stack.peek() < charArray[i] && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(charArray[i]);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
