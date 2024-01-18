package chapter5;

import java.util.ArrayList;
import java.util.List;

public class problem17 {

    public static void main(String[] args) {
        int aeoiu = solution("AEOIU");
    }
    private static final List<Character> LIST = new ArrayList<>();

    public static int solution(String word) {
        LIST.add('A');
        LIST.add('E');
        LIST.add('I');
        LIST.add('O');
        LIST.add('U');

        List<String> words = new ArrayList<>();
        generateWords("", words);
        int answer = words.indexOf(word);
        return answer;
    }

    private static void generateWords(String word, List<String> words) {
        words.add(word);

        if(word.length() == 5) return;
        for (char c : LIST) {
            generateWords(word + c, words);
        }
    }
}
