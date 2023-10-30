package backjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Viruese_ArrayList {
    static int N, M;
    static ArrayList<Integer>[] area;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 간선 수

        area = new ArrayList[N + 1];
        visited = new boolean[N + 1]; // 편의성을 위해 1부터 시작 한다.

        // ArrayList 초기화 한다. 편의성위해 1부터 초기화
        for (int i = 1; i < N + 1 ; i++) {
            area[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i ++) { // 간선의 수 만큼 데이터 받아서 ArraList 인접하게 데이터를 넣는다.
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            area[s].add(e);
            area[e].add(s);
        }
        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int start) {
        visited[start] = true;

        for (int a : area[start]) {
            if (!visited[a]) {
                count++;
                dfs(a);
            }
        }
    }
}
