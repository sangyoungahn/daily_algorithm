import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dfsbfs_타겟넘버2 {
    static int answer;
    static boolean[] checked;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int target = Integer.parseInt(br.readLine());
    	
    	String[] srr = br.readLine().split(" ");
    	int[] numbers = new int[srr.length];
    	for(int i=0; i<srr.length; i++) {
    		numbers[i] = Integer.parseInt(srr[i]);
    	}
    	
    	checked = new boolean[numbers.length];
        dfs(target, numbers, 0);

    	System.out.println(answer);
    }
    
    static void dfs(int target, int[] numbers, int numLeng){
        int sum=0;
        
        if(numLeng==numbers.length){
            System.out.println(Arrays.toString(checked));
            
            for(int i=0; i<checked.length; i++){
                if(checked[i]){		//방문한 것(true인 것)이면 더한다(+1)
                    sum += numbers[i];      
                }else{
                    sum -= numbers[i];
                }
            }
            if(sum == target) answer++;
            
            return;
        }else {
            checked[numLeng]=true;
            dfs(target, numbers, numLeng+1);
            
            checked[numLeng]=false;
            dfs(target, numbers, numLeng+1);
           
        }
    }
}