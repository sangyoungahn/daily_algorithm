package level3;
/*
 * 1. 풀이시간 : 1시간 초과
 * 2. 풀이방법
 *      1) 가장 긴 문자열부터 검사하면서 문자열의 길이를 하나씩 줄여나감
        2) 문자열의 시작 위치를 하나씩 증가시키면서 "설정한 문자열의 길이"의 절반 만큼 같은지 비교
        3) 같지 않다면 문자열의 길이를 하나씩 줄이면서 반복
 * 3. 예상 시간복잡도 : O(n^3)
 */
public class 가장긴팰린드롬 {

	public static void main(String[] args) {
		String s = "abacde";

		char[] charArray = s.toCharArray();

		// 가장 긴 문자열부터 하나씩 줄여가며 팰린드롬 검사
		for (int leng = s.length(); leng > 1; leng--) {
			// 시작 위치
			for (int start = 0; start + leng <= s.length(); start++) {
				boolean check = true;

				// 시작 인덱스부터 문자열 길이의 절반만큼 문자가 같은지 비교
				for (int i = 0; i < leng / 2; i++) {
					if (charArray[start + i] != charArray[start + leng - i - 1]) {
						check = false;	//이거 있을때와 없을때 차이 디버깅 해보기
						break;
					}
				}

				// 절반만큼 문자가 같다면 해당 문자열의 길이를 바로 출력
				if (check)
					System.out.println(leng);
			}

		}

		System.out.println(1);
	}

}
