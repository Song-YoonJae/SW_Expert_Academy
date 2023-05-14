package org.example.D3.test1209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input1209.txt"));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=10; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            for(int i=0; i<100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i=0; i<100; i++) {
                int sum1 = 0;
                int sum2 = 0;
                for(int j=0; j<100; j++) {
                    sum1 += arr[i][j];
                    sum2 += arr[j][i];
                }
                max = Math.max(sum1, sum2);
                answer = Math.max(answer, max);
            }

            int sum1 = 0;
            int sum2 = 0;
            for(int i=0; i<100; i++) {
                sum1 += arr[i][i];
                sum2 += arr[i][99-i];
            }
            max = Math.max(sum1, sum2);
            answer = Math.max(answer, max);

            sb.append("#" + n + " " + answer + "\n");
        }
        System.out.println(sb);
    }
}
