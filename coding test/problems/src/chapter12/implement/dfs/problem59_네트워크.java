package chapter12.implement.dfs;

import java.util.Stack;

public class problem59_네트워크 {
    public int solution(int n, int[][] computers) {
        boolean[] isVisited = new boolean[n];
        int count = 0;

        //1~n번 컴퓨터를 순회한다.
        for (int i = 0; i < n; i++) {
            //이미 연결된 컴퓨터라면 continue한다.
            if(isVisited[i]) continue;

            //연결되지 않은 컴퓨터일 경우
            //해당 컴퓨터에 연결된 모든 컴퓨터를 방문하고 isVisited를 true로 설정한다.
            visitedAll(i, computers, isVisited);
            //연결된 모든 컴퓨터를 방문처리 했으므로 하나의 네트워크가 형성된다. 따라서 네트워크 count를 1증가시킨다.
            count++;
        }

        return count;
    }

    //i번 컴퓨터와 연결된 모든 컴퓨터 방문 표시
    private void visitedAll(final int i, final int[][] computers, final boolean[] isVisited) {
        Stack<Integer> stack = new Stack<>();
        //i번 컴퓨터를 stack에 넣는다.
        stack.push(i);

        while (!stack.isEmpty()) {
            int pop = stack.pop();

            if(isVisited[pop]) continue;
            isVisited[pop] = true;

            for (int j = 0; j < computers[pop].length; j++) {
                if (computers[pop][j] == 0) continue;
                stack.push(j);
            }
        }
    }
}
