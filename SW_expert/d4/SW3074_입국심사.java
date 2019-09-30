import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW3074_입국심사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] srr = br.readLine().split(" ");
			long N=Integer.parseInt(srr[0]);
			long M=Integer.parseInt(srr[1]);
			
			int[] area = new int[(int) N];
			int maxTime = 0;
			
			long minVal = 1;
			long maxVal = 0;
			
			long calVal = 0;
			long result = 0;
			
			for(int i=0; i<N; i++) {	//N개 만큼 입국심사대 받음
				area[i]=Integer.parseInt(br.readLine());
			}
			
//			//output test
//			for(int i=0; i<N; i++) {	//N개 만큼 입국심사대 받음
//				System.out.println(area[i]+" ");
//			}
			
			for(int i=0; i<N; i++) {
				if(area[i]>maxTime)	maxTime=area[i];
			}
			maxVal = maxTime * M;	//10 * 6
			
			long left = minVal;		//left=1
			long right = maxVal;	//right=60
			
			while(true) {
				long mid = (left + right) / 2;
//				System.out.println("mid : " + mid);
//				System.out.print("left : " + left);
//				System.out.println(", right : " + right);
				
				calVal=0;
				for(int i=0; i<area.length; i++) {
					calVal += mid/area[i];
				}
//				System.out.println("calVal : " + calVal);
//				System.out.println("=====================");
				
				if(calVal>=M) {
					right = mid-1;
				} else {
					left = mid+1;
				}
				
				if(left>right) {
					result = left;
					break;
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}//tc
	}

}
