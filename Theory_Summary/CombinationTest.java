import java.util.Arrays;

public class CombinationTest {
	static int cnt;
	
	public static void main(String[] args) {
		char[] an = {'A','B','C','D','E'};	//전체 배열
		int n = an.length;	//전체의 개수
		int r = 2;			//뽑을려는 개수
		char[] tr = new char[r];	//뽑을려는 개수 배열
		combination(n, r, an, tr);
		System.out.println("전체 조합의 개수 : " + cnt);
	}

	private static void combination(int n, int r, char[] src, char[] tar) {
//		if() {
//			return;
//		}
		
		if(r == 0) {
			cnt++;
			System.out.println(Arrays.toString(tar));
			return;
		}
		
		if(n < r) {
			return;
		}
		
//		System.out.println("src : " + Arrays.toString(src));
		tar[r-1] = src[n-1];
//		System.out.println("tar : " + Arrays.toString(tar));
		
		combination(n-1, r-1, src, tar);	//n-1(C)r-1
		combination(n-1, r, src, tar);		//n-1(C)r
	}

}
