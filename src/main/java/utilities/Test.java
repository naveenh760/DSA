package utilities;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        list.replaceAll(num -> addFive(num));
        list.forEach(System.out::println);
    }

    public static int addFive(int num){
        return num + 5;
    }
}
