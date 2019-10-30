import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_타일장식물 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	long[] num = new long[N+1];
        num[0] = 1; //고정
        num[1] = 1; //고정
        long cir=0; //둘레
        
        for(int i=2; i<=N; i++) {
            num[i] = num[i-1] + num[i-2];
//            System.out.println("i : " + i);
//            System.out.println("num[i] : " + num[i]);
        }
        
        cir = num[N-1]*2 + num[N]*2;
        
        System.out.println(cir);
    }
}                                                                                                                                                                                                                                                                                                                                                                   