package beakJoon;

import java.util.*;

class N6550 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            char[] first = sc.next().toCharArray();
            char[] second = sc.next().toCharArray();
            int index = getEqualsCount(second, first);

            if(index == first.length){
                System.out.println("Yes");
            } else{
                System.out.println("No");
            }
        }
    }

    private static int getEqualsCount(final char[] second, final char[] first) {
        int index = 0;

        for (char c : second) {
            if(index == first.length){
                break;
            }
            if(first[index] == c){
                index++;
            }
        }
        return index;
    }
}
