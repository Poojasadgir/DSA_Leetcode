class Solution {
    public String reverseWords(String s) {
        // Code here
        String[] words = s.split("\\.+");
        StringBuilder sb = new StringBuilder();

        boolean firstWordAdded = false;

        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                if (firstWordAdded) {
                    sb.append(".");
                }
                sb.append(words[i]);
                firstWordAdded = true;
            }
        }
        return sb.toString();
    }
}
