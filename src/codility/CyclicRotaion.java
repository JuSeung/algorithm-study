package codility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CyclicRotaion {

    public static void main(String[] args) {
        int[] A = new int[]{3, 8, 9, 7, 6};
        int K = 3;

        for (int j = 0; j < K ; j ++) {
            int[] B = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                if (i == 0) {
                    B[0] = A[A.length - 1];
                }
                if (i + 1 < A.length) {
                    B[i + 1] = A[i];
                }
            }
            A = B;
        }

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }


    }
}
