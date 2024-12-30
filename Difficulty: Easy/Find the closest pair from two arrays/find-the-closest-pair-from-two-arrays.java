//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		
System.out.println("~");
}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        // code here
        int v = 0;
        int first = 0;
        int second = 0;
        int bv = 100000000;
        int j = m - 1;
        int i = 0;
        int kk8 = 0;
        int kk5 = 0;
        int g5 = 0;
        int g8 = 0;
        while (i < n && j >= 0) {
            if (arr[i] + brr[j] <= x) {
                int sum = arr[i] + brr[j];
                if (sum > v) {
                    v = sum;
                    first = arr[i];
                    second = brr[j];
                    g5 = 1;
                }
                i = i + 1;
            } else {
                if ((arr[i] + brr[j]) < bv) {
                    bv = arr[i] + brr[j];
                    kk5 = arr[i];
                    kk8 = brr[j];
                    g8 = 1;
                }
                j = j - 1;
            }
        }

        ArrayList<Integer> r = new ArrayList<>();
        if (g5 == 1) {
            int dv = Math.abs(x - v);
            if (g8 == 1) {
                int dy = Math.abs(x - bv);
                if (dy < dv) {
                    r.add(kk5);
                    r.add(kk8);
                } else {
                    r.add(first);
                    r.add(second);
                }
            } else {
                r.add(first);
                r.add(second);
            }
        } else {
            r.add(kk5);
            r.add(kk8);
        }

        return r;
    }
}