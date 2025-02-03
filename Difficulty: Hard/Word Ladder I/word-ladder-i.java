//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Pair{
    String first;
    int second;
    public Pair(String first,int second){
        this.first=first;
        this. second= second;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(startWord,1));
        Set<String>set=new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            set.add(wordList[i]);
        }
        set.remove(startWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            
            if(word.equals(targetWord))return steps;
            
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacech[]=word.toCharArray();
                    replacech[i]=ch;
                    String replaceWord=new String(replacech);
                    
                    if(set.contains(replaceWord)==true){
                        set.remove(replaceWord);
                        q.add(new Pair(replaceWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}