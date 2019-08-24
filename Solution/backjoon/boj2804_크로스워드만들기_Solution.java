import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2804_크로스워드만들기_보충 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = reader.readLine().split(" ");
		char[] arr = srr[0].toCharArray();
		char[] brr = srr[1].toCharArray();
		int aLen = arr.length;
		int bLen = brr.length;
		int ca=0, cb=0;		//문제에서 같은 글자를 0개 찾으면 -1로 해야함
		outer:for(int i=0;i<aLen;i++) {
			for(int j=0;j<bLen;j++) {
				if(arr[i] == brr[j]) {
					ca = i;
					cb = j;
					break outer;
				}
			}
		}
		
		for(int i=0;i<bLen;i++) {
			for(int j=0;j<aLen;j++) {
				if(cb == i) {
					System.out.print(arr[j]);
				}else if(ca == j){
					System.out.print(brr[i]);
				}else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
	
}
