package codingTest;
/*
*  150분 2시간30분
*  자연수 num이 주어질 때, num보다 크거나 같은 자연수 중에서 다음 조건을 만족하는 가장 작은 수를 구하려 합니다.
*  구하는 숫자의 자릿수는 짝수여야 합니다.
*  숫자가 2 x n 자릿수 일 때, 앞 n 자리의 각 자릿수 곱과 뒤 n 자리의 각 자릿수 곱이 같아야 합니다.
*   자연수 num이 매개변수로 주어질 때, num보다 크거나 같은 수 중에서 조건을 만족하는 가장 작은 수를 return 하도록 solution 함수를 완성해주세요.
* */
public class Solution2 {
    public static final int MAX_NUMBER = 50000000;
    public static final int TWO = 2;

    public static void main(String[] args) {
        int num = 21;

        int result = 0;
        for (int i = num; i <= MAX_NUMBER; i++) {
            if (isNumLengthEven(i)) {
                int numLength = getNumLength(i);
                int divisionLength = getDivisionLength(numLength);

                if (isSameNumber(i, divisionLength)) {
                    result = i;
                    break;
                }
            }
        }
        System.out.println("result  : " + result);
    }

    // 숫자가 짝이인지 확인
    public static boolean isEven(int num) {
        return num % TWO == 0;
    }

    // 숫자 자리수 확인
    public static int getNumLength(int num) {
        return String.valueOf(num).length();
    }

    public static int getDivisionLength(int length) {
        return length / TWO;
    }

    public static boolean isNumLengthEven(int num) {
        return String.valueOf(num).length() % TWO == 0;
    }

    public static boolean isSameNumber(int num, int divisionLength) {
        String strNumber = String.valueOf(num);
        String firstStr = strNumber.substring(0, divisionLength);
        String secondStr = strNumber.substring(divisionLength, strNumber.length());
        int first = getMultiplyResult(firstStr);
        int second = getMultiplyResult(secondStr);
        return first == second;
    }

    public static int getMultiplyResult(String str) {
        int result = 0;
        int index = 0;
        for (char value : str.toCharArray()) {
            int num = Character.getNumericValue(value);
            if (index == 0) {
                result = num;
            } else {
                result *= num;
            }
            index++;
        }
        return result;
    }

}
