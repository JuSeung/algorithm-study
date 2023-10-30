import java.io.*;
import java.util.*;


class Main {

        static int N, M;
    static int[][] area;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        area = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M ; i ++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            area[s][e] = 1;
            area[e][s] = 1;
        }
        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i < N + 1; i++) {
            if (area[start][i] == 1 && !visited[i]) {
                count++;
                dfs(i);
            }
        }

    }

}
