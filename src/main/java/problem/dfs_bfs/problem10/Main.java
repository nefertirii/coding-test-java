package problem.dfs_bfs.problem10;

import java.util.Scanner;

/**
 * 10. 미로탐색(DFS)
 * 설명
 * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 * 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
 *
 * 입력
 * 7*7 격자판의 정보가 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 경로의 가지수를 출력한다.
 */

public class Main {

    private static boolean visit[][];
    private static int map[][];
    private static int dx[] = {1, 0, -1, 0};
    private static int dy[] = {0, 1, 0, -1};
    private static int answer;

    public void dfs(int y, int x) {

        if (y == 7 && x == 7) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (map[ny][nx] == 0 && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    dfs(ny, nx);
                    visit[ny][nx] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        map = new int[9][9];
        visit = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = 1;
            }
        }

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = in.nextInt();
            }
        }

        visit[1][1] = true;
        main.dfs(1, 1);
        System.out.println(answer);
    }
}
