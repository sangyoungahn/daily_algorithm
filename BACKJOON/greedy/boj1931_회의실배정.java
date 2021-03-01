package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj1931_회의실배정 {
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
			//끝나는 시간 기준으로 오름차순, 끝나는 시간이 같으면 시작시간으로 오름차순
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
		
		//정렬
		Collections.sort(timeList);
		
		//이전 회의 종료 시간 ≤ 현재 회의의 시작 시간
		for(int i=0; i<N; i++) {
			int startTime = timeList.get(i).start;
			int endTime = timeList.get(i).end;
			//finalTime을 지정하는 이유 : 다음 회의 시간대로 바꾸면 전의 회의시간의 마지막 값이 사라지기 때문에
			if(startTime >= finalTime) {
				finalTime = endTime;
				result++;
			}
		}
		
		System.out.println(result);
	}

}
