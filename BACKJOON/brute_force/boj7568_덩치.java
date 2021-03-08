package brute_force;

/*
 * 1. 풀이시간 : 15분
 * 2. 예상 시간복잡도 : O(n^2)
 * 3. 풀이방법
 * N이 2~50이므로 for문 2번으로 풀어도 시간초과가 나지 않음
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class boj7568_덩치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] weight = new int[N];
		int[] height = new int[N];
		int[] order = new int[N];

		for (int i = 0; i < N; i++) {
			String[] srr = br.readLine().split(" ");
			weight[i] = Integer.parseInt(srr[0]);
			height[i] = Integer.parseInt(srr[1]);
		}

		for (int i = 0; i < N; i++) {
			int orderCnt = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				if (weight[i] < weight[j] && height[i] < height[j]) {
					orderCnt++;
				}
			}
			order[i] = orderCnt + 1;
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(order[i] + " ");
		}
	}

}
