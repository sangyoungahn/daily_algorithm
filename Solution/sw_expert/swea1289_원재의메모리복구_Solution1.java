import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1289_원재의메모리복구_Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			char[] str = br.readLine().toCharArray();
			char[] arr = new char[str.length];
			for(int i=0; i<arr.length;i++)	arr[i] = '0';
			int cnt=0;
			
			for(int i=0;i<str.length;i++) {
				if(str[i] == arr[i])	continue;
				cnt++;
				for(int j=i;j<str.length;j++) {
					if(arr[j] == '0')
						arr[j] = '1';
					else
						arr[j] = '0';
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

}
