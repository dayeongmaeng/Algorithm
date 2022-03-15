package recursion;

/**
 * 피보나치 수열 재귀함수 : * 메모이제이션 *
 * - 배열이나 for문, 재귀로 피보나치 짜보라고 많이 함
 *   성능도 많이 물어보는데 당연 배열이나 for가 좋음
 *   재귀는 스택프레임이 생성되기때문에 무거움
 */
public class Fibonacci {

    static int[] fibo;

    public int DFS(int n){

        //메모이제이션을 활용하여 시간 복잡도를 줄이는 것이 관건
        if(fibo[n] > 0) return fibo[n];

        if(n==1 || n==2) return fibo[n] = 1;
        else return fibo[n] = DFS(n-2) + DFS(n-1);
    }

    public static void main(String[] args) {
        Fibonacci T = new Fibonacci();
        int n = 45;
        fibo = new int[n+1];
        T.DFS(n);
        for (int i=1; i<=n; i++) System.out.print(fibo[i] + " ");
    }
}
