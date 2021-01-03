/*
 * 1. Ǯ�̽ð� : 50��
 * 2. Ǯ�̹�� : ���ӵ� ���� �и� ������ �˰� �Ǵϱ� ¦�� �ε����� Ȧ�� �ε��� �̷��� ������ �ִ밪�� ������.
                �׷��� �̷��� �Ǹ� ������ ��ĭ�� �پ�Ѿ ������ ������, ��ĭ�� �پ�Ѿ ������ �� �� ū���� �����⵵ ��.
                ���� Ȧ�� �ε���, ¦�� �ε��� �̷��� ������ ���ϵ�
                Ȧ�� �ε����� ���� ������ ¦�� �ε���Ʋ ���� ���� �� ũ�ٸ� Ȧ�� �ε������� ���� ���� ¦�� �ε������� ���� ���� �ֽ��ϴ�.
                ��, Ȧ�� �ε������� ���ϵ�, ¦�� �ε������� ���ϵ� ���� �ִ밪�� ������Ű�鼭 ���ϴ� ����� ����߽��ϴ�.
 * 3. ���� �ð����⵵ : O(n)
 */
public class HouseRobber {

	public static void main(String[] args) {
		int[] num = {4,1,2,1,3,11};
		int result = 0;
		
		result = rob(num);
		
		System.out.println(result);
	}
	
	public static int rob(int[] num) {
        int sumEven = 0;
        int sumOdd = 0;
        
        for(int i=0; i<num.length; i++){
            //¦�� �ε����� ���
            if(i%2 == 0){
                sumEven = Math.max(sumEven + num[i], sumOdd);
            }
            //Ȧ�� �ε����� ���
            else{
                sumOdd = Math.max(sumOdd + num[i], sumEven);
            }
        }
        
	    return Math.max(sumEven, sumOdd);
    }

}
