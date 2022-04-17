import java.util.*;
import java.io.*;

class UnboundedKnapsack
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int wt[] = new int[n];
        int val[] = new int[n];
        for(int i=0;i<n;i++)
        {
            wt[i]=in.nextInt();
        }

        for(int j=0;j<n;j++)
        {
            val[j]=in.nextInt();
        }

        int w = in.nextInt();

        int dp[][] = new int[n+1][w+1];


   // Tabulation Method
   // Space complexity : O((n+1)*(w+1)) 
   // time Complexity  : O((n+1)*(w+1));
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=w;j++)
            {
                if(wt[i-1]<=j)
                {
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][w]);

    int t[][] = new int[n+1][w+1];

    System.out.println(knap(wt,w,n,dp,val));


    }

     // memoization +recursion

     // Time complexity  : O(n+w) 
     // Space Complexity : O(n+w) + O(n*w);
    public static int knap(int wt[],int w,int n,int dp[][],int val[])
    {
        if(w==0 || n==0) return 0;

        else if(dp[n][w]!=-1) return dp[n][w];

        else if(wt[n-1]<=w)
        {
            return dp[n][w] = Math.max(val[n-1]+knap(wt,w-wt[n-1],n,dp,val),knap(wt,w,n-1,dp,val));
        }
        else{
            return dp[n][w] = knap(wt,w,n-1,dp,val);
        }
    }
}
