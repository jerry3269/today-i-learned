package chapter4;

public class problem14 {

    /**
     * 1. 모든 대문자를 소문자로 치환합니다.
     * 2. 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 문자를 제거합니다.
     * 3. 마침표가 두번 이상 연속된 부분을 하나의 마침표로 치환합니다.
     * 4. 마침표가 처음이나 끝에 위치한다면 제거합니다.
     * 5. 아이디가 빈 문자열이라면, `"a"` 를 넣습니다.
     * 6. 아이디가 16자 이상이라면 처음 15자를 제외한 문자를 제거합니다.
     *     1. 만약 제거후 마침표가 끝에 위치한다면 마침표 문자를 제거합니다.
     * 7. 길이가 2자 이하라면, 마지막 문자를 길이 3이 될때까지 반복하여 끝에 붙입니다.
     */
    class Solution {
        public String solution(String new_id) {
            new_id = new_id.toLowerCase();
            new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");
            new_id = new_id.replaceAll("\\.+", ".");
            new_id = new_id.replaceAll("^\\.+|\\.+$", "");
            if(new_id.isEmpty()) new_id = "a";
            if(new_id.length() > 15) {
                new_id = new_id.substring(0, 15);
                new_id = new_id.replaceAll("\\.+$", "");
            }
            while (new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
            return new_id;
        }
    }
}
