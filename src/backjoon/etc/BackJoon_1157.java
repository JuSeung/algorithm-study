package backjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BackJoon_1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();


        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String word = String.valueOf(str.charAt(i)).toUpperCase();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            Integer value = stringIntegerEntry.getValue();
            max = Math.max(max, value);
        }
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (max == stringIntegerEntry.getValue()) {
                set.add(stringIntegerEntry.getKey());
            }
        }
        int size = set.size();
        if (size > 1) {
            System.out.println("?");
        } else {
            System.out.println(set.iterator().next());
        }

    }

}
