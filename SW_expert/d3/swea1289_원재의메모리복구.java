import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1289_원재의메모리복구_My2 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String str = br.readLine();
			int size = str.length();
			char[] chArr = new char[size];
			int cnt=0;
			
			for(int i=0; i<size; i++) {
				chArr[i]=str.charAt(i);
//				System.out.println(chArr[i]);
			}
			
			for(int i=0;i<size-1;i++) {
				if(chArr[0] == 1) {	//맨 앞자리가 1일 경우
					if(chArr[1] == 0) {
						cnt++;
					} else if(chArr[1] == 1) {
						
					}
				} else {	//앞자리가 1이 아닐 경우
					if(chArr[i] != chArr[i+1]) {
						cnt++;
						System.out.println("2 : "+cnt);
					}
				}
				
			}
			System.out.println("#"+tc+" "+cnt);
			
		}//tc for
	}//main
		

}
