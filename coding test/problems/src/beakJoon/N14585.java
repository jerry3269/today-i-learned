package beakJoon;

import java.util.*;

public class N14585 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String encode = sc.nextLine();
        int wordCount = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리

        List<String> dictionary = new ArrayList<>();

        for(int i = 0; i < wordCount; i++){
            dictionary.add(sc.nextLine());
        }

        for (int shift = 0; shift < 26; shift++) {
            String decode = shiftText(encode, shift);
            for (String d : dictionary) {
                if (decode.contains(d)) {
                    System.out.println(decode);
                    return;
                }
            }
        }
    }

    private static String shiftText(final String encode, final int shift) {
        StringBuilder sb = new StringBuilder();

        for (char c : encode.toCharArray()) {
            char newChar = ((c - shift) < 'a') ? (char)(((c - 'a' - shift + 26) % 26) + 'a') : (char)(c - shift);
            sb.append(newChar);
        }
        return sb.toString();
    }
}
