package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
 * 1. Ǯ�̽ð� : 45��
 * 2. Ǯ�̹��
        ó���� ["ICN", "~~~"]�� �κ��� ã��
        ["ICN", "~~~"] -> [start, end]
        ["~~~", "###"] -> [nextStart, nextEnd]
        end�� nextStart�� ��ġ�ϴ��� Ȯ���ؼ� ��ġ�ϸ� cnt ������Ű�� ��� Ž�� (��� ȣ��)
        "ICN,SFO,ATL,ICN,ATL,SFO" / "ICN,ATL,ICN,SFO,ATL,SFO" �̷��� ��� ����� ���� list�� ����
        list�� ������ �Ŀ� ���� �տ� ��ġ�ϰ� �ִ� ���ڿ��� �̾Ƽ� ���
 * 3. ���� �ð����⵵ : O(?)
 */
public class ������1 {
	static List<String> list = new ArrayList<>();
	static String route;
	static boolean[] visited;

	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };
		
		visited = new boolean[tickets.length];	// 2���� ����
		for (int i = 0; i < tickets.length; i++) {
			String start = tickets[i][0];
			String end = tickets[i][1];

			// ���� ���� ICN�̸� dfs Ž��
			if (start.equals("ICN")) {
				route = start + ",";
				visited[i] = true;
				dfs(tickets, end, 1);
				visited[i] = false;		// 2���� ����
			}
		}

		Collections.sort(list);
		String[] answer = list.get(0).split(",");

		System.out.println(Arrays.toString(answer));
	}

	public static void dfs(String[][] tickets, String end, int cnt) {
		route += end + ",";

		// ��� �迭�� �� Ž������ ���
		if (cnt == tickets.length) {
			// �ϳ��� ��θ� list�� ����
			// ��� ����� ��ΰ� list�� ��
			list.add(route);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			String nextStart = tickets[i][0];
			String nextEnd = tickets[i][1];

			// �������� Ž���� start(=nextStart)�� ������ end(=end)�� ���ٸ� ���� �ܰ� Ž��
			if (nextStart.equals(end) && !visited[i]) {
				visited[i] = true;
				dfs(tickets, nextEnd, cnt + 1);
				visited[i] = false;
				route = route.substring(0, route.length() - 4);
			}
		}
	}

}
