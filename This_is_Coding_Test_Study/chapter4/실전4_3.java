package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 실전4_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int row = input.charAt(1) - '0';		// 49 - 48 = 1(아스키코드 사용해서 숫자 만들기)
		int col = input.charAt(0) - 'a' + 1;	// 97('a'아스키코드) - 97('a'아스키코드) + 1 = 1
		
		// 나이트가 이동할 수 있는 8가지 방향
		int[] di = {-1,-1,-2,-2,1,1,2,2};
		int[] dj = {-2,2,-1,1,-2,2,-1,1};
		
		// 8가지 방향에 대해 각 위치로 이동가능한지 확인
		int cnt = 0;
		for(int dir=0; dir<8; dir++) {
			int ni = row + di[dir];
			int nj = col + dj[dir];
			
			// 해당 위치로 이동 가능하면 카운트 증가
			if(ni>=1 && ni<=8 && nj>=1 && nj<=8) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
