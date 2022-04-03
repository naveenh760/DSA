package datastructures.queue;

import java.util.*;

public class Problems {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(reverseElementsQue(list,3));
    }
    public static ArrayList<Integer> reverseElementsQue(ArrayList<Integer> A, int B) {
        int n = A.size();
        Queue<Integer> que = new LinkedList<>(A);
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= B; i++){
            stack.push(que.poll());
        }
        for(int i = 1; i <= B; i++){
            que.add(stack.pop());
        }
        for(int i = 1; i <= n - B;i++){
            que.add(que.poll());
        }
        ArrayList<Integer> ans = new ArrayList<>(que);
        return ans;
    }

}
