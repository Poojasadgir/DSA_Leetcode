// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        java.math.BigInteger a=new java.math.BigInteger(s1,2);
        java.math.BigInteger b=new java.math.BigInteger(s2,2);
        return a.add(b).toString(2);
    }
}