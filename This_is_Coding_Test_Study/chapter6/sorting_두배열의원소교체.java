package python_for_coding_test.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class sorting_두배열의원소교체 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = br.readLine().split(" ");
        int N = Integer.parseInt(srr[0]);
        int K = Integer.parseInt(srr[1]);
        Integer[] arrA = new Integer[N];
        Integer[] arrB = new Integer[N];

        srr = br.readLine().split(" ");
        for(int i=0; i<srr.length; i++) {
            arrA[i] = Integer.parseInt(srr[i]);
        }
        srr = br.readLine().split(" ");
        for(int i=0; i<srr.length; i++) {
            arrB[i] = Integer.parseInt(srr[i]);
        }

        Arrays.sort(arrA);  // 오른차순 정렬
        Arrays.sort(arrB, Collections.reverseOrder());  // 내림차순 정렬

        for(int i=0; i<K; i++) {
            // A의 원소가 B의 원소보다 작은 경우 -> 두 원소 교체
            if(arrA[i] < arrB[i]) {
                int temp = arrA[i];
                arrA[i] = arrB[i];
                arrB[i] = temp;
            }
            // A의 원소가 B의 원소보다 크거나 같을 때 -> 반복문 탈출
            else    break;
        }

        long result = 0;
        for(int i=0; i<N; i++) {
            result += arrA[i];
        }
        System.out.println(result);
    }
}
