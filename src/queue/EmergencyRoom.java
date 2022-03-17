package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EmergencyRoom {

    public int solution(int n, int m, int[] arr){
        int answer = 1;
        Queue<Persion> Q = new LinkedList<>();
        for(int i=0; i < n; i++) Q.add(new Persion(i, arr[i]));

        while (!Q.isEmpty()){
            Persion tmp = Q.poll();
            for(Persion x : Q){
                if(x.priority > tmp.priority){
                    Q.add(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                if(tmp.id == m) return answer;
                else answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        EmergencyRoom T = new EmergencyRoom();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = kb.nextInt();
        System.out.println(T.solution(n, m, arr));
    }
}

class Persion{
    int id;
    int priority;
    public Persion(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}
