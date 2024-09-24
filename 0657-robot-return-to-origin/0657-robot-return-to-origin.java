class Solution {
    public boolean judgeCircle(String moves) {
        int X=0,Y=0;
        for(int i=0;i<moves.length();i++){
        if(moves.charAt(i)=='L'){
             X--;
         }else if(moves.charAt(i)=='R'){
             X++;
         }else if(moves.charAt(i)=='U'){
             Y++;
         }else{
             Y--;
         }
       }
       if(X==0 && Y==0){
        return true;
       }
       return false;
    }
}