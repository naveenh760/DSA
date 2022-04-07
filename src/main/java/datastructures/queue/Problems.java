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

    public ArrayList<Integer> integerCombinations(int A) {
        Queue<Integer> que = new LinkedList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        que.add(1);
        que.add(2);
        que.add(3);
        int count = 0;
        while(count < A){
            int curNum = que.poll();
            ans.add(curNum);
            count++;
            for(int i = 1; i <= 3; i++){
                int nextNum = curNum*10 + i;
                que.add(nextNum);
            }
        }
        return ans;
    }

}
