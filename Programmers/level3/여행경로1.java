package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
 * 1. 풀이시간 : 45분
 * 2. 풀이방법
        처음에 ["ICN", "~~~"]인 부분을 찾음
        ["ICN", "~~~"] -> [start, end]
        ["~~~", "###"] -> [nextStart, nextEnd]
        end와 nextStart가 일치하는지 확인해서 일치하면 cnt 증가시키고 계속 탐색 (재귀 호출)
        "ICN,SFO,ATL,ICN,ATL,SFO" / "ICN,ATL,ICN,SFO,ATL,SFO" 이렇게 모든 경우의 수를 list에 넣음
        list를 정렬한 후에 가장 앞에 위치하고 있는 문자열을 뽑아서 출력
 * 3. 예상 시간복잡도 : O(?)
 */
public class 여행경로1 {
	static List<String> list = new ArrayList<>();
	static String route;
	static boolean[] visited;

	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };
		
		visited = new boolean[tickets.length];	// 2와의 차이
		for (int i = 0; i < tickets.length; i++) {
			String start = tickets[i][0];
			String end = tickets[i][1];

			// 시작 값이 ICN이면 dfs 탐색
			if (start.equals("ICN")) {
				route = start + ",";
				visited[i] = true;
				dfs(tickets, end, 1);
				visited[i] = false;		// 2와의 차이
			}
		}

		Collections.sort(list);
		String[] answer = list.get(0).split(",");

		System.out.println(Arrays.toString(answer));
	}

	public static void dfs(String[][] tickets, String end, int cnt) {
		route += end + ",";

		// 모든 배열을 다 탐색했을 경우
		if (cnt == tickets.length) {
			// 하나의 경로를 list에 넣음
			// 모든 경우의 경로가 list에 들어감
			list.add(route);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			String nextStart = tickets[i][0];
			String nextEnd = tickets[i][1];

			// 다음으로 탐색할 start(=nextStart)가 현재의 end(=end)와 같다면 다음 단계 탐색
			if (nextStart.equals(end) && !visited[i]) {
				visited[i] = true;
				dfs(tickets, nextEnd, cnt + 1);
				visited[i] = false;
				route = route.substring(0, route.length() - 4);
			}
		}
	}

}
