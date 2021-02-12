package summer_winter_coding;

import java.util.ArrayList;
/*
 * 1. Ǯ�̽ð� : 1�ð� 30��
 * 2. Ǯ�̹��
     ������ �����ߴ� �ܾ� or �տ� ����� ���� �ܾ��� �� ���ڿ� ��ġ���� �ʴ� ���� ������ �ܾ�
     hello, one / even, never / "now", world / draw -> [1�� ���, 3��° ȸ��]
       0     1      2     3       4      5      6
     
     (1) for�� -> ��, �� �ܾ��� ���� ��ġ ���� �Ǵ�
         s������ ���� : words[i].charAt(words.length() - 1)
         ù���� ���� : words[i+1].charAt(0)
     (2) ������ �ܾ� ArrayList�� ���� -> �ش� �ܾ ArrayList�� ���ԵǾ� �ִ��� Ȯ���ؼ� �ִٸ� ����
     
     ���ǿ� �������� �ʴ� �ܾ��� now�� index : 4
     �� �� ��° ������� ���ϴ� ��� : ((4 + 1) % 2) + 1 -> ((index+1) % n) + 1
        -> index �������� index+1 �� ���ڿ��� ���ؾ��ϹǷ� (index+1)�� ����
     �� �� ȸ������ ���ϴ� ��� : for�� ���鼭 (index % n) == 0 �̸� rotationCnt�� ����
        -> rotationCnt�� �ʱⰪ�� 1�� �־���(index ���� ���� index, �� index+1 �� �� ���ؾ��ϱ� ����)
        -> ��, �� �ܾ��� ���ڰ� �ٸ��ų�, �տ� ���Դ� �ܾ ���� ��� break�� ���������µ�
            �� �� �ܰ迡�� turnSeq�� �ϳ� �������������
            (���� ȸ���� ������ ������ ����� break�� ���� ���� �ö󰡼� turnSeq�� ���������� �� ����)
 * 3. ���� �ð����⵵ : O(n)
 */
public class programmers_������ձ� {

	public static void main(String[] args) {
		int n = 2;
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		
		int[] answer = {};
        ArrayList<String> check = new ArrayList<String>();  // ������ ���ڵ��� �־�δ� list
        int personSeq = 0;  // �� ��° �������
        int turnSeq = 0;    // �� ȸ������
        
        // ��, �� �ܾ� ���� ��ġ ���� Ȯ��
        for(int i=0; i<words.length-1; i++){
            if( (i%n) == 0 ){
                turnSeq++;
            }
            
//            System.out.println("if ����");
//            System.out.println("�ڡڡ� i : " + i);
//            System.out.println("�ڡڡ� turnSeq : " + turnSeq);
            // ��, �� �ܾ��� ���ڰ� ��ġ�ϰ�, �տ� ���Դ� �ܾ ������ ������ -> list�� �ܾ� ����(���� �뵵)
            if( (words[i].charAt(words[i].length() - 1) == words[i+1].charAt(0)) && (!check.contains(words[i+1])) ) {
//                System.out.println("���ǿ� ����");
//                System.out.println("words[" + i + "] : " + words[i] + " / " + "words[" + (i+1) + "] : " + words[i+1]);
                check.add(words[i]);
            }
            // ��, �� �ܾ��� ���ڰ� �ٸ��ų�, �տ� ���Դ� �ܾ ���ϸ� -> �� ��° �������, �� ȸ������ ����
            else if( (words[i].charAt(words[i].length() - 1) != words[i+1].charAt(0)) || (check.contains(words[i+1])) ) {
//                System.out.println("���ǿ� ����X");
//                System.out.println("words[" + i + "] : " + words[i] + " / " + "words[" + (i+1) + "] : " + words[i+1]);
                personSeq = ((i+1) % n) + 1;
                
//                System.out.println("break ����");
//                System.out.println("�ڡڡ� turnSeq : " + turnSeq);
                // ȸ���� ������ �����̸� turnSeq�� �ϳ� �� ����������(break�� ���� �����������ν� �ڿ��� turnSeq�� �� ���������ֹǷ�)
                if(i%n == n-1) {
                    turnSeq++;
                }
                break;
            }
        }
        // Ż���ڰ� �߻����� �ʴ´ٸ�
        if(personSeq == 0){
            answer = new int[] {0, 0};
        }
        // Ż���ڰ� �߻��ߴٸ�
        else {
            answer = new int[] {personSeq, turnSeq};
        }
        
        System.out.println("�� ��° ���? : " + personSeq);
        System.out.println("�� ȸ��? : " + turnSeq);
	}

}
