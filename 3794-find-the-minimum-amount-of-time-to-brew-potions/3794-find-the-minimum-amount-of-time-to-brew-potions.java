class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] done = new long[n];

        for (int j = 0; j < m; j++){
            long lastEndTime = 0;
            for (int i = 0; i < n; i++) {
                long startTime = Math.max(lastEndTime, done[i]);
                lastEndTime = done[i] = startTime + (long) skill[i] * mana[j];
            }

            for (int i = n - 1; i >= 1; i--) {
                done[i - 1] = done[i] - (long) skill[i] * mana[j];
            }
        }

        return done[n - 1];
    }
}