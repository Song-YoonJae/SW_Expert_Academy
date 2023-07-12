package org.example.D2.test1974;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input1974.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            answer = 1;
            map = new int[9][9];

            for(int i=0; i<9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            check();

            sb.append("#" + t + " " + answer + "\n");
        }

        System.out.println(sb);
    }

    public static void check(){
        List<Integer> list;

        for(int i=0; i<9; i++){
            list = new ArrayList<>();
            for(int j=0; j<9; j++){
                if(list.contains(map[i][j])){
                    answer = 0;
                    return;
                }
                else
                    list.add(map[i][j]);
            }
        }

        for(int i=0; i<9; i++){
            list = new ArrayList<>();
            for(int j=0; j<9; j++){
                if(list.contains(map[j][i])){
                    answer = 0;
                    return;
                }
                else
                    list.add(map[j][i]);
            }
        }

        for(int k=0; k<9; k+=3) {
            list = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                if(i % 3 == 0){
                    list = new ArrayList<>();
                }
                for (int j = 0; j < 3; j++) {
                    if (list.contains(map[i][k+j])) {
                        answer = 0;
                        return;
                    } else
                        list.add(map[i][k+j]);
                }
            }
        }
    }
}
