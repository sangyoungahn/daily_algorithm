/*
 * 1. Ǯ�̽ð� : 43��
 * 2. Ǯ�̹�� : ��� ���̽��� ������ ����Ž������ Ǯ�����ϴ�.
                ����� 2�� ���� ��, ����� 2�� �̻� ���� ���� ū ���ַ� �ý��ϴ�.
                ù��° for������ ������ �Ǵ� ����� ���, �ι�° for������ �� ��� ����� ��ҽ��ϴ�.
                "������ �Ǵ� ��� >= �� ��� ���", "������ �Ǵ� ��� < �� ��� ���" ���̽��� ���� ���̸� ���� ���ؼ�
                max�� ���� Ŭ ��� max���� �ֽ�ȭ�ϴ� ����� ����߽��ϴ�.
 * 3. ���� �ð����⵵ : O(n^2)
 */
public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] height = {1,2,1};
		int result = maxArea(height);
		
		System.out.println(result);
	}
	public static int maxArea(int[] height) {
        int num = height.length;
        int area = 0;
        int max = 0;
        
        for(int i=0; i<num; i++){
            for(int j=i+1; j<num; j++){
                //����� ������ 2���ۿ� ���� ���
                if(num==2){
                    //����� ���� 2�� �� �ϳ��� 0�̸�
                    if(height[i]==0 || height[j]==0)
                        area = 0;
                    //�� �� 0�� �ƴ� ���
                    else if(height[i]!=0 || height[j]!=0){
                        //���� ��� ���� < ������ ��� ����
                        if(height[i] < height[j])
                            area = (height[j] - height[i]) * 1;
                        //���� ��� ���� > ������ ��� ����
                        else if(height[i] > height[j])
                            area = (height[i] - height[j]) * 1;
                        //���� ��� ���� = ������ ��� ����
                        else
                            area = height[j] * 1;
                    }
                }
                //����� ������ 2�� �̻��� ���
                else{
                    //���� ��� ���� >= ������ ��� ����
                    if(height[i]>=height[j])
                        area = (j-i) * height[j];   // ���� = ���� * ����
                    //���� ��� ���� < ������ ��� ����
                    else if(height[i]<height[j])
                        area = (j-i) * height[i];
                }
                
                //���� ū ���� ã��
                if(area > max)
                        max = area;
            }
        }
        
        return max;
    }
}
