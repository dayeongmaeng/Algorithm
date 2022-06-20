package 공간_활용하기;

import java.util.Scanner;

public class 색종이 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 색종이들이 덮고 있는 영역의 총 넓이를 계산하는 함수
     *
     * @param papers
     * @param n
     * @return
     */
    public static int getCoveredArea(Paper[] papers, int n) {
        int answer = 0; //색종이들이 덮은 영역의 총 넓이
        int[][] board = new int[101][101];
        // board[r][c] := <r,c> 칸 단위 사각형을 덮고 있는 색종이의 갯수
        for(Paper p : papers){
            //색종이 p는
            for(int row = p.bottomRow; row<=p.topRow; row+=1){
                for(int col = p.leftColumn; col <= p.rightColumn; col +=1){
                    //col := 색종이 p가 덮고 있는 모든 열의 번호
                    //<row, col> := 생족이 p가 덮고 있는 모든 칸의 좌표
                    board[row][col] +=1; //1을 증가시키는 명령어
                }

            }
        }

        //계산해..냈.. 쌤이..
        for(int row=0; row <= 100; row +=1){
            for(int col=0; col<=100; col+=1){
                if(board[row][col] >= 1){
                    //<row,col> := 하나 이상의 색종이가 덮고 있는 모든 칸
                    answer += 1; // 1 증가 x 하나 이상의 색종이가 덮고 있는 모든 칸의 수 =>
                }
            }
        }
        //answer := 하나 이상의 색종이가 덮고 있는 모든 칸의 수 == 모든 칸의 넓이
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1){ //각 테스트케이스에 대하여
            int n = scanner.nextInt();

            //색종이들의 정보를 입력 받는다.
            Paper[] papers = new Paper[n];
            for(int i = 0 ; i < n ; i ++) {
                int leftX = scanner.nextInt();
                int bottomY = scanner.nextInt();
                papers[i] = new Paper(leftX, bottomY);
            }

            //색종이들이 덮은 영역의 넓이를 계산한다.
            int answer = getCoveredArea(papers, n);

            System.out.println(answer);
        }
    }

}


class Paper {
    int leftColumn;   //가장 왼쪽 격자의 열 번호
    int rightColumn;  //가장 오른쪽 격자의 열 번호
    int topRow;       //가장 위쪽 격자의 행 번호
    int bottomRow;    //가장 아래쪽 격자의 행 번호
    Paper(int xPos, int yPos){
        this.leftColumn = xPos;
        this.rightColumn = this.leftColumn + 9;
        this.bottomRow = yPos;
        this.topRow = this.bottomRow + 9;
    }
}
