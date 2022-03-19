package decisionalgorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 마구간 정하기
 * 거리를 구할 떄는 lt, rt 설정 조심
 */
public class StableSetting {

    public int count (int[] arr, int dist){
        int cnt=1;
        int ep=arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]-ep>=dist){
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        int lt=1;
        int rt=arr[n-1];
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr, mid)>=m){
                answer=mid;
                lt=mid+1;
            }else rt = mid-1;
        }
        return answer;
    }

    public static void main(String[] args) {
        StableSetting T = new StableSetting();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.print(T.solution(n, m, arr));
    }
}
