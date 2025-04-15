class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = String.valueOf(n);
        
        for(int i = 0; i < str.length() ;i ++){
            char ch = str.charAt(i);
            int number = Character.getNumericValue(ch);
            answer += number;
        }
        return answer;
    }
}