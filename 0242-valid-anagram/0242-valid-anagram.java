import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()==t.length()){
            char temp[]=s.toCharArray();
            char semp[]=t.toCharArray();
            Arrays.sort(temp);
            Arrays.sort(semp);
            for(int i=0;i<temp.length;i++){
               if(temp[i]!=semp[i]){
                return false;
            } 
            }  
            return true;
        }
        return false;
    }
}