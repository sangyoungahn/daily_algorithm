import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA4366_정식이의은행업무 {
	static int[] twoBaseArr;
	static int[] threeBaseArr;
	static int twoBaseLeng;
	static int threeBaseLeng;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int ans=0;
			
			//문자열로 입력받음
			String twoBase = br.readLine();
			String threeBase = br.readLine();
			
			//입력받은 문자열의 길이
			twoBaseLeng = twoBase.length();		//1010
			threeBaseLeng = threeBase.length();	//212
			
			//int로 변환해서 넣을 배열 생성
			twoBaseArr = new int[twoBaseLeng];
			threeBaseArr = new int[threeBaseLeng];
			
			//int형 배열에 값 주입
			for(int i=0; i<twoBaseLeng; i++) {
				twoBaseArr[i] = twoBase.charAt(i) - '0';	//문자열 각각을 숫자로 변경
//				System.out.println("twoBaseArr["+i+"] : "+twoBaseArr[i]);
			}
			//int형 배열에 값 주입
			for(int i=0; i<threeBaseLeng; i++) {
				threeBaseArr[i] = threeBase.charAt(i) - '0';	//문자열 각각을 숫자로 변경\
//				System.out.println("threeBaseArr["+i+"] : "+threeBaseArr[i]);
			}
			
			ans = searchEqualValue();
			
			System.out.println("#"+tc+" "+ans);
		}//tc
	}

	//2진수, 3진수 중 같은 숫자 찾기
	private static int searchEqualValue() {
		//10진수로 변경한 값을 저장할 배열
		int[] value2 = new int[twoBaseLeng];
		int[][] value3 = new int[threeBaseLeng][2];	//2 - 0,1,2마다 모든 케이스를 고려해야함
		
		//2진수의 각자리를 하나씩 변경해보면서 값을 value배열에 저장
		for(int i=0; i<twoBaseLeng; i++) {
			//원래의 값을 복제해야 원래의 값을 쓸 수 있음
			int[] change2 = twoBaseArr.clone();
			
			//0->1, 1->0
			if(twoBaseArr[i]==0)	change2[i]=1;
			else					change2[i]=0;
			
			//2진수 -> 10진수
			value2[i] = tenBase(change2, 2);
		}
		
		//3진수의 각자리를 하나씩 변경해보면서 값을 value배열에 저장
		//0->1, 1->2, 2->0
		for(int j=0; j<threeBaseLeng; j++) {
			//원래의 값을 복제해야 원래의 값을 쓸 수 있음
			int[] change3 = threeBaseArr.clone();	//212
			
			//★★★★★총 3번을 반복하면 처음에 0인 원소는 '0->1, 1->2, 2->3' 이렇게 모든 경우의 숫자를 구할 수 있음
			//처음에 0인 원소 : '0->1, 1->2, 2->3'
			//처음에 1인 원소 : '1->2, 2->3, 0->1'
			//처음에 2인 원소 : '2->3, 0->1, 1->2'
			for(int changeCnt=0; changeCnt<2; changeCnt++) {
				if(change3[j]==0)		change3[j]=1;
				else if(change3[j]==1)	change3[j]=2;
				else					change3[j]=0;
				
				//3진수 -> 10진수
				value3[j][changeCnt] = tenBase(change3, 3);
//				System.out.println("value3["+j+"]"+"["+changeCnt+"] : "+value3[j][changeCnt]);
			}
		}

		//'2진수->10진수'값과 '3진수->10진수'값이 동일한 것이 있는지 탐색
		for(int i=0; i<twoBaseLeng; i++) {
			for(int j=0; j<threeBaseLeng; j++) {
				for(int cnt=0; cnt<2; cnt++) {
					if(value2[i] == value3[j][cnt]) {
						return value2[i];
					}
				}
			}
		}
		
		//같은 값을 못 찾았을 경우 0을 리턴
		return 0;
	}

	//10진수로 변경하는 함수
	private static int tenBase(int[] input, int baseType) {
		int tenValue = 0;
		
		for(int i=0; i<input.length; i++) {
			//각 자리수마다 구해서 더해줘야 함
			tenValue += (int) (Math.pow(baseType, (input.length-1)-i) * input[i]);
//			System.out.println("tenValue : "+tenValue);
		}
		return tenValue;
		
	}
	
}
