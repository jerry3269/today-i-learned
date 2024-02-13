package chapter11.data_stucture.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class problem46_다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int time = 0;
        int truckIndex = 0;
        while (truckIndex < truck_weights.length) {
            bridgeWeight -= bridge.poll();

            int truckWeight = truck_weights[truckIndex];
            if (bridgeWeight + truckWeight <= weight) {
                bridge.add(truckWeight);
                bridgeWeight += truckWeight;
                truckIndex++;
            } else {
                bridge.add(0);
            }

            time++;
        }

        while (bridgeWeight > 0) {
            bridgeWeight -= bridge.poll();
            time++;
        }

        return time;
    }
}
