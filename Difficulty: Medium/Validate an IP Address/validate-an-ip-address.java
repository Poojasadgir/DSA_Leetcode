class Solution {
    public boolean isValid(String s) {
        // code here
        String[] parts = s.split("\\.", -1);

        if (parts.length != 4) return false;

        for (String part : parts) {
            if (part.length() == 0) return false;

            if (part.length() > 1 && part.charAt(0) == '0') return false;

            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }

            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;
        }
        return true;
    }
}