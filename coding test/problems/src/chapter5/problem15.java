package chapter5;

import java.util.*;
import java.util.stream.Collectors;


public class problem15 {

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };

        int[] ints = quadTree(arr);
        System.out.println("0의 개수 : " + ints[0]);
        System.out.println("1의 개수 : " + ints[1]);
    }


    public static int[] solution(int[][] arr) {
        return quadTree(arr);
    }

    /* 상태 구현 */
    private static int[] quadTree(int[][] arr){
        /* 종료 조건 구현 */
        int first = arr[0][0];
        boolean state = true;   //true: 배열이 모두 같은 숫자, false: 모두 같은 숫자가 아님

        for(int[] column : arr){
            Set<Integer> columnSet = Arrays.stream(column).boxed().collect(Collectors.toSet());
            
            if(columnSet.size() != 1) {   //하나의 행이 모두 같은 숫자가 아닐 경우 나가리
                state = false;
                break;
            }

            if (!columnSet.contains(first)) { //해당 행이 모두 같은 수 이지만 first를 포함하지 않는 순간 나가리
                state = false;
                break;
            }
        }

        if (state) {
            if(first == 0) return new int[]{1, 0};
            if(first == 1) return new int[]{0, 1};
        }

        /* 점화식 구현 */
        int length = arr.length;
        int half = length/2;

        int[][] subArr1 = new int[half][half];
        int[][] subArr2 = new int[half][half];
        int[][] subArr3 = new int[half][half];
        int[][] subArr4 = new int[half][half];

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if(i < half && j < half) subArr1[i][j] = arr[i][j];
                if(i < half && j >= half) subArr2[i][j-half] = arr[i][j];
                if(i >= half && j < half) subArr3[i-half][j] = arr[i][j];
                if(i >= half && j >= half) subArr4[i-half][j-half] = arr[i][j];
            }
        }

        int[] result1 = quadTree(subArr1);
        int[] result2 = quadTree(subArr2);
        int[] result3 = quadTree(subArr3);
        int[] result4 = quadTree(subArr4);

        return new int[]{
                result1[0] + result2[0] + result3[0] + result4[0],
                result1[1] + result2[1] + result3[1] + result4[1]
        };
    }
}
