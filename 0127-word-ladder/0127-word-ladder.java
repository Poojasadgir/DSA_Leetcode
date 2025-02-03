class Pair{
  String first;
  int second;
  public Pair(String first,int second){
    this.first=first;
    this.second=second;
  }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         int n=wordList.size();
         Set<String>set=new HashSet<>();
         for(int i=0;i<n;i++){
            set.add(wordList.get(i));
         }
         set.remove(beginWord);
         Queue<Pair>q=new LinkedList<>();
         q.add(new Pair(beginWord,1));
         while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();

            if(word.equals(endWord))return steps;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacechar[]=word.toCharArray();
                    replacechar[i]=ch;
                    String newWord=new String(replacechar);

                    if(set.contains(newWord)==true){
                        set.remove(newWord);
                        q.add(new Pair(newWord,steps+1));
                    }
                }
            }
         }
         return 0;
    }
}