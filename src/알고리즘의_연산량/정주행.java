package 알고리즘의_연산량;

import java.util.Collections;
import java.util.Scanner;

public class 정주행 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 배열의 N개의 원소가 연속적인 정수 수열로 표현될 수 있는지 판단하는 함수
     * @param data
     * @param n
     * @return
     */
    public static boolean isConsecutive(int[] data, int n) {

        for(int i = 0 ; i < n ; i++) {
            int count = 0;
            for(int j=0; j+1<n; j++){
                if(data[j] > data[j+1]){
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
            if(count == 0){
                break;
            }
        }

        for(int i=1; i<n; i++){
            if(data[i-1]+1 != data[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i ++){
            data[i] = scanner.nextInt();
        }

        boolean result = isConsecutive(data, n);

        if(result){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
