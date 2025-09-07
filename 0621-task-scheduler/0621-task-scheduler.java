class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freq.entrySet());

        int time = 0;
        
        while (!maxHeap.isEmpty()) {
            List<Map.Entry<Character, Integer>> tempList = new ArrayList<>();
            int cycle = n + 1; 

            while (cycle > 0 && !maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                entry.setValue(entry.getValue() - 1);
                tempList.add(entry);
                cycle--;
                time++;
            }

            for (Map.Entry<Character, Integer> entry : tempList) {
                if (entry.getValue() > 0) {
                    maxHeap.offer(entry);
                }
            }

            if (!maxHeap.isEmpty()) {
                time += cycle; 
            }
        }
        
        return time;
    }
}