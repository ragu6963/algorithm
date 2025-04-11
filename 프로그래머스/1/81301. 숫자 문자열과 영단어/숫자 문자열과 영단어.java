class Solution {

    public int solution(String s) {
        int answer = 0;

        String[] words = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine"};

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            s = s.replaceAll(word, String.valueOf(i));
        }

        answer = Integer.parseInt(s);
        return answer;
    }
}