import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();

		while (N > 0) {
			deque.push(N);
			N -= 1;
		}

		while (deque.size() != 1) {
			deque.pop();
			int top = deque.pop();
			deque.add(top);
		}
		System.out.println(deque.pop());

	}
}
