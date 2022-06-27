package 공간_활용하기;

import java.util.Scanner;

public class 팬미팅 {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getUniqueRangeNumber(int[] birthDate, int n, int k){
        int answer = 0; //모든 원소가 서로 다른 범위의 수

        //모든 윈도우 중에 모든 원소가 다른 윈도우를 카운트
        //모든 원소가 서로 다르다 => 모든 원소가 빈도수가 1 => 모든 원소가 유니크하다
        //모든 원소가 유니크하다 => table.uniqueElements == 현제 원소의 갯수
        //5개의 원소가 table내에 저장되어있는데, table.uniqueELements == 5다?

        //table.uniqueElements == k 가 되는 윈도우의 수를 카운트 하는 문제

        FrequencyTable table = new FrequencyTable();
        for(int i=0; i<k; i+=1){
            table.addBirthDate(birthDate[i]);
        }
        if(table.uniqueElements == k) answer += 1;

        for(int i=1; i + k - 1 < n; i +=1){
            //table을 i부터 (i+k-1) 번째 원소까지로 갱신해주고
            //전부 다르면 answer += 1
            table.removeBirthDate(birthDate[i-1]); //이전 윈도우의 가장 왼쪽 원소를 삭제
            table.addBirthDate(birthDate[i+k-1]); //이전 윈도우의 새로운 가장 오른쪽 원소를 추가
            if(table.uniqueElements == k){
                //table은 항상 k개의 원소만 저장하고 있게 유지되어 있다
                //그런데 table.uniqueElements == k다?
                //그럼 모든 k개의 원소가 다 유일하다 (다 서로 다르다)
                answer += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] birthDate = new int[n];
        for(int i = 0 ; i < n ; i ++) {
            birthDate[i] = scanner.nextInt();
        }
        int answer = getUniqueRangeNumber(birthDate, n, k);
        System.out.println(answer);
    }
}

class FrequencyTable {
    public static final int MAX_SIZE = 1000000;

    int uniqueElements; //현재 중복이 존재하지 않는 unique한 생일의 수
    int[] frequency;    //frequency[b] := 생일이 b인 정보의 수

    FrequencyTable(){
        this.uniqueElements = 0;
        this.frequency = new int[MAX_SIZE];
    }

    /**
     * 새로운 생일을 등록하고 빈도수를 갱신한다.
     * @param birthDate
     */
    void addBirthDate(int birthDate) {

        int count = frequency[birthDate];
        if(count == 0){
            this.uniqueElements += 1;
        }else if(count == 1){
            this.uniqueElements -= 1;
        }

        this.frequency[birthDate] +=1;
    }

    /**
     * 기존의 생일을 제거하고 빈도수를 갱신한다.
     * @param birthDate
     */
    void removeBirthDate(int birthDate) {

        int count = frequency[birthDate];
        if(count == 1){
            this.uniqueElements -= 1;
        }else if(count == 2){
            this.uniqueElements += 1;
        }

        this.frequency[birthDate] -= 1;
    }
}