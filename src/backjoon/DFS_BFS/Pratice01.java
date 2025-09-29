package backjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 *
 * [문제]
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 * 정점 번호는 1번부터 N번까지이다.
 * [입력]
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000)
 * , 간선의 개수 M(1 ≤ M ≤ 10,000)
 * , 탐색을 시작할 정점의 번호 V가 주어진다.
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
 * 입력으로 주어지는 간선은 양방향이다.
 *
 * */
public class Pratice01 {

    static int N, M, V;
    static int[][] tree;
    static boolean visited[];

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        // 입렵 받은 값을 정수형으로 변경합니다.
        N = Integer.parseInt(st.nextToken()); // 정점 개수
        M = Integer.parseInt(st.nextToken()); // 간선 개수
        V = Integer.parseInt(st.nextToken()); // 시작번호


        // 입력으로 주어지는 간선은 양방향이다.
        tree = new int[N + 1][N + 1]; // N만큼 넣기 위해서는 + 1를 해준다.
        visited = new boolean[N + 1]; // N만큼 넣기 위해서는 + 1를 해준다.

        // 간선이 연결하는 정점에 대해서 1로 값을준다
        for (int i = 0; i < M; i ++) {
           StringTokenizer st1 = new StringTokenizer(bufferedReader.readLine());
            int vertex1 = Integer.parseInt(st1.nextToken());
            int vertex2 = Integer.parseInt(st1.nextToken());

            // 양방향으로 1으로 넣어준다.
            tree[vertex1][vertex2] = 1;
            tree[vertex2][vertex1] = 1;
        }
//        long start = System.currentTimeMillis();
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);

//        long end = System.currentTimeMillis();
//        System.out.println("수행시간: " + (end - start) + " ms " +(end - start)/1000 + "s");
    }



    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v);
        sb.append(" ");
        for (int i = 1; i <= N; i++) {
            if (tree[v][i] == 1 && !visited[i] ) {
                dfs(i);
            }
        }
    }



    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        sb.append(v);
        sb.append(" ");

        while (!queue.isEmpty()) {

            int temp = queue.poll();

            for (int i = 1; i <= N; i ++) {
                if (tree[temp][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    sb.append(i);
                    sb.append(" ");
                }
            }

        }

    }


}
