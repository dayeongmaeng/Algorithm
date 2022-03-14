package recursion;

/**
 * 재귀함수를 이용한 이진수 출력
 */
public class BinaryOutput {

    public void DFS(int n){
        if(n==0) return;
        else{
            DFS(n/2);
            System.out.print(n%2 + " ");
        }
    }

    public static void main(String[] args) {
        BinaryOutput T = new BinaryOutput();
        T.DFS(11);
    }
}
