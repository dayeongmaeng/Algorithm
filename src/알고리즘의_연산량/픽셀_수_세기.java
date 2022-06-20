package 알고리즘의_연산량;

import java.util.Scanner;

public class 픽셀_수_세기 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 왼쪽 아래 좌표가 (x,y)인 픽셀이 반지름 R인 원에 포함되는가?
     * @param x
     * @param y
     * @param R
     * @return  포함된다면 true, else false
     */
    public static boolean isInside(long x, long y, long R){
        return true;
    }

    public static void testCase(int caseIndex) {
        long R = scanner.nextLong();
        System.out.printf("#%d\n", caseIndex);
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }
}
