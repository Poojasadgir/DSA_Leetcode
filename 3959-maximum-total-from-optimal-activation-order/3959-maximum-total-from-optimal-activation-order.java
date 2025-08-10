class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n = value.length;
        Map<Integer, List<Integer>> u = new HashMap<>();

        for (int i = 0; i < n; i++) {
            u.computeIfAbsent(limit[i], k -> new ArrayList<>()).add(value[i]);
        }

        long ans = 0;
        for (int lim = 1; lim <= n; lim++) {
            if (!u.containsKey(lim)) continue;

            List<Integer> list = u.get(lim);
            list.sort(Collections.reverseOrder());

            for (int i = 0; i < Math.min(lim, list.size()); i++) {
                ans += list.get(i);
            }
        }
        return ans;
    }
}