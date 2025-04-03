
import java.util.*;

class Solution {
	public int[] solution(int n, String[] words) {
		int[] answer = {};

		boolean flag = false;

		int[] people = new int[n];
		int peopleIndex = 0;
		people[peopleIndex]++;
		peopleIndex++;

		String prevWord = words[0];
		HashSet<String> wordSet = new HashSet<>();
		wordSet.add(prevWord);

		for (int i = 1; i < words.length; i++) {
			prevWord = words[i - 1];
			char prevLastChar = prevWord.charAt(prevWord.length() - 1);

			String currWord = words[i];
			char currFirstChar = currWord.charAt(0);
			people[peopleIndex]++;

			if (currWord.length() == 1) {
				flag = true;
				answer = new int[]{peopleIndex + 1, people[peopleIndex]};
				break;
			}
			if (prevLastChar != currFirstChar) {
				flag = true;
				answer = new int[]{peopleIndex + 1, people[peopleIndex]};
				break;
			}

			if (wordSet.contains(currWord)) {
				flag = true;
				answer = new int[]{peopleIndex + 1, people[peopleIndex]};
				break;
			}

			wordSet.add(currWord);

			peopleIndex++;
			if (peopleIndex == n) {
				peopleIndex = 0;
			}
		}

		if (!flag) {
			answer = new int[]{0, 0};
		}

		return answer;
	}
}
