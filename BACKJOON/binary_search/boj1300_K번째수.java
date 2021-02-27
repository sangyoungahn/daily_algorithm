package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 1. 풀이시간 : 
 * 2. 예상 시간복잡도 : O(n)
 * 3. 풀이방법
 * N이 10^5까지 될수있다고 했으므로, N x N을 하면 대략 10억번 탐색을 해야함 -> 메모리 초과
 * 따라서 이분탐색을 사용 -> 탐색 범위를 절반씩 줄여 나가기 때문에 시간 복잡도 = O(logN)
 * 1	2	3
 * 2	4	6
 * 3	6	9	-> 여기서 4는 오름차순 정렬했을 때, 몇 번째에 오는지?
 * 					이런 식 도출 가능 : cnt = min(mid/i, N)
 * 								-> mid : 임의의 수, i : i번째 줄
 * (1) left=1, right=k로 두고, left <= right일 때까지 while문을 진행
 * (2) 위 식에 따라서 cnt를 계산
 * (3) cnt와 k를 비교하면서 left 혹은 right를 초기화
 */
public class boj1300_K번째수 {
	static int N, k, res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = k;
		
		System.out.println(biSearch(left, right));
	}

	public static int biSearch(int left, int right) {
		int cnt = 0;
		int mid = (left + right) / 2;
		if(left > right)	return res;
		
		// mid보다 작거나 같은 수가 몇 개인지 계산
		for(int i=1; i<=N; i++) {
			cnt += Math.min(mid/i, N);
		}
		
		// 구하려고 하는 수의 순서(k)가 cnt보다 작으면 -> mid 값을 더 큰 범위에서 찾아야 함
		// 구하려고 하는 수의 순서(k)가 cnt보다 크면 -> mid 값을 더 작은 범위에서 찾아야 함
		if(k<=cnt) {
			res = mid;
			return biSearch(left, mid-1);
		} else {
			return biSearch(mid+1, right);
		}
	}

}
