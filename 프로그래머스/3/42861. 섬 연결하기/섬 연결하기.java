import java.util.*;


class Solution {

    int[] parent;

    public int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa < pb) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        parent = new int[costs.length+ 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            if (find(a) != find(b)) {
                union(a, b);
                answer += cost[2];
            }
        }
        return answer;

    }
}