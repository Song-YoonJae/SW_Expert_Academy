package org.example.D2.test1959;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input1959.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }


            int max = Integer.MIN_VALUE;

            if(N < M) {
                for (int i = 0; i < M - N + 1; i++) {
                    int num = 0;
                    for (int j = 0; j < N; j++) {
                        num += B[i + j] * A[j];
                    }

                    max = Math.max(max, num);
                }
            } else {
                for (int i = 0; i < N - M + 1; i++) {
                    int num = 0;
                    for (int j = 0; j < M; j++) {
                        num += A[i + j] * B[j];
                    }

                    max = Math.max(max, num);
                }
            }

            sb.append("#" + t + " " + max + "\n");

        }
        System.out.println(sb);
    }
}