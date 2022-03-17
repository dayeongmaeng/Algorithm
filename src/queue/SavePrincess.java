package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 공주 구하기
 */
public class SavePrincess {

    public int solution(int n, int k){
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        for(int i=1; i<=n; i++) Q.offer(i);
        while(!Q.isEmpty()){
            for(int i=1; i<k;i++) Q.offer(Q.poll()); //꺼낸값을 다시 넣어줌
            Q.poll();
            if(Q.size() == 1) answer = Q.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        SavePrincess T = new SavePrincess();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.println(T.solution(n, k));
    }
}
