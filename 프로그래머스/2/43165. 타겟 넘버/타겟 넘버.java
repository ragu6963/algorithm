class Solution {
	int target;
	int[] numbers;
	int answer;

	public int solution(int[] numbers, int target) {
		answer = 0;
		this.target = target;
		this.numbers = numbers;

		dfs(0, 0);

		System.out.println(answer);
		return answer;
	}

	public void dfs(int total, int index) {
		if (index == numbers.length) {
			if (total == target) {
				answer++;
			}
			return;
		}

		dfs(total + numbers[index], index + 1);
		dfs(total - numbers[index], index + 1);

	}
}
