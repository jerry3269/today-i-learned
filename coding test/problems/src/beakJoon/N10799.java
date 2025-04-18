package beakJoon;

import java.util.Scanner;

class N10799 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        char[] charArray = string.toCharArray();
        int openCount = 1;

        int result = 0;

        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i - 1] == '(' && charArray[i] == ')') {
                openCount--;
                result += openCount;
            } else if (charArray[i - 1] == ')' && charArray[i] == ')') {
                openCount--;
                result++;
            } else {
                openCount++;
            }
        }

        System.out.println(result);
    }
}
