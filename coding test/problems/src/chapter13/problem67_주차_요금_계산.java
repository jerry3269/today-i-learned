package chapter13;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class problem67_주차_요금_계산 {

    public int[] solution(int[] fees, String[] records) {
        Map<String, Car> cars = new HashMap<>();

        Car car = null;
        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String number = split[1];
            String io = split[2];

            cars.putIfAbsent(number, new Car(number));
            car = cars.get(number);

            if (io.equals("IN")) {
                car.setInTime(time);

            } else {
                car.setOutTime(time);
                car.computeTime();
            }
        }

        cars.keySet().stream()
                .filter(c -> cars.get(c).outTime > 0)
                .forEach(c -> cars.get(c).computeTime());

        cars.keySet().stream()
                .forEach(c -> cars.get(c).computeFee(fees[0], fees[1], fees[2], fees[3]));

        return cars.values().stream()
                .sorted(Comparator.comparingInt(value -> Integer.parseInt(value.number)))
                .mapToInt(value -> value.totalFee)
                .toArray();
    }

    class Car{
        String number;
        int outTime;
        int inTime;
        int totalTime;
        int totalFee;

        public Car(final String number) {
            this.number = number;
            totalTime = 0;
            totalFee = 0;
        }

        public void setInTime(final String inTimeString) {
            this.inTime = parseTime(inTimeString);
            this.outTime = 23 * 60 + 59;
        }

        public void setOutTime(final String outTimeString) {
            this.outTime = parseTime(outTimeString);
        }

        public void computeTime() {
            if (inTime >= 0 && inTime < outTime) {
                totalTime += outTime - inTime;
                outTime = -1;
                inTime = -1;
            }
        }

        public void computeFee(int baseTime, int baseFee, int unitTime, int unitFee) {
            if (totalTime > baseTime) {
                double v = Math.ceil(((double)totalTime - baseTime)/ unitTime);
                this.totalFee = baseFee + (int) v * unitFee;
            } else if (totalTime > 0) {
                this.totalFee = baseFee;
            }
        }

        private int parseTime(String string) {
            int hour = Integer.parseInt(string.substring(0, 2));
            int minute = Integer.parseInt(string.substring(3));
            return hour * 60 + minute;
        }
    }
}
