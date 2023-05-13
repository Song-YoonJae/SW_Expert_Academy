package org.example.D3.test1244;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static long max;
    static int chance;
    static String[] arr;
    public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(br.readLine());

        for(int t=0; t<c; t++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            arr = str.split("");
            chance = Integer.parseInt(st.nextToken());

            if(arr.length < chance) {	// swap 횟수가 자릿수보다 클 때
                chance = arr.length;	// 자릿수만큼만 옮겨도 전부 옮길 수 있음
            }

            max = 0;
            dfs(0, 0);

            sb.append("#" + (t+1) + " " + max + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int L, int start) {
        if(L == chance) {
            String answer = "";
            for(int i=0; i<arr.length; i++) {
                answer += arr[i];
            }
            max = Math.max(max, Long.parseLong(answer));
            return;
        }

        for(int i=start; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                dfs(L+1, start);
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
