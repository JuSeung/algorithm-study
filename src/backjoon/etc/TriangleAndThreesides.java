package backjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.
 * <p>
 * Equilateral :  세 변의 길이가 모두 같은 경우
 * Isosceles : 두 변의 길이만 같은 경우
 * Scalene : 세 변의 길이가 모두 다른 경우
 * 단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다. 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
 * <p>
 * 세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.
 * <p>
 * 입력
 * 각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.
 * <p>
 * 출력
 * 각 입력에 맞는 결과 (Equilateral, Isosceles, Scalene, Invalid) 를 출력하시오.
 * <p>
 * 예제 입력 1
 * 7 7 7
 * 6 5 4
 * 3 2 5
 * 6 2 6
 * 0 0 0
 * <p>
 * 예제 출력 1
 * Equilateral
 * Scalene
 * Invalid
 * Isosceles
 */
public class TriangleAndThreesides {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<String> stringList = new ArrayList<>();
        while (true) {
            Set<Integer> str = new HashSet<>();
            List<Integer> intList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());
            int number3 = Integer.parseInt(st.nextToken());

            if (number3 + number1 + number2 == 0) {
                break;
            }
            intList.add(number1);
            intList.add(number2);
            intList.add(number3);
            str.add(number1);
            str.add(number2);
            str.add(number3);

            intList.stream().sorted().collect(Collectors.toList());
            int size = str.size();

            if (intList.get(0) + intList.get(1) <= intList.get(2)) {
                stringList.add("Invalid");
            } else if (size == 1) {
                stringList.add("Equilateral");
            } else if (size == 2) {
                stringList.add("Isosceles");
            } else if (size == 3) {
                stringList.add("Scalene");
            }
        }

        stringList.stream().forEach(s -> {
            System.out.println(s);
        });
    }


}
