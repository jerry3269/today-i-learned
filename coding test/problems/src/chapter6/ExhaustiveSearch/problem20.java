package chapter6.ExhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

public class problem20 {

    public static void main(String[] args) {
        long answer = solution("100+6*6-1+15*6*1-16*6*6-1-1-1");
        System.out.println(answer);
    }

    static List<String[]> precedences = new ArrayList<>();

    public static long solution(String expression) {

        precedences.add(new String[]{"+", "-", "*"});
        precedences.add(new String[]{"+", "*", "-"});
        precedences.add(new String[]{"-", "+", "*"});
        precedences.add(new String[]{"-", "*", "+"});
        precedences.add(new String[]{"*", "+", "-"});
        precedences.add(new String[]{"*", "-", "+"});
        List<String> tokens = getTokens(expression);
        long max = 0;

        for (String[] precedence : precedences) {
            long result = calculate(new ArrayList<>(tokens), precedence);
            if (result < 0) {
                result *= -1;
            }

            if (result > max) {
                max = result;
            }
        }

        return max;
    }

    private static long calcultate(long left, long right, String op) {
        if(op.equals("+")) return left + right;
        if(op.equals("-")) return left - right;
        if(op.equals("*")) return left * right;
        return 0;
    }

    private static long calculate(List<String> tokens, String[] precedence) {
        for (String op : precedence) {
            for (int index = 0; index < tokens.size(); index++) {

                if (tokens.get(index).equals(op)) {
                    long result = calcultate(
                            Long.parseLong(tokens.get(index - 1)),
                            Long.parseLong(tokens.get(index + 1)),
                            op
                    );

                    tokens.remove(index-1);
                    tokens.remove(index-1);
                    tokens.remove(index-1);
                    tokens.add(index - 1, String.valueOf(result));
                    index -= 2;
                }
            }
        }

        return Long.parseLong(tokens.get(0));
    }

    private static List<String> getTokens(String expression) {
        List<String> tokens = new ArrayList<>();
        int beginIndex = 0;
        char[] charArray = expression.toCharArray();
        for (int index = 0; index < charArray.length; index++) {
            if (charArray[index] == '+' || charArray[index] == '-' || charArray[index] == '*') {
                tokens.add(expression.substring(beginIndex, index));
                tokens.add(String.valueOf(charArray[index]));
                beginIndex = index + 1;
            }
        }
        tokens.add(expression.substring(beginIndex));
        return tokens;
    }
}
