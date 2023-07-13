package org.example.D4.test7465;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static boolean[] visit;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input7465.txt"));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            visit = new boolean[N+1];
            list = new ArrayList[N+1];

            for(int i=1; i<=N; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            int answer = 0;
            for(int i=1; i<=N; i++){
                if(!visit[i]){
                    dfs(i);
                    answer++;
                }
            }

            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int n){
        visit[n] = true;

        for(int i : list[n]){
            if(!visit[i]){
                dfs(i);
            }
        }
    }
}
