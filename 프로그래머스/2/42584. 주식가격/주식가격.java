
import java.util.*;

class Solution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			int curPrice = prices[i];
			while (!stack.isEmpty() && curPrice < prices[stack.peek()]) {
				int j = stack.pop();
				answer[j] = i - j;
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int top = stack.pop();
			answer[top] = prices.length - 1 - top;
		}

		return answer;
	}
}