package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryGap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();

        int N = Integer.parseInt(st);


        String[] arg = Integer.toBinaryString(N).split("");
        Deque<String> stack = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < arg.length ; i ++) {
            stack.push(arg[i]);
            if (arg[i].equals("1")) {
                int count = 0;
                while (!stack.isEmpty()) {
                    String ss = stack.pop();
                    if (ss.equals("0")) {
                        count ++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        System.out.println("max : " + max);


    }



}
