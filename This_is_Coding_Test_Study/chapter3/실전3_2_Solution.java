package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 실전3_2_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");

		int N = Integer.parseInt(srr[0]);
		int M = Integer.parseInt(srr[1]);
		int K = Integer.parseInt(srr[2]);

		int[] nums = new int[N];
		srr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(srr[i]);
		}

		// 배열 정렬하고, 가장 큰 수, 두번째로 큰 수 가져오기
		Arrays.sort(nums);
		int first = nums[N - 1];
		int second = nums[N - 2];

		// 가장 큰 수가 더해지는 횟수 계산
		int cnt = (M / (K + 1)) * K; // (K번의 가장 큰 수 + 1번의 두번째로 큰 수)가 나오는 횟수 x 가장 큰 수가 나오는 횟수
										// 덩어리 x 가장 큰수가 나오는 횟수
		cnt += (M % (K + 1)); // M이 딱 나누어 떨어지지 않을때, 뒤에 남아있는 가장 큰수 들의 횟수까지 고려해줌

		int result = 0;
		result += cnt * first; // 가장 큰 수 더하기
		result += (M - cnt) * second; // 두번째로 큰 수 더하기
		
		System.out.println(result);
	}

}
