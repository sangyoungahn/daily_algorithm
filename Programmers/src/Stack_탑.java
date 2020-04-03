package programmers;

import java.util.Arrays;

public class Stack_탑 {

	public static void main(String[] args) {
		int[] heights = {6,9,5,7,4};
		int[] answer = new int[heights.length];
		
		for(int i=heights.length-1; i>0; i--) {
			for(int j=i-1; j>=0; j--) {
				if(heights[j] > heights[i]) {
					answer[i] = j+1;
					break;
				}
				if(j==0)
					answer[i] = 0;
			}
		}
//		System.out.println(Arrays.toString(answer));
	}

}
