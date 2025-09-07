class Solution {
    public int[] sumZero(int n) {
        int[] a = new int[n];
        int k = 1;
        
        for (int i = 0; i < n / 2; i++) {
            a[i] = k;
            a[n - 1 - i] = -k;
            k++;
        }
        return a;
    }
}