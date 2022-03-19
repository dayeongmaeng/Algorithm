package twopointers;

import java.util.ArrayList;
import java.util.Scanner;

public class BiggestSales {

    public int solution(int n,int m, int[] a){
        int answer, sum = 0;
        for(int i=0; i < m; i++) sum += a[i];
        answer = sum;
        for(int i=m;i<n;i++){
            sum += a[i]-a[i-m];
            if(answer < sum) answer = sum;
        }
        return answer;
    }

    public static void main(String[] args) {

        BiggestSales T = new BiggestSales();
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
