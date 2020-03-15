package sort;

import java.util.Arrays;

public class K번째수 {
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int num = commands.length;
		int[] answer = new int[num];
		int ansCnt = 0;
		for (int i = 0; i < num; i++) {
			int first = commands[i][0]-1;
			int second = commands[i][1]-1;
			int third = commands[i][2]-1;
			System.out.println("first : " + first);
			System.out.println("second : " + second);
			System.out.println("third : " + third);
			
			//새로운 배열 temp에 값 넣기
			int size = second - first + 1;
			int[] temp = new int[size];
			int cnt = 0;
			for(int k=first; k<=second; k++) {
				temp[cnt] = array[k];
				cnt++;
			}
			Arrays.sort(temp);
			System.out.println(Arrays.toString(temp));
			
			answer[ansCnt] = temp[third];
			ansCnt++;
		}
		
		System.out.println(Arrays.toString(answer)); 
		
	}
}
