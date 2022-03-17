package array;

import java.util.Scanner;

public class Fibonacci {

    public int[] solution(int n){
        int[] answer = new int[n];
        answer[0]=1;
        answer[1]=1;
        for(int i=2; i<n;i++) answer[i] = answer[i-2] + answer[i-1];
        return answer;
    }
    public void solution2(int n){
        int a=1, b=1, c;
        System.out.print(a + " " + b + " ");
        for(int i=2; i<n; i++) {
            c = a+b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
    public static void main(String[] args) {
        Fibonacci T = new Fibonacci();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        T.solution2(n);
        for(int x : T.solution(n)) System.out.print(x+" ");
    }
}
