//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            int k = Integer.parseInt(sc.nextLine());
            int n = words.length;
            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, k);
            if (order.length() == 0) {
                System.out.println("false");
                System.out.println("~");
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                System.out.println("~");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2) {
                        return Integer.compare(a.length(), b.length());
                    }

                    return Integer.compare(index1, index2);
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String findOrder(String[] dict, int k) {
        // Write your code here
        List<Integer>graph[]=new ArrayList[k];
        int n=dict.length;
        for(int i=0;i<k;i++){
            graph[i]=new ArrayList<>();
        }
        
        int inDegree[]=new int[k];
        
        for(int i=0;i<n-1;i++){
            String word1=dict[i];
            String word2=dict[i+1];
            
            int len=Math.min(word1.length(),word2.length());
            
            for(int j=0;j<len;j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    int u=word1.charAt(j)-'a';
                    int v=word2.charAt(j)-'a';
                    
                    graph[u].add(v);
                    inDegree[v]++;
                    break;
                }
            }
        }
        
        StringBuilder sb=new StringBuilder();
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
       int cnt=0;
        while(!q.isEmpty()){
            int u=q.poll();
            sb.append((char)(u+'a'));
            for(int v: graph[u]){
               inDegree[v]--;
               if(inDegree[v]==0){
                   q.add(v);
               }
            }
        }
        
       if(sb.length()==k) {
          return sb.toString(); 
       }else{
           return "";
       }
    }
}