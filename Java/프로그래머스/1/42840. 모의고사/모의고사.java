import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] studentA = new int[] {1, 2, 3, 4, 5};
        int[] studentB = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] studentC = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int correctA = 0;
        int correctB = 0;
        int correctC = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == studentA[i%5]) {
                correctA ++;
            }
            
            if (answers[i] == studentB[i%8]) {
                correctB ++;
            }
            
            if (answers[i] == studentC[i%10]) {
                correctC ++;
            }
        }
        
        
        
        // 최대 정답 수 찾기
        int maxCorrect = Math.max(correctA, Math.max(correctB, correctC));
        
        // 최대 정답 수와 같은 학생들 리스트 생성
        List<Integer> result = new ArrayList<>();
        if (correctA == maxCorrect) {
            result.add(1);
        }
        if (correctB == maxCorrect) {
            result.add(2);
        }
        if (correctC == maxCorrect) {
            result.add(3);
        }
        
        // 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}