class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        LinkedList<String>list=new LinkedList<>();
        for(int i=0;i<s.length();){
            StringBuilder sb=new StringBuilder();
            while(i<s.length() && s.charAt(i)!=' '){
                sb.append(s.charAt(i));
                i++;
            }
             while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            list.add(sb.toString());
        }
        StringBuilder st=new StringBuilder();
        for(int i=list.size()-1;i>=0;i--){
           st.append(list.get(i));
           if (i > 0) st.append(" "); 
        }
        return st.toString();
    }
}