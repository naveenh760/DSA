package datastructures.stack;

import java.util.Arrays;
import java.util.Stack;

public class BracesProblems {
    public static int CountUnbalanced(String input) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            Character current = input.charAt(i);
            if (current == '(') {
                stack.push(current);
            } else if (current == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    stack.push(current);
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }

    public static boolean isBalanced(String str) {
        int n = str.length();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < n; i++) {
            if (isOpening(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (isMatchingTop(stack.peek(), str.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingTop(Character peek, char charAt) {
        return ((peek == '(' && charAt == ')') || (peek == '{' && charAt == '}') || (peek == '[' && charAt == ']'));
    }

    private static boolean isOpening(char charAt) {

        return (charAt == '(' || charAt == '[' || charAt == '{');
    }

    public int[] balanceBrackets(String A) {
        int[] result = new int[2];
        Arrays.fill(result, 0);
        Stack<Character> stack = new Stack<Character>();
        int length = A.length();

        for (int i = 0; i < length; i++) {
            Character ch = A.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.empty()) {
                    result[0]++;
                } else if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        result[1] = stack.size();
        return result;
    }

    public int checkRedundantBraces(String A){
        int n = A.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            char ch = A.charAt(i);
            if(ch == '(' || isOperator(ch)){
                stack.push(ch);
            }
            if(ch == ')'){
                if(!isOperator(stack.peek())){
                    return 1;
                }
                else{
                    while(isOperator(stack.peek())){
                        stack.pop();
                    }
                    stack.pop();
                }
            }
        }
        return 0;
    }

    public boolean isOperator(char ch){
        return (ch == '+') || (ch == '-') || (ch == '*') || (ch == '/');
    }

}
