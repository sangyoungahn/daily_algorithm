package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class programmers_여행경로 {
    //
    static List<String> routes = new ArrayList<>();
    static String route;
    static boolean[] visited;

    public static void main(String[] args) {
        //
        String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
                { "ATL", "SFO" } };

        visited = new boolean[tickets.length];
        for(int i=0; i< tickets.length; i++){
            String start = tickets[i][0];
            String end = tickets[i][1];

            if(start.equals("ICN")) {
                route = start + ",";
                visited[i] = true;
                dfs(tickets, end, 1);
                visited[i] = false;
            }
        }

        Collections.sort(routes);
        // [ICN,ATL,ICN,SFO,ATL,SFO,, ICN,ATL,SFO,ATL,ICN,SFO,, ICN,SFO,ATL,ICN,ATL,SFO,]
        String[] answer = routes.get(0).split(",");
        System.out.println(Arrays.toString(answer));
    }

    public static void dfs(String[][] tickets, String end, int cnt) {
        //
        route += end + ",";

        // 모든 배열 다 탐색했을 경우
        if(cnt == tickets.length) {
            routes.add(route);
            return;
        }

        // 모든 배열 다 탐색하지 못 했을 경우
        for(int i=0; i< tickets.length; i++) {
            String nextStart = tickets[i][0];
            String nextEnd = tickets[i][1];

            // 다음으로 탐색할 start(= nextStart)가 현재의 end(=end)와 같다면 다음 단계 탐색
            if(nextStart.equals(end) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, nextEnd, cnt+1);
                visited[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }
}
