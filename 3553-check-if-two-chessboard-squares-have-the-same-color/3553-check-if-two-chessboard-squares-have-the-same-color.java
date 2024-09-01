class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int i = 0;
        boolean isFirstBlack = (coordinate1.charAt(i) - 'a' + (coordinate1.charAt(i + 1) - '0')) % 2 == 0;
        boolean isSecondBlack = (coordinate2.charAt(i) - 'a' + (coordinate2.charAt(i + 1) - '0')) % 2 == 0;
        return isFirstBlack == isSecondBlack;
    }
}