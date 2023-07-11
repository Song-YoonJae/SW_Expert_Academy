package org.example.D2.test12712;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new FileReader("input12712.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max;
            int answer = Integer.MIN_VALUE;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    max = Math.max(calculate1(i, j), calculate2(i, j));
                    answer = Math.max(answer, max+arr[i][j]);
                }
            }

            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    public static int calculate1(int x, int y){
        int sum = 0;

        for(int i=1; i<M; i++) {
            if(x-i >= 0)
                sum += arr[x - i][y];
            if(y+i < N)
                sum += arr[x][y + i];
            if(x+i < N)
                sum += arr[x + i][y];
            if(y-i >= 0)
                sum += arr[x][y - i];
        }

        return sum;
    }

    public static int calculate2(int x, int y){
        int sum = 0;

        for(int i=1; i<M; i++){
            if(x-i >= 0 && y-i >= 0)
                sum += arr[x-i][y-i];
            if(x-i >= 0 && y+i < N)
                sum += arr[x-i][y+i];
            if(x+i < N && y+i < N)
                sum += arr[x+i][y+i];
            if(x+i < N && y-i >= 0)
                sum += arr[x+i][y-i];
        }

        return sum;
    }
}