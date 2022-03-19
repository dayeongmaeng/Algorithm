package twopointers;

import java.util.Scanner;

/**
 * 연속 부분수열
 */
public class ContinuousPartialSequence {

    public int solution(int n,int m, int[] arr){
        int answer=0, sum=0, lt=0;
        for(int rt=0; rt<n;rt++){
            sum += arr[rt];
            if(sum==m) answer++;
            while (sum >= m){
                sum -= arr[lt++];
                if(sum==m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        ContinuousPartialSequence T = new ContinuousPartialSequence();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }
        System.out.print(T.solution(n, m,a));
    }
}
