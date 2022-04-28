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



    // tabulation method
    static int maxProfit(int W,int wt[],int val[],int N, int dp[][])
    {
       for(int w=0;w<=W;w++)
       {
           for(int n=0;n<=N;n++)
           {
             if(n==0 || w== 0) continue;
        
              
        
                if(w>=wt[n-1])
               {
                  dp[w][n]=Math.max(val[n-1]+dp[w-wt[n-1]][n-1],dp[w][n-1]);
                }
             else
             {
               return dp[w][n]=dp[w][n-1];
             }
           }
       } 
        
        return dp[W][N];
        
        
    }
 


     // memoization method
    static int maxProfit(int w,int wt[],int val[],int n, int dp[][])
    {
        if(n==0 || w== 0) return 0; // base condition
        
        if(dp[w][n]!=0) return dp[w][n]; // checking for storage
        
        if(w>=wt[n-1]) // choice
        {
            return dp[w][n]=Math.max(val[n-1]+maxProfit(w-wt[n-1],wt,val,n-1,dp),maxProfit(w,wt,val,n-1,dp));
        }
        else // when bag size smaller
        {
            return dp[w][n]=maxProfit(w,wt,val,n-1,dp);
        }
        
    }
    //equal sum partition memoization
    static int equalSum(int tar,int n,int arr[],int dp[][])
    {
        if(tar==0) return  dp[n][tar]= 1;
        
        if(n==0) return dp[n][tar]=0;
        
        
        if(dp[n][tar]!=-1) return dp[n][tar];
        
        if(tar>=arr[n-1])
        {
            return dp[n][tar]=equalSum(tar-arr[n-1],n-1,arr,dp)|equalSum(tar,n-1,arr,dp);
        }
        else
        {
            return dp[n][tar]=equalSum(tar,n-1,arr,dp);
        }
    }


    // equal sum partition tabulation method
    static int equalSum(int T,int N,int arr[],int dp[][])
    {
       for(int n=0;n<=N;n++)
       {
           for(int t=0;t<=T;t++)
           {
               if(t==0)
               {
                   dp[n][t]=1;
                   continue;
               }
        
               if(n==0)
               {
                   dp[n][t]=0;
                   continue;
               }
        
         if(t=arr[n-1])
         {
             dp[n][t]=dp[n-1][t-arr[n-1]]|dp[n-1][t];
         }
        else
        {
          dp[n][t]=dp[n-1][t];
        }
           }
       }

       return dp[N][T]; 
        
        
        
    }


      // reach to given score
    public long count(int n) 
    {
      int arr[] = new int[3];
      arr[0]=3;
      arr[1]=5;
      arr[2]=10;
      
      long dp[] = new long[n+1];
      dp[0]=1;
      for(int i=1;i<=3;i++)
      {
          for(int j=0;j<=n;j++)
          {
              if(j>=arr[i-1])
              {
                  dp[j]+=dp[j-arr[i-1]];
              }
          }
      }
      
      return dp[n];
    }

     // coin change unbounded knapsack
    public long count(int arr[], int m, int n) 
    {
       long dp[] = new long[n+1];
       dp[0]=1;
       for(int i=1;i<=m;i++)
       {
          for(int j=0;j<=n;j++)
          {
              if(j>=arr[i-1])
              {
                  dp[j]+=dp[j-arr[i-1]];
              }
          }
       }
      
      return dp[n];
    
    }

    // displaying 2d array
    public void display2D(int dp[][])
    {
        for(int a[]:dp)
        {
            System.out.println(display(a));
        }
    }

     //displaying 1D array
    public void display(int a[])
    {
        for(int ar:a)
        {
            System.out.print(ar+" ");
        }
    }
}
