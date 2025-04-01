import java.util.*;

class Solution {

    List<String> answer;
    boolean[] visited;

    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }

    public void dfs(String cur, String path, String[][] tickets, int count) {
        if (count == tickets.length) {
            answer.add(path);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }


    }
}
