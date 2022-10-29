package python_for_coding_test.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch_이진탐색_반복문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = br.readLine().split(" ");
        int n = Integer.parseInt(srr[0]);
        int target = Integer.parseInt(srr[1]);

        int[] arr = new int[n];
        srr = br.readLine().split(" ");
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(srr[i]);
        }

        // 이진탐색
        int result = binarySearch(arr,target,0,n-1);
        if(result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        } else {
            System.out.println(result + 1);
        }
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 값을 찾은 경우 인덱스 반환
            if(arr[mid] == target)      return mid;
            // "중간점의 값 > 찾고자 하는 값" : 왼쪽 확인
            else if(arr[mid] > target)  end = mid-1;
            // "중간점의 값 < 찾고자 하는 값" : 오른쪽 확인
            else        start = mid+1;
        }

        return -1;
    }
}
