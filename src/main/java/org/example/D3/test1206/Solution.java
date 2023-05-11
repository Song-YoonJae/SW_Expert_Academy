package org.example.D3.test1206;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int t=0; t<10; t++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            for(int i=2; i<n-2; i++){
                int max = Math.max(arr[i - 2], Math.max(arr[i - 1], Math.max(arr[i + 1], arr[i + 2])));
                if (arr[i] - max > 0) // 좌 우 건물 높이의 최댓값보다 현재 건물의 높이가 높으면
                    answer += arr[i] - max;
            }
            sb.append("#" + (t+1) + " " + answer + "\n");
        }
        System.out.println(sb);
    }
}
