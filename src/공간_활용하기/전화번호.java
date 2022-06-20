package 공간_활용하기;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 전화번호 {

    public static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_TABLE_LENGTH = 10000;
    public static int[] table = new int[MAX_TABLE_LENGTH];

    /**
     * data[0] ~ data[n-1]에 등장한 번호들에 대한 빈도수 테이블을 채우는 함수
     * @param data
     * @param n
     * @param table  table[x] := data배열에서 x가 등장한 횟수
     */
    public static void fillFrequencyTable(int[] data, int n, int[] table) {
        for(int i=0; i<n;i++){
            table[data[i]] +=1;
        }
    }

    /**
     * data[0] ~ data[n-1]사이에서 가장 많이 등장한 번호를 반환하는 함수
     * @param data
     * @param n
     * @return  가장 많이 등장한 번호. 여러개인 경우 사전순으로 가장 빠른 번호.
     */
    public static int getFrequentNumber(int[] data, int n) {

        fillFrequencyTable(data, n, table);
        int frequent_number = 0; //0000~9999 중 가장 많이 등장한 번호
        int[] table = new int[MAX_TABLE_LENGTH]; // table[x] := data에서 x가 등장한 횟수

        for(int number=0; number<n; number++){
            int count = table[number];
            if(count > table[frequent_number]) {
                frequent_number = number;
            }
        }
        //0000~9999중  가장 많이 등장한 번호
        return frequent_number;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        int answer = getFrequentNumber(data, n);
        System.out.printf("%04d", answer);
    }
}
