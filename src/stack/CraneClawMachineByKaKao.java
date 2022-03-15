package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 크레인 인형뽑기 (카카오)
 */
public class CraneClawMachineByKaKao {

    public int solution(int[][] board, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int pos : moves){
            for (int i=0; i<board.length; i++){
                if(board[i][pos-1] != 0){
                    int tmp = board[i][pos-1];
                    board[i][pos-1] = 0;
                    if(!stack.isEmpty() && stack.peek() == tmp){
                        answer +=2;
                        stack.pop();
                    }else stack.push(tmp);
                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {

        CraneClawMachineByKaKao T = new CraneClawMachineByKaKao();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for(int i=0; i < m; i++) moves[i] = kb.nextInt();
        System.out.println(T.solution(board, moves));
    }
}