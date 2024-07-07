class Solution {
    public String defangIPaddr(String address) {
        String newStr="";
       for(int i=0;i<address.length();i++){
        if(address.charAt(i)=='.'){
            newStr+="[.]";
        }else{
             newStr+=address.charAt(i);
        }
       }
       return newStr;
    }
}