package chapter12.implement.dfs;

import java.util.Stack;

public class problem58_타켓_넘버 {
    public int solution(int[] numbers, int target) {
        int count = 0;
        Stack<State> stack = new Stack<>();
        stack.push(new State(0,0));

        while (!stack.isEmpty()) {
            State state = stack.pop();

            if (state.index == numbers.length) {
                if (state.sum == target) {
                    count++;
                }
                continue;
            }

            stack.push(new State(state.index + 1, state.sum - numbers[state.index]));
            stack.push(new State(state.index + 1, state.sum + numbers[state.index]));
        }
        return count;
    }

    class State {
        int index;
        int sum;

        public State(final int index, final int sum) {
            this.index = index;
            this.sum = sum;
        }
    }
}
