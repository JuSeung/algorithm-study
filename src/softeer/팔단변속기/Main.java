package softeer.팔단변속기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] values = br.readLine().split(" ");
        int ascenCnt = 0;
        int descCnt = 0;
        int mixCnt = 0;

        for (int i = 0; i < values.length - 1; i++) {
            if (Integer.parseInt(values[0]) == values.length) {
                if (Integer.parseInt(values[i]) - Integer.parseInt(values[i + 1]) == 1) {
                    descCnt++;
                } else {
                    mixCnt++;
                }
            } else {
                System.out.println(values[i + 1]  + " : " + values[i]);
                if (Integer.parseInt(values[i + 1]) - Integer.parseInt(values[i]) == 1) {
                    ascenCnt++;
                } else {
                    mixCnt++;
                }
            }
        }

        if (mixCnt > 0) {
            System.out.println("mixed");
        } else if (ascenCnt == values.length - 1) {
            System.out.println("ascending");
        } else if (descCnt == values.length - 1) {
            System.out.println("descending");
        }


    }
}
