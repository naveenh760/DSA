package datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Other {

    public int firstMissingPositive(int[] A) {
        int n = A.length;
        int res = - 1;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num: A){
            if(num > 0){
                set.add(num);
            }
        }

        for(int i = 1; i <= n + 1; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return res;
    }

    public int firstMissingPositive(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        int lastPositiveInteger = 0;
        for(int i = 0; i < n; i++){
            if(A.get(i) > 0){
                int difference = A.get(i) - lastPositiveInteger;
                if(difference > 1){
                    break;
                }
                lastPositiveInteger = A.get(i);
            }
        }
        return lastPositiveInteger + 1;
    }

    public int firstMissingPositive1(ArrayList<Integer> A){
        int n = A.size();
        for(int i = 0; i < n; i++){
            if(A.get(i) > 0 && A.get(i) <= n){
                int pos = A.get(i) - 1;
                if(A.get(i) != A.get(pos)){
                    Collections.swap(A,i, pos);
                    i--;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(A.get(i) != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }


}
