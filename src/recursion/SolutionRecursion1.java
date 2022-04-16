package recursion;

/*
 *  재귀를 풀기 위한 4가지 접근법
 *  참조 : https://velog.io/@eddy_song/you-can-solve-recursion
 *  1. 문자열 뒤집기 (Reverse String)
 *
 *  문제
 *  문자열 s가 주어진다. 이 s를 뒤집어서 반환하는 함수를 만들어라.
 *  ex) reverseString(“hello”) → “olleh”
 * */
public class SolutionRecursion1 {

    public static void main(String[] args) {
        SolutionRecursion1 solutionRecursion1 = new SolutionRecursion1();
        // 1. 재귀를 꼭 서야 하는가?
        // 2. 베이스 조건
        //  -> 답을 바로 알수 있는 가장 간단한 상황이 먼지 생각한다.
        //  -> 글자수 길이가 0과1인 경우다.
        // 3. 분해
        //  -> 베이스 케이스에 가까워지도록 인풋값을 조작한다.
        //  -> "hello" -> "ello" -> "llo" -> "lo" -> "o"
        //  -> "nice"  -> "ice" -> "ce" -> "e"
        // 4. 조합
        // -> 베이스 조건 바로 윗단계를 생각한다.
        // -> 글자수 길이가 0과 1인 윗단계이면 2이다.
        // -> 베이스 조건 3단계로 생각한다.
        // -> 부분 문제 답에, 현재 문자열의 첫글자를 붙여준다.
        String test = "hello";


        System.out.println(solutionRecursion1.solution(test));

    }

    public String solution (String str) {
        // 0 일때
        if (str.length() == 0) return "";
        String nextStr = str.substring(1);
        return solution(nextStr) + str.charAt(0);
    }
}
