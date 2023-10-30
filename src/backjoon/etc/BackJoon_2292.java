package backjoon.etc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *
 * 벌집
 *
 * */
public class BackJoon_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int count = 1;
        int range = 2;
        if (N == 1) {
            System.out.println(1);

        } else {
            while (range <= N) {
                range = range + (6 * count);
                count++;
            }
            System.out.println(count);
        }

    }

}
