class Solution {
    public String simplifyPath(String path) {
        Stack<String>s=new Stack();
        StringBuilder str=new StringBuilder();
        String[] p=path.split("/");


        for(int i=0;i<p.length;i++){
            if(!s.isEmpty() && p[i].equals("..")) s.pop();
            else if(!p[i].equals("") && !p[i].equals(".")  && !p[i].equals(".."))s.push(p[i]);
        }

        if(s.isEmpty()){
            return "/";
        }

        while(!s.isEmpty()){
            str.insert(0,s.pop()).insert(0,"/");
        }
        return str.toString();
    }
}