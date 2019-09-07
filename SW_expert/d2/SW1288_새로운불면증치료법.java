package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1288_새로운불면증치료법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());	//테스트케이스
		for(int t=0;t<T;t++) {
			String str = br.readLine();		//입력받은 값을 문자열로 저장(for문의 반복횟수를 셀 때 필요)
			int N=Integer.parseInt(str);	//입력받은 값을 숫자로 저장(1,2,3...을 곱해줄 때 필요)
			
			//0~9까지 숫자를 모두 봤는지 확인
			boolean[] checked = new boolean[10];	//0~9 숫자 방문여부 체크 배열
			int cnt=0;
			
			int x=1;	//하나씩 증가하면서 곱해줄 변수
			while(true) {
				char[] tmp = str.toCharArray();	//숫자를 자리수마다 잘라서 배열에 넣음
				for(int i=0;i<str.length();i++) {
					int idx=tmp[i] - '0';	//char -> int
					if(checked[idx]==false) {	//값을 아직 방문안했다면
						cnt++;	//방문했으므로 하나 증가
						checked[idx]=true;
					}
				}
				
				//종료조건
				if(cnt==10) {
					break;
				}
				
				x++;	//종료되지 않았다면 하나씩 숫자를 늘려 곱해서 다시 for문을 돔
				str = Integer.toString(N*x);	//다시  String으로 바꿔서 처리해줌
				
			}
			System.out.println("#" + (t+1) + " " + str);
		}
	}

}
