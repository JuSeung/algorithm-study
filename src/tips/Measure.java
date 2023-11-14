package tips;

public class Measure {

    public static void main(String[] args) {
        int number = 123456789;
        int cnt = 0;
        for(int i = 1; i * i <= number; i++) {
            if(i * i == number) {
              cnt++;
            } else if(number % i == 0) {
              cnt += 2;
            }
        }


        System.out.println(cnt);
    }
}
