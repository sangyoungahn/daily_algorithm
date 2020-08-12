package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj1931_ȸ�ǽǹ��� {
	static class Time implements Comparable<Time> {
		int start;
		int end;
		
		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			//������ �ð� �������� ��������, ������ �ð��� ������ ���۽ð����� ��������
			if(end == o.end) {
				return start - o.start;
			} else {
				return end - o.end;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Time> timeList = new ArrayList<>();
		int finalTime = 0;	//
		int result = 0;
		
		for(int i=0; i<N; i++) {
			String[] srr = br.readLine().split(" ");
			int start = Integer.parseInt(srr[0]);
			int end = Integer.parseInt(srr[1]);
			timeList.add(new Time(start, end));
		}
		
		//����
		Collections.sort(timeList);
		
		//���� ȸ�� ���� �ð� �� ���� ȸ���� ���� �ð�
		for(int i=0; i<N; i++) {
			int startTime = timeList.get(i).start;
			int endTime = timeList.get(i).end;
			//finalTime�� �����ϴ� ���� : ���� ȸ�� �ð���� �ٲٸ� ���� ȸ�ǽð��� ������ ���� ������� ������
			if(startTime >= finalTime) {
				finalTime = endTime;
				result++;
			}
		}
		
		System.out.println(result);
	}

}
