package chapter11.data_stucture.stack_queue;

import java.util.Stack;

public class problem43_괄호_회전하기 {
    public static void main(String[] args) {
        System.out.println(solution("[]{}()"));
    }

    public static int solution(String s) {
        int answer = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            boolean isRight = 올바른_괄호_인가(charArray);
            if(isRight) answer++;
            charArray = leftShift(charArray);
        }

        return answer;
    }

    private static boolean 올바른_괄호_인가(char[] charArray) {
        Stack<Character> stack = new Stack<>();
        for (Character c : charArray) {
            if(c == '(') stack.push(')');
            if(c == '{') stack.push('}');
            if(c == '[') stack.push(']');
            if (c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty()) return false;
                if(stack.pop() != c) return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }

    private static char[] leftShift(char[] charArray) {
        char[] array = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            array[i] = charArray[(i + 1) % charArray.length];
        }
        return array;
    }
}
