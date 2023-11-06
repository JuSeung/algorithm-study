package softeer.장애물인프로그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
*
*    제약조건
*    N은 정사각형임으로 가로와 세로의 크기는 같으며 5 ≤ N ≤ 25
*
*    입력형식
*
*    입력 값의 첫 번째 줄에는 지도의 크기 N이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
*
*
    출력형식
    첫 번째 줄에는 총 블록 수를 출력 하시오.

    그리고 각 블록 내 장애물의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

    입력예제1
    7
    1110111
    0110101
    0110101
    0000100
    0110000
    0111110
    0110000
    출력예제1
    3
    7
    8
    9

*
*
*
*
* */

public class main {
    static int N;
    static int[][] dp;
    static boolean[][] visited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            String strs = br.readLine();
            for (int j = 0; j < N; j++) {
                dp[i][j] = Character.getNumericValue(strs.charAt(j));
            }
        }
        System.out.println(Arrays.deepToString(dp));
        int blockCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 1 && !visited[i][j]) {
                    blockCnt++;
                    int cnt = bfs(i, j);
                    list.add(cnt);
                }
            }
        }
        list.sort(Comparator.comparingInt(s -> s));
        System.out.println(blockCnt);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    private static int bfs(int i, int j) {
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[] {i, j});
        visited[i][j] = true;
        int count = 1;
        while (!deque.isEmpty()) {
            int[] currPoint = deque.poll();
            for (int[] dir : dirs) {
                int dirx = currPoint[0] + dir[0];
                int diry = currPoint[1] + dir[1];
                if (dirx < 0 || diry < 0 || dirx >= N || diry >= N) continue;
                if (dp[dirx][diry] != 1 || visited[dirx][diry]) continue;

                deque.offer(new int[]{dirx, diry});
                count++;
                visited[dirx][diry] = true;


            }
        }
        return count;

    }

}
