import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class swea1289_원재의메모리복구_강사님3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tcn=1; tcn<=T; tcn++){
			char[ ] arr = sc.next().toCharArray();

			int count = 0;
			for(int i=arr.length-1; i>=1; i--){//100            
				if(arr[i]!=arr[i-1]){
					count++;               
				}
			}
			if(arr[0]=='1') {
				count++;            
			}
			System.out.println("#"+tcn+" "+count);
		}//tcn for
	}
}
