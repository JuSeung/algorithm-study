package codingTest;
/*
*   정수 범위는 [1 - 50000]
*   28 힙은 10이다 이 합이 다른 숫자인 37을 리턴 해줘야 하낟.
*
* */

public class Solution {
    private static final int MAX_NUMBER = 50000;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(28);
    }

    public void solution(int N) {
        int result = 0;
        String values = conversionString(N);
        int addNumber = addResult(values);
        result = getSameNumber(N, addNumber);
        System.out.println(result);
    }

    // 1.숫자 -> 문자열 변경
    private String conversionString(int n) {
        return String.valueOf(n);
    }

    // 2.'123' -> 6 끊어서 합산
    private int addResult(String values) {
        int result = 0;
        for (char value : values.toCharArray()) {
            result += Character.getNumericValue(value);
        }
        return result;
    }

    // 현재 값 이후에 50000 까지에 같은 합산이 있는 해들 찾아서 비교 후 있으면 리턴
    private int getSameNumber(int n, int number) {
        int result = 0;
        n += 1;
        for (int i = n; i < MAX_NUMBER; i++) {
            String nextNumberValues = conversionString(i);
            int nextNumber = addResult(nextNumberValues);
                if (number == nextNumber) {
                    return Integer.parseInt(nextNumberValues);
                }
        }
        return result;
    }
}


