package org.example.D3.test1240;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input1240.txt"));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] pw = new int[8];
            for(int i=0; i<N; i++) {
                String str = br.readLine();
                for(int j=M-1; j>=0; j--) {
                    if(str.charAt(j) == '1') {
                        int index = 0;
                        for(int k=j-55; k<=j; k+=7) {
                            pw[index++] = convertCode(str.substring(k, k+7)); //2진수 형태를 10진수로 변환
                        }
                        break;
                    }
                }
            }

            int sum1 = 0;
            int sum2 = 0;
            for(int i=0; i<8; i++) {
                if(i%2==0) {
                    sum1 += pw[i];
                }
                else
                    sum2 += pw[i];
            }

            if((sum1*3 + sum2) % 10 == 0)
                sb.append("#" + t + " " + (sum1+sum2) + "\n");
            else
                sb.append("#" + t + " " + 0 + "\n");
        }
        System.out.println(sb);
    }

    public static int convertCode(String str) {
        switch(str) {
            case "0001101" :
                return 0;
            case "0011001" :
                return 1;
            case "0010011" :
                return 2;
            case "0111101" :
                return 3;
            case "0100011" :
                return 4;
            case "0110001" :
                return 5;
            case "0101111" :
                return 6;
            case "0111011" :
                return 7;
            case "0110111" :
                return 8;
            case "0001011" :
                return 9;
        }
        return -1;
    }
}
