package chapter3.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class problem1 {
    public static String[] solution(int[][] line) {
        List<Point> points = findPointByOperation(line);

        Point maxPoint = getMaxPoint(points);
        Point minPoint = getMinPoint(points);

        char[][] arr = getArrayByMaxAndMinPoint(maxPoint, minPoint);

        displayPointInArray(points, minPoint, maxPoint, arr);

        String[] result = ArrayToStrings(arr);

        return result;
    }

    private static class Point{
        public final long x;
        public final long y;

        private Point(final long x, final long y){
            this.x = x;
            this.y = y;
        }

    }

    private static List<Point> findPointByOperation(int[][] line){
        List<Point> points = new ArrayList<>();
        for(int i = 0 ; i < line.length; i++){
            for(int j = i + 1; j < line.length; j++){
                Point intersection = getIntersection(line[i], line[j]);

                if(intersection != null){
                    points.add(intersection);
                }
            }
        }

        return points;
    }

    private static Point getIntersection(final int[] line1, final int[] line2){
        final int a1 = line1[0];
        final int b1 = line1[1];
        final int c1 = line1[2];
        final int a2 = line2[0];
        final int b2 = line2[1];
        final int c2 = line2[2];

        final double doubleX = (double) ((b1 * c2) - (c1 * b2)) / ((a1 * b2) - (b1 * a2));
        final double doubleY = (double) ((c1 * a2) - (a1 * c2)) / ((a1 * b2) - (b1 * a2));

        if(doubleX % 1 != 0 || doubleY % 1 != 0) return null;
        return new Point((long) doubleX, (long) doubleY);
    }

    private static Point getMaxPoint(List<Point> points){
        long maxX = points.stream().max(Comparator.comparing(point -> point.x)).get().x;
        long maxY = points.stream().max(Comparator.comparing(point -> point.y)).get().y;

        return new Point(maxX, maxY);
    }

    private static Point getMinPoint(List<Point> points){
        long minX = points.stream().min(Comparator.comparing(point -> point.x)).get().x;
        long minY = points.stream().min(Comparator.comparing(point -> point.y)).get().y;

        return new Point(minX, minY);
    }

    private static char[][] getArrayByMaxAndMinPoint(Point maxPoint, Point minPoint) {
        int width = (int)(maxPoint.x - minPoint.x + 1);
        int height = (int)(maxPoint.y - minPoint.y + 1);

        char[][] arr = new char[height][width];
        Arrays.stream(arr).forEach(chars -> Arrays.fill(chars, '.'));
        return arr;
    }
    private static void displayPointInArray(List<Point> points, Point minPoint, Point maxPoint, char[][] arr) {
        points.stream().forEach(point -> {
            int x = (int) (point.x - minPoint.x);
            int y = (int) (maxPoint.y - point.y);
            arr[y][x] = '*';
        });
    }
    private static String[] ArrayToStrings(char[][] arr) {
        String[] result = new String[arr.length];
        for(int i = 0 ; i< result.length; i++){
            result[i] = new String(arr[i]);
        }
        return result;
    }
}
