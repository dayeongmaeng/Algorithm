package twopointers;

import treeset.FindNumber;

import java.util.ArrayList;
import java.util.Scanner;

public class SumTwoArray {

    //정렬의 시작 복잡도 : O(nlogn) = 60000개 * 16 = 960000번 -> O(n) 으로 짜기
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0,p2=0;
        while (p1<n && p2<m){
            if(a[p1]<b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while (p1<n) answer.add(a[p1++]);
        while (p2<m) answer.add(b[p2++]);
        return answer;
    }

    public static void main(String[] args) {

        SumTwoArray T = new SumTwoArray();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = kb.nextInt();
        }

        for (int x : T.solution(n, m, a, b)) System.out.print(x + " ");
    }
}
