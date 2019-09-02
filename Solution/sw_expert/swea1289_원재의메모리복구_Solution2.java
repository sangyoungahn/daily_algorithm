import java.util.Scanner;

public class swea1289_원재의메모리복구_강사님2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tcn=1; tcn<=T; tcn++){
			char[ ] arr = sc.next().toCharArray();

			int count = 0;
			if(arr[0]=='1'){
				count = 1;
				if(arr[1]=='0')count++;
			}else {
				if(arr[1]=='1')count++;	//11 -> count++???
			}

			for(int i=1; i<arr.length-1; i++){
				if(arr[i]!=arr[i+1]) count++;
			}
			System.out.println("#"+tcn+" "+count);
		}//tcn for
	}
}




