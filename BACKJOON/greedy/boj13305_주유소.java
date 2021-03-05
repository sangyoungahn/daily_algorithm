package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 풀이시간 : 15분
 * 2. 예상 시간복잡도 : O(n)
 * 3. 풀이방법
 * 	(1) 주유소당 리터의 가격이 가장 작은 값을 뽑아냄
 * 	(2) 주유소 리터의 가격이 가장 작은 값일 경우 -> 남은 도로의 길이 x  해당 주유소의 리터의 가격
 * 	(3) 주유소 리터의 가격이 가장 작은 값이 아닐 경우
 * 		-> 전의 가장 작은 값을 유지, 더 작은 가격이 나올 때까지 도로의 길이를 더해줌
 * 	결국, 이전 가격과 다음 가격을 비교하는 과정이 필요
 */
public class boj13305_주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] road = new int[N - 1];
		int[] cost = new int[N];
		int minCost = 0;
		int sumLoad = 0;
		int tempSum = 0;
		int sum = 0;

		// 도로의 길이 입력
		String[] srr = br.readLine().split(" ");
		for (int i = 0; i < srr.length; i++) {
			road[i] = Integer.parseInt(srr[i]);
		}

		// 주유소의 리터당 가격 입력
		srr = br.readLine().split(" ");
		for (int i = 0; i < srr.length; i++) {
			cost[i] = Integer.parseInt(srr[i]);
		}

		minCost = cost[0];
		sumLoad = 0;
		// 현재 가격과 다음 가격을 비교하는 로직
		for (int i = 0; i < cost.length-1; i++) {
			// "minCost <= 현재 도로의 가격" 조건을 만족해야 도로의 길이를 더할 수 있음
			if (minCost <= cost[i]) {
				System.out.println("minCost(" + minCost + ") <= 현재 도로의 가격(" + cost[i] + ")");
				System.out.println("minCost : " + minCost);
				System.out.println("road[" + i + "] : " + road[i]);
				sumLoad += road[i];
				System.out.println("sumLoad : " + sumLoad);

				// 마지막 인덱스일 경우 더하기
				if (i == cost.length - 2) {
					System.out.println("마지막 인덱스");
					tempSum = sumLoad * minCost;
				}
			}
			// "현재 도로의 가격 > minCost"일 경우 -> 현재 가격으로 minCost를 변경, 더한 도로의 길이 초기화
			else {
				System.out.println("현재 도로의 가격(" + cost[i] + ") > minCost(" + minCost + ")");
				tempSum = sumLoad * minCost;
				System.out.println("tempSum : " + tempSum);
				minCost = cost[i];
				System.out.println("minCost : " + minCost);
				sumLoad = 0;
			}
			sum += tempSum;
		}
		
		System.out.println(sum);
	}

}
