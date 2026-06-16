class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0;
        int x = 0;
        int y = 0;
        int xdir = 1;
        int ydir = 1;
        int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // up, right, down, left
        int d = 0;
        HashSet<String> obs = new HashSet<>();
        for (int[] o : obstacles) {
            obs.add(o[0] + "," + o[1]);
        }
        for (int i : commands) {
            if (i == -1) {
                d = (d + 1) % 4;
            }
            if (i == -2) {
                d = (d + 3) % 4;
            } else {
                for (int j = 0; j < i; j++) {
                    int nx = x + direction[d][0];
                    int ny = y + direction[d][1];
                    if (obs.contains(nx + "," + ny)) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    ans = Math.max(ans, x * x + y * y);
                }
            }

        }

        return ans;

    }
}