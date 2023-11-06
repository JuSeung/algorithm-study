package softeer.지도자동구축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int temp = (int) Math.pow(2, N) + 1;
        System.out.println(temp);
        System.out.println(Math.pow(temp, 2));
        // 2의 제곱승의 + 1 를 제급

    }
}
