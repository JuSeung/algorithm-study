package codility;

import java.util.ArrayList;
import java.util.HashSet;

public class OddOccurrencesInArray {

    public static void main(String[] args) {

        int[] A = new int[]{9, 3, 9, 3, 9, 7, 9};

        solution_array(A);
        solution_bit(A);

    }

    private static void solution_array(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length ; i ++) {
            if (set.contains(A[i])) {
                set.remove(A[i]);
            } else {
                set.add(A[i]);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>(set);
        System.out.println("array : " + arrayList.get(0));
    }

    private static void solution_bit(int[] A) {
        int result = 0;
        for (int i : A) {
            result ^= i;
        }
        System.out.println("bit : " + result);
    }

}
