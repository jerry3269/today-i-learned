package chapter12.implement;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. skill 순서에 포함되지 않는 문자 제거
 * 2. 제거된 문자열이 skill 순서의 prefix인지 검사하여 갯수 계산
 */
public class problem56_스킬_트리 {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        List<String> stringList = new ArrayList<>();

        //skill 순서에 포함되지 않는 문자 제거
        for (String skillTree : skill_trees) {
            String[] split = skillTree.split("");
            StringBuilder stringBuilder = new StringBuilder();

            for (String s : split) {
                if (skill.contains(s)) {
                    stringBuilder.append(s);
                }
            }

            stringList.add(stringBuilder.toString());
        }

        //제거된 문자열이 skill 순서의 prefix인지 검사하여 갯수 계산
        for (String s : stringList) {
            if (skill.startsWith(s)) {
                count++;
            }
        }

        return count;
    }
}
