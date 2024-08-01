class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(int i=0;i<details.length;i++){
            String str=details[i];
            int sa=Integer.valueOf(str.substring(11,13));
            if(sa>60){
               count++;
            }
        }
        return count;
    }
}