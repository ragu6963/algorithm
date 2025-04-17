
import java.util.*;

class Solution {
	boolean solution(String s) {
		boolean answer = true;
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else if (s.charAt(i) == ')' && !stack.isEmpty()) {
				stack.pop();
			} else {
				answer = false;
				break;
			}
		}
		if (!stack.isEmpty()) {
			answer = false;
		}

		return answer;
	}
}