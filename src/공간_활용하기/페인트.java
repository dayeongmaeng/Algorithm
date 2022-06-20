package 공간_활용하기;

import java.util.Scanner;

public class 페인트 {

    public static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_SEAT_NUMBER = 1000;
    public static final int MAX_COLOR_NUMBER = 100;

    /**
     *
     * @param n : 좌석의 수. 좌석은 0~(n-1)번의 번호를 가진다.
     * @param m : 좌석을 칠한 횟수.
     * @param paintings  : 좌석들을 색칠한 이벤트들의 정보
     */
    public static void solve(int n, int m, Painting[] paintings) {
        int[] seats = new int[n]; //seats[i] := i번 좌석의 최종 색상

        //주어진 색상 정보에 따라처 최종 생칠 정보를 시몰레이션 로직
        for(Painting p : paintings){
            // p:= 모든 paintings의 원소가 차례로 한 번씩
            //searts[left] ~ searts[right] 까지 전부 색상 x로 덜어쓰자 (색상은 섞이지 않는다)
            for(int i=p.left; i <=p.right;i++){
                seats[i] = p.color;
            }
        }

        int[] table; //table[c] := 색상 x가 seats내에서 등장한 회수
        table = new int[100];

        for(int i=0; i<n; i ++){
            table[seats[i]] += 1;
        }

        //1번째 -> 1번도 등장하지 않은 색상은 초기화X
        //2번째 -> 같은 조건이면 '색상값이' 번호가 작은 애들 우선
        int minColor = -1; //가장 적게 등장한 색상
        int maxColor = -1; //가장 많이 등장한 색상

        for(int color=0; color <= 99; color++){
            //color := 0 ~ 99 사이의 모든 색상
            if(table[color] == 0) continue;
            if(minColor == -1 || table[color] < table[minColor]) {
                minColor = color;
            }
            if(maxColor == -1 || table[color] > table[maxColor]) {
                maxColor = color;
            }

        }


        System.out.println(maxColor);
        System.out.println(minColor);
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //paintings[i] := i번째에 일어난 색칠 이벤트의 정보
        Painting[] paintings = new Painting[m];


        for(int i = 0 ; i < m ; i ++) {
            //좌석의 번호는 1번부터 시작하므로, 0 ~ (n-1)범위로 맞추기 위하여 1씩 빼준다
            int left = scanner.nextInt()  -1;
            int right = scanner.nextInt() -1;
            int color = scanner.nextInt();
            paintings[i] = new Painting(left, right, color);
        }

        //문제의 정답을 구한다
        solve(n, m, paintings);
    }
}

//좌석들을 한 번 색칠하는 이벤트에 대한 정보
class Painting{
    public int left;
    public int right;
    public int color;
    Painting(int left, int right, int color) {
        this.left = left;
        this.right = right;
        this.color = color;
    }
}