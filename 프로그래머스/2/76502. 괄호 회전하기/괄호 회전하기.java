
import java.util.*;

class Solution {
	public int solution(String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			if (is_validate(s)) {
				answer++;
			}
			s = rotate(s);
		}
		return answer;
	}

	public boolean is_validate(String s) {
		Stack<Character> left = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '{' || c == '[' || c == '(') {
				left.add(c);

			} else {
				if (left.isEmpty()) {
					return false;
				}

				char top = left.peek();

				if (c == '}' && top != '{') {
					return false;
				}

				if (c == ')' && top != '(') {
					return false;
				}

				if (c == ']' && top != '[') {
					return false;
				}
				left.pop();
			}
		}
		if(!left.isEmpty()){
			return false;
		}

		return true;
	}

	public String rotate(String s) {
		String newString = s.substring(1) + s.charAt(0);
		return newString;
	}
}