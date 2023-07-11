package org.example.D2.test1961;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input1961.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int[][] arr90 = new int[N][N];
            int[][] arr180 = new int[N][N];
            int[][] arr270 = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr90[i][j] = arr[N-1-j][i];
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr180[i][j] = arr90[N-1-j][i];
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr270[i][j] = arr180[N-1-j][i];
                }
            }

            sb.append("#" + t + "\n");

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    sb.append(arr90[i][j]);
                }
                sb.append(" ");
                for(int j=0; j<N; j++){
                    sb.append(arr180[i][j]);
                }
                sb.append(" ");
                for(int j=0; j<N; j++){
                    sb.append(arr270[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
