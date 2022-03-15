package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 괄호 안 문자 제거
 */
public class RemoveParentheses {

    public String solution(String str){

        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()){
            if(x == ')'){
                if(!stack.isEmpty()) while (stack.pop() != '(');
            }else stack.push(x);
        }

        for(char x : stack) answer += x;

        return answer;
    }

    public static void main(String[] args) {
        RemoveParentheses T = new RemoveParentheses();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
