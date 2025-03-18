package beakJoon;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class N2295 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> sum = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                sum.add(arr[i] + arr[j]);
            }
        }

        List<Integer> list = sum.stream().sorted().collect(Collectors.toList());
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(Collections.binarySearch(list, arr[i] - arr[j]) >= 0) {
                    max = Math.max(max, arr[i]);
                }
            }
        }
        bw.write(max + "\n");
        bw.flush();
    }
}
