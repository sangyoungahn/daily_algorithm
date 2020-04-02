package programmers;

import java.util.ArrayList;

public class Greedy_체육복 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {3};
		int okMember = n - lost.length;
		
		//도난 당한 학생 리스트
		ArrayList<Integer> lostList = new ArrayList<>();
		for(int i=0; i<lost.length; i++) {
			lostList.add(lost[i]);
		}
		//여분의 옷 가지고 있는 학생 리스트
		ArrayList<Integer> reserveList = new ArrayList<>();
		for(int i=0; i<reserve.length; i++) {
			reserveList.add(reserve[i]);
		}
		//여분의 옷을 가지고 온 학생이 잃어버렸을 경우
		//(여분의 옷은 사라지고 자기옷만 남음 -> 자기는 체육수업을 들을 수 있음)
		for(int i=0; i<lostList.size(); i++) {
			for(int j=0; j<reserveList.size(); j++) {
				if(lostList.get(i) == reserveList.get(j)) {
					lostList.remove(i);
					reserveList.remove(j);
					i--;	//lostList를 한 단계 앞으로 되돌아가서 탐색해야하므로
					okMember++;	//잃어버렸어도 자기는 체육복이 하나 있기 때문에 체육수업에 참석 가능
					break;
				}
			}
		}
		//여분의 옷을 가지고 온 학생이 잃어버린 학생에게 빌려줄 수 있는 경우
		for(int i=0; i<lostList.size(); i++) {
			int lostNum = lostList.get(i);
			for(int j=0; j<reserveList.size(); j++) {
				int reserveNum = reserveList.get(j);
				if(lostNum == reserveNum-1 || lostNum == reserveNum+1) {
					reserveList.remove(j);
					okMember++;
					break;	//옷을 빌려줄 있는 학생을 찾았으면 지우고, 다음 옷을 잃어버린 사람을 찾기 위해 가장자리 for문으로 이동
				}
			}
		}
		System.out.println(okMember);
	}

}
