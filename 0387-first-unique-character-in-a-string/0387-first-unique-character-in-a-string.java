class Solution {
    public int firstUniqChar(String s) {
        int temp[]=new int[26];
        Arrays.sort(temp);

        for(int i=0;i<26;i++)temp[i]=0;
        for(char ch:s.toCharArray()){
            temp[ch-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(temp[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}