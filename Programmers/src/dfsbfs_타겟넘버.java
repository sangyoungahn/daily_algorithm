import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dfsbfs_타겟넘버 {
    static int answer;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int target = Integer.parseInt(br.readLine());
    	
    	String[] srr = br.readLine().split(" ");
//    	System.out.println(srr.length);
    	int[] numbers = new int[srr.length];
    	for(int i=0; i<srr.length; i++) {
    		numbers[i] = Integer.parseInt(srr[i]);
    	}
    	
    	dfs(target, numbers, 0);

    	System.out.println(answer);
    }
    
    static void dfs(int target, int[] numbers, int numLeng){
        int sum=0;
        if(numLeng==numbers.length){
            for(int i=0; i<numbers.length; i++) {
                sum += numbers[i];
                System.out.println("i : " + i);
                System.out.println("numbers[i] : " + numbers[i]);
                System.out.println("sum : " + sum);
                System.out.println("---------------------------");
            }
            System.out.println("==========================");
            if(sum==target) answer++;
            
            return;
        }else {
        	numbers[numLeng] *= 1;
        	System.out.println("dfs sum(1) : " + sum);
            dfs(target, numbers, numLeng+1);
            
            numbers[numLeng] *= -1;
            System.out.println("dfs sum(-1) : " + sum);
            dfs(target, numbers, numLeng+1);
        }
    }
}