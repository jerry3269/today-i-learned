package chapter12.implement;

import java.util.HashMap;
import java.util.Map;

/*
 * 1. 키패드 숫자의 위치를 2차원 그래프의 좌표값(Point)으로 나타낸다.
 * 2. 오른손과 왼손의 엄지의 좌표값을 저장하기 위한 객체(Hand)를 생성한다.
 * 3. number를 순회하며 Hand를 이동시키며 키패드를 누른다.
 * */
public class problem57_키패드_누르기 {

    public static void main(String[] args) {
        solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
    }
    private static Map<Integer, Point> keyPad = new HashMap<>();


    public static String solution(int[] numbers, String hand) {
        // 1. 키패드 숫자의 위치를 2차원 그래프의 좌표값(Point)으로 나타낸다.
        keyPad.put(0, new Point(3, 1));
        keyPad.put(1, new Point(0, 0));
        keyPad.put(2, new Point(0, 1));
        keyPad.put(3, new Point(0, 2));
        keyPad.put(4, new Point(1, 0));
        keyPad.put(5, new Point(1, 1));
        keyPad.put(6, new Point(1, 2));
        keyPad.put(7, new Point(2, 0));
        keyPad.put(8, new Point(2, 1));
        keyPad.put(9, new Point(2, 2));

        StringBuilder stringBuilder = new StringBuilder();

        //2. 오른손과 왼손의 엄지의 좌표값을 저장하기 위한 객체(Hand)를 생성한다.
        Hand rightFinger = new Hand(Type.right, 3, 2);
        Hand leftFinger = new Hand(Type.left, 3, 0);

        //3. number를 순회하며 Hand를 이동시키며 키패드를 누른다.
        for (int number : numbers) {
            // 1,4,7일 경우 왼손으로 누른다.
            if (number == 1 || number == 4 || number == 7) {
                leftFinger.press(number);
                stringBuilder.append("L");
                continue;
            }
            // 3,6,9일 경우 오른손으로 누른다.
            if (number == 3 || number == 6 || number == 9) {
                rightFinger.press(number);
                stringBuilder.append("R");
                continue;
            }

            // 0,2,5,8일 경우 거리를 계산한다.
            int leftFingerDistance = leftFinger.getDistance(number);
            int rightFingerDistance = rightFinger.getDistance(number);

            // 왼손이 더 가까운 경우 왼손으로 누른다.
            if (leftFingerDistance < rightFingerDistance) {
                leftFinger.press(number);
                stringBuilder.append("L");
                continue;
            }
            // 오른손이 더 가까운 경우 오른손으로 누른다.
            if (rightFingerDistance < leftFingerDistance) {
                rightFinger.press(number);
                stringBuilder.append("R");
                continue;
            }

            //거리가 같을 경우
            // 왼손잡이일 경우 왼손으로 누른다.
            if (leftFinger.type.toString().equals(hand)) {
                leftFinger.press(number);
                stringBuilder.append("L");
                continue;
            }
            // 오른손잡이일 경우 오른손으로 누른다.
            if (rightFinger.type.toString().equals(hand)) {
                rightFinger.press(number);
                stringBuilder.append("R");
                continue;
            }

        }
        return stringBuilder.toString();
    }

    static class Point {
        int x;
        int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Hand {
        Type type;
        int x;
        int y;

        public Hand(final Type type, final int x, final int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public int getDistance(int number) {
            Point point = keyPad.get(number);
            return Math.abs(point.x - this.x) + Math.abs(point.y - this.y);
        }

        public void press(int number) {
            Point point = keyPad.get(number);
            this.x = point.x;
            this.y = point.y;
        }
    }

    enum Type{
        right, left
    }
}
