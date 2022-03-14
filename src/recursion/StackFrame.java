package recursion;

/**
 * 재귀 함수를 이용하여 1부터 N까지 출력
 */
public class StackFrame {

    public void DFS(int n){
        if(n == 0) return;
        else{
            DFS(n-1);
            System.out.print(n+" ");
        }
    }

    public static void main(String[] args) {

        StackFrame T = new StackFrame();
        T.DFS(3);
    }
}
