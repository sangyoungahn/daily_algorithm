package python_for_coding_test.sorting;

public class sorting_선택정렬 {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int i=0; i<n; i++) {
            int minIndex = i;
            for(int j=i+1; j<n; j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // 탐색 시작 index와 가장 작은 index를 swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
