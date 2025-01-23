class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>s=new Stack();
          for (String token : tokens) {
            if(token.equals("+")){
               int n1=s.pop();
               int n2=s.pop();
               s.push(n2+n1);
            }else if(token.equals("-")){
               int n1=s.pop();
               int n2=s.pop();
               s.push(n2-n1);
            }else if(token.equals("*")){
                int n1=s.pop();
               int n2=s.pop();
               s.push(n1*n2);
            }else if(token.equals("/")){
                int n1=s.pop();
               int n2=s.pop();
               s.push(n2/n1);
            }else{
               s.push(Integer.parseInt(token));
            }   
        }
        return s.peek();
    }
}