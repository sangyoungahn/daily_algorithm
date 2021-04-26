package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 실전3_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		int N = Integer.parseInt(srr[0]);
		int M = Integer.parseInt(srr[1]);

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			srr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(srr[j]);
			}
		}

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				if (min > map[i][j]) {
					min = map[i][j];
				}
			}
			list.add(min); // 행마다 가장 작은 값을 list에 넣음
		}

		// 오름차순 정렬
		Collections.sort(list);
		System.out.println(list.get(list.size() - 1));

		// list output test
		for (int i = 0; i < N; i++) {
			System.out.println(list.get(i) + " ");
		}

		// output test
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

}
