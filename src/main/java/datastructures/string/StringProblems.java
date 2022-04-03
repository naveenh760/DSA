package datastructures.string;

import java.util.Arrays;

public class StringProblems {
    public String closestPalindrome(String str) {
        int n = str.length();
        int left = 0;
        int right = n - 1;
        int count = 0;
        String result = "NO";
        while(left <= right){
            if(str.charAt(left) != str.charAt(right)){
                count++;
            }
            left++;
            right--;
        }
        if(count == 1){
            result = "YES";
        }
        if(count == 0 && n % 2 != 0){
            result = "YES";
        }
        return result;
    }

    public int countA(String str) {
        int n = str.length();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == 'a'){
                count++;
            }
        }
        return (count * (count + 1)) / 2;
    }

    public int boringString(String A) {
        int n = A.length();
        StringBuilder oddBuilder = new StringBuilder();
        StringBuilder evenBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (ch % 2 == 0) {
                evenBuilder.append(ch);
            } else {
                oddBuilder.append(ch);
            }
        }
        String oddString = sort(oddBuilder.toString());
        String evenString = sort(evenBuilder.toString());
        if(!isConcatboring(oddString,evenString) || !isConcatboring(evenString,oddString)){
            return 1;
        }
        return 0;
    }

    public boolean isConcatboring(String A,String B){
        if(B.length() > 0){
            int diff = A.charAt(A.length() - 1) - B.charAt(0);
            if(Math.abs(diff) == 1){
                return true;
            }
        }
        return false;
    }

    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    }