package Challenge;

import java.util.Arrays;

public class ScoreSolution {
    public String solution(int[][] scores) {
        String answer = "";
        int len = scores.length;

        // 1) 자신의 점수를 담은 배열을 선언하고 초기화 하는 작업
        int[][] myScores = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                myScores[i][j] = scores[j][i];
            }
        }

        for (int i = 0; i < len; i++) {
            // 2) 배열의 최저점과, 최저점과 같은 점수가 몇 개인지 셈
            int min = Arrays.stream(myScores[i]).min().getAsInt();
            int minCnt = (int) Arrays.stream(myScores[i]).filter(s -> s == min).count();

            // 2) 배열의 최고점과, 최고점과 같은 점수가 몇 개인지 셈
            int max = Arrays.stream(myScores[i]).max().getAsInt();
            int maxCnt = (int) Arrays.stream(myScores[i]).filter(s -> s == max).count();

            // 3) 현재 배열의 총점을 구함
            int cnt = myScores[i].length;
            int sum = Arrays.stream(myScores[i]).reduce(0, Integer::sum);

            // 4) 최고점과 최저점이 자신이 준 점수라면 평균 구할 때 제외
            if ((myScores[i][i] <= min && minCnt < 2) || (myScores[i][i] >= max && maxCnt < 2)) {
                cnt--;
                sum -= myScores[i][i];
            }

            // 5) 평균에 대한 학점을 얻음
            answer += getGrades(sum/cnt);
        }

        return answer;
    }

    public String getGrades(int score) {
        String grades = "";

        if (score >= 90) {
            grades = "A";
        } else if (score >= 80) {
            grades = "B";
        } else if (score >= 70) {
            grades = "C";
        } else if (score >= 50) {
            grades = "D";
        } else if (score < 50) {
            grades = "F";
        }

        return grades;
    }
}
