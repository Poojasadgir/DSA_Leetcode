class Solution {
    public int compress(char[] chars) {
      int writeIndex = 0; 
        int readIndex = 0;
        while (readIndex < chars.length) {
            char currentChar = chars[readIndex];
            int count = 0;
            while (readIndex < chars.length && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }
            chars[writeIndex++] = currentChar;
            if (count > 1) {
                char[] countChars = Integer.toString(count).toCharArray();
                for (char c : countChars) {
                    chars[writeIndex++] = c;
                }
            }
        }

        return writeIndex; 
    }
}