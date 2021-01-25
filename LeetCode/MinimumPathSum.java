import java.util.ArrayList;
import java.util.Collections;
/*
 * 1. Ǯ�̽ð� : �ð� �ʰ�
 * 2. Ǯ�̹��
 * grid�� �� ��ġ���� ���� �� �ִ� ���� ���� ���� ���ϴ� ���� ����
 * ����, ������ �����ڸ��� �� �� �ִ� ��ġ�� ������ �����Ƿ� ��츦 ������ ��������
 * ���� �����ڸ� :  ���� -> -> -> ->
 * ���� �����ڸ� :   ��
                    ��
                    ��
                    ��
 * 3. ���� �ð����⵵ : O(n^2)
 */
public class MinimumPathSum_Solution {
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		int answer = minPathSum(grid);
		
		System.out.println(answer);
    }
	
	public static int minPathSum(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(i==0 && j==0){   //������ġ�̸� �ٽ� �ε��� ��Ž��
                    continue;
                } else if(i==0){    //���� �����ڸ� �κ��� ������ ���� ���� ���ؾ� ��
                    grid[i][j] += grid[i][j-1];
                } else if(j==0){    //���� �����ڸ� �κ��� ���ʿ��� ���� ���� ���ؾ� ��
                    grid[i][j] += grid[i-1][j];
                } else {            //�����ڸ� ���� �ƴ� �κ��� �� �� �ִ� �� �� ���� ���� ������
                    grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
                }
            }
        }
        
        return grid[grid.length-1][grid[0].length-1];
    }
}
