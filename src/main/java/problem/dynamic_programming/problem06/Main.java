package problem.dynamic_programming.problem06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 6. 최대점수 구하기(냅색 알고리즘)
 * 설명
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
 * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 *
 * 입력
 * 첫 번째 줄에 문제의 개수N(1<=N<=50)과 제한 시간 M(10<=M<=300)이 주어집니다.
 * 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
 */

public class Main {

    static class Problem {
        int score;
        int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public int solution(int m, List<Problem> problems) {

        // dy[i] = i분이 주어졌을 때 최대 점수
        int[] dy = new int[m + 1];

        // 문제는 1번만 풀 수 있으므로 뒤에서부터 순회한다.
        for (Problem problem : problems) {
            for (int i = m; i >= problem.time; i--) {
                dy[i] = Math.max(dy[i], dy[i - problem.time] + problem.score);
            }
        }

        return dy[m];
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        List<Problem> problems = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int score = in.nextInt();
            int time = in.nextInt();
            problems.add(new Problem(score, time));
        }

        System.out.println(main.solution(m, problems));
    }
}