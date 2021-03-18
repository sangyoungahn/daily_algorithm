package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2661_좋은수열 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		backtraking("");
	}

	private static void backtraking(String result) {
		if(result.length() == N) {
			System.out.println(result);
			System.exit(0);	//현재 실행하고 있는 프로세스를 강제 종료
		} else {
			for(int i=1; i<=3; i++) {
				if(isGoodSequence(result + i)) {
					//나쁜수열이면(= 인접한 동일한 수열이 있다면) 계속 길이를 늘리면서 탐색 -> 좋은 수열을 찾아야하므로
					backtraking(result + i);
				}
			}
		}
	}

	private static boolean isGoodSequence(String s) {
		int length = s.length() / 2;
		
		for(int i=1; i<=length; i++) {
			if(s.substring(s.length()-i).equals(s.substring(s.length()-(2*i), s.length()-i))) {
				return false;
			}
		}
		
		return true;
	}

}
