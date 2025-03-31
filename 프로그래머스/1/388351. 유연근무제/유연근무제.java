import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int arrivalCount = 0;
            for (int j = 0; j < 7; j++) {
                int dayOfWeek = (startday + j - 1) % 7 + 1; // 현재 요일 계산
                if (dayOfWeek >= 6) continue; // 주말 제외
                
                int arrivalTime = timelogs[i][j];
                int latestAllowedTime = schedules[i] + 10;
                
                // 분이 60을 넘어가면 시간 조정
                if (latestAllowedTime % 100 >= 60) {
                    latestAllowedTime = (latestAllowedTime / 100 + 1) * 100 + (latestAllowedTime % 100 - 60);
                }
                
                if (arrivalTime <= latestAllowedTime) {
                    arrivalCount++;
                }
            }
            
            if (arrivalCount >= 5) { // 평일 5일 이상 출근 성공 시 상품 지급
                count++;
            }
        }
        
        return count;
    }
}