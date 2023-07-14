package org.example.D4.test1249;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int min;
    static boolean[][] visit;
    static int[][] map;
    static int[][] ans;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input1249.txt"));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            visit = new boolean[N][N];
            map = new int[N][N];

            for(int i=0; i<N; i++){
                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            min = Integer.MAX_VALUE;
            ans = new int[N][N];
            for(int i=0; i<N; i++)
                Arrays.fill(ans[i], Integer.MAX_VALUE);
            ans[0][0] = 0;

            bfs(0, 0);

            sb.append("#" + t + " " + min + "\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(x,y));
        visit[x][y] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            int a = p.x;
            int b = p.y;

            if(a == N-1 && b == N-1)
                min = Math.min(min, ans[N-1][N-1]);

            if(min <= ans[a][b])
                continue;
            for(int i=0; i<4; i++){
                int nx = a + dx[i];
                int ny = b + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if(!visit[nx][ny] || ans[nx][ny] > ans[a][b] + map[nx][ny]){
                        visit[nx][ny] = true;
                        ans[nx][ny] = ans[a][b] + map[nx][ny];
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
