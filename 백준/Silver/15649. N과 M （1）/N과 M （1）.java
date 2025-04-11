import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
//        br = new BufferedReader(new FileReader("input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(0, "");

    }

    public static void dfs(int node, String route) {
        if (route.length() == M) {
            StringBuilder sb = new StringBuilder();
            for (char ch : route.toCharArray()) {
                sb.append(ch + " ");
            }
            System.out.println(sb);
        }

        for (int i = 1; i < N + 1; i++) {
            if (!route.contains(String.valueOf(i))) {
                dfs(i, route + i);
            }
        }
    }
}
