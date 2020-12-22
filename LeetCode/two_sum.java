import java.util.Arrays;

public class two_sum {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
        int[] result = new int[2];  //결과값 배열
		
        result = twoSum(nums, target);
        
        System.out.println(Arrays.toString(result));
	}
	
	public static int[] twoSum(int[] nums, int target) {
        int arrSize = nums.length;
        int[] result = new int[2];  //결과값 배열
        
        for(int i=0; i<arrSize; i++){
            for(int j=i+1; j<arrSize; j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }//for
        }//for
        
        return result;
    }
}
