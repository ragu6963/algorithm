import java.util.*;

class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        
        char[] charArray = my_string.toCharArray();
        Arrays.sort(charArray);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< charArray.length; i++) {
            sb.append(charArray[i]);
        }
        
        return sb.toString();
    }
}