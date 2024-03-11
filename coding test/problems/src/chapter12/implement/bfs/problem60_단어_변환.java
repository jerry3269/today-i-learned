package chapter12.implement.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class problem60_단어_변환 {
    public int solution(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(0, begin));

        while (!queue.isEmpty()) {
            Word poll = queue.poll();

            //큐에서 객체의 값이 target과 같다면 해당 객체의 step을 반환
            if (poll.value.equals(target)) {
                return poll.step;
            }

            //모든 word를 순회함.
            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                //poll한 값에서 word로 변환이 가능하지 않다면 continue
                if (!isConvertible(poll.value, word)) {
                    continue;
                }

                //이미 사용된 word라면 continue
                if (isVisited[i]) {
                    continue;
                }
                
                //변환 가능하고 사용하지 않은 word일 경우
                isVisited[i] = true;
                queue.add(new Word(poll.step + 1, word));
            }
        }

        return 0;
    }

    //변환될수 있는 문자열인지 검사
    private boolean isConvertible(String a, String b) {
        int count = 0;
        String[] aSplit = a.split("");
        String[] bSplit = b.split("");

        for (int i = 0; i < aSplit.length; i++) {
            if(!aSplit[i].equals(bSplit[i])) count++;
        }

        return count == 1;
    }

    //현재 word의 값과 변환 횟수 저장용 객체
    class Word {
        int step;
        String value;

        public Word(final int step, final String value) {
            this.step = step;
            this.value = value;
        }
    }
}
