package softeer.금고털이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Metal {
        int weight;
        int price;

        Metal(int weight, int price) {
          this.weight = weight;
          this.price = price;
       }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalWeight = Integer.parseInt(st.nextToken());
        int bagCount = Integer.parseInt(st.nextToken());
        List<Metal> list = new ArrayList<>();
        for (int i = 0; i < bagCount; i++) {
            st = new StringTokenizer(br.readLine());
            Metal metal = new Metal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(metal);
        }
        list.sort((m1, m2) -> m2.price - m1.price); //내림차순 정렬
        int totalValue = 0;
        for (int i = 0; i < bagCount; i++) {
             Metal metal = list.get(i);
             if (totalWeight <= metal.weight) {
                 totalValue += totalWeight * metal.price;
                 break;
             } else {
                 totalValue +=  metal.weight * metal.price;
                 totalWeight -= metal.weight;
             }
        }
        System.out.println(totalValue);
    }
}
