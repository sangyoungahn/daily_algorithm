package brute_force;

/*
 * 1. Ǯ�̽ð� : 15��
 * 2. ���� �ð����⵵ : O(n^2)
 * 3. Ǯ�̹��
 * N�� 2~50�̹Ƿ� for�� 2������ Ǯ� �ð��ʰ��� ���� ����
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

public class boj7568_��ġ {

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
