package org.example.D2.test1204;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input1204.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashMap<Integer, Integer> map;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            map = new HashMap<>();
            int number = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<1000; i++){
                int num = Integer.parseInt(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<Integer> list = new ArrayList<>();
            int maxValue = Collections.max(map.values());
            for(Map.Entry<Integer, Integer> m : map.entrySet()) {
                if(m.getValue() == maxValue) {
                    list.add(m.getKey());
                }
            }

            list.sort(Collections.reverseOrder());

            sb.append("#" + t + " " + list.get(0) + "\n");
        }

        System.out.println(sb);
    }
}
