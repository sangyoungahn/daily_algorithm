package boj1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1149_RGB거리_My {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] list = new int[N+1][N];	//집에 R,G,B를 칠하는 비용을 저장
		int[][] dp = new int[N+1][N];		//해당 집까지 걸리는 최소 비용
		
		for(int i=1; i<=N; i++) {	//i-집의 번호(1,2,3)
			String[] srr = br.readLine().split(" ");
			list[i][0] = Integer.parseInt(srr[0]);
			list[i][1] = Integer.parseInt(srr[1]);
			list[i][2] = Integer.parseInt(srr[2]);
		}//모든 집에 R,G,B칠하는 비용 다 받음
		
		//첫번째 집까지 칠할 때의 최소 비용 -> 첫번째 집의 색칠 비용 그 자체가 됨
		dp[1][0] = list[1][0];	//R
		dp[1][1] = list[1][1];	//G
		dp[1][2] = list[1][2];	//B
		
		//두번째 집까지 칠하는데 최소값 -> 칠하려고 하는 색깔 제외한 것 2개의 최소값(바로 전 단계) + 지금 칠하려고 하는 색깔(현재 단계)
		for(int i=2; i<=N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + list[i][0];	//R
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + list[i][1];	//G
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + list[i][2];	//B
		}
		
		int min = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
		System.out.println(min);
	}

}
