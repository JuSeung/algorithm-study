package backjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * N×M크기의 배열로 표현되는 미로가 있다.
 * <p>
 * 1	0	1	1	1	1
 * 1	0	1	0	1	0
 * 1	0	1	0	1	1
 * 1	1	1	0	1	1
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 * <p>
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 * <p>
 * 입력
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 */
public class Practice02 {
    static int N, M;

    static int[][] mirro;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mirro = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            String str = st1.nextToken();
            for (int j = 0; j < str.length(); j++) {
                mirro[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(Arrays.deepToString(mirro));
        System.out.println(mirro[N-1][M-1]);
    }

    public static void bfs(int x, int y) {
        Deque<Position> p = new LinkedList<>();
        p.offer(new Position(x, y));
        while (!p.isEmpty()) {
            Position prevPostion = p.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = prevPostion.x + moveX[i];
                int nextY = prevPostion.y + moveY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (mirro[nextX][nextY] == 0 || visited[nextX][nextY]) {
                    continue;
                }
                p.offer(new Position(nextX, nextY));
                visited[nextX][nextY] = true;
                mirro[nextX][nextY] = mirro[prevPostion.x][prevPostion.y] + 1;
            }
        }

    }

}


class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}




