class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++){
            String s=Integer.toString(i);
            int l=s.length();

            if(l%2!=0){
                continue;
            }

            int leftSum=0;
            int rightSum=0;

            for(int j=0;j<l/2;j++){
                leftSum+=s.charAt(j)-'0';
            }

            for(int j=l/2;j<l;j++){
                rightSum+=s.charAt(j)-'0';
            }
            if(leftSum==rightSum){
                count++;
            }
        }
        return count;
    }
}