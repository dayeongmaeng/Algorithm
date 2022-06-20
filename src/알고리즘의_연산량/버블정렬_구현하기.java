package 알고리즘의_연산량;

import java.util.Scanner;

public class 버블정렬_구현하기 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void bubbleSort(int[] data, int n) {
        for(int i = 0 ; i < n ; i++) {
            for(int j=0; j<n-i-1; j++){
                if(data[j] > data[j+1]){
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        int n = scanner.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i++) {
            data[i] = scanner.nextInt();
        }

        bubbleSort(data, n);

        for(int i = 0 ; i < n ; i++) {
            if( i > 0 ) {
                System.out.print(" ");
            }

            System.out.print(data[i]);
        }
    }
}
