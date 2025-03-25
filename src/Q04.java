import java.util.ArrayList;
import java.util.Arrays;

public class Q04 {

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        int[] members = sol(answers);
        System.out.println("members = " + Arrays.toString(members));
    }

    private static int[] sol(int[] answers) {
        // 수포자들의 패턴
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        // 수포자들의 점수를 저장할 배열
        int[] scores = new int[3];

        // 각 수포자의 패턴과 정답 일치 확인
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 가장 높은 점수 저장
        int max = Arrays.stream(scores).max().getAsInt();

        // 가장 높은 점수를 가진 수포자들의 번호를 찾아서 리스트에 담음
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (max == scores[i]) {
                numbers.add(i + 1);
            }
        }

        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] mySol(int[] answers) {

        int[][] members = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] score = new int[3];

        for (int i = 0; i < members.length; i++) {
            // 수포자 답안이 부족하면 2배 증가
            while (answers.length > members[i].length) {
                int[] temp = new int[2 * members[i].length];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = members[i][j];

                }

            }

            // 답안을 순회하며 각 멤버가 찍은 문제와 비교
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == members[i][j]) {
                    score[i]++;
                }

            }
        }

        // score 에서 최대값 도출



        return null;
    }

}
