package python_for_coding_test.sorting;

public class sorting_삽입정렬 {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int i=1; i<n; i++) {
            // 인덱스 i부터 1까지 감소하며 반복
            for(int j=i; j>0; j--) {
                // 앞의 index가 자기보다 값이 크면 swap
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                // 앞의 index가 자기보다 값이 작으면 그대로 둠
                else    break;
            }
        }

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
