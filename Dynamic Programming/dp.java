import java.util.*;

class dp
{
    public static void main(String args[])
    {
        
    }


     //recursive+memoization = top-down
     public int trib(int n,int dp[])
     {
        if(n<=2)  return dp[n]= n==0?0:1;
    
        if(dp[n]!=0) return dp[n];
        
        return dp[n] = trib(n-1,dp)+trib(n-2,dp)+trib(n-3,dp);
     }
    
      // bottom up = tabulation method
    public int trib_tab(int N,int dp[])
    {
        for(int n=0;n<=N;n++)
        {
            if(n<=2)
            {
                dp[n]= n==0?0:1;
                continue;
            }
        
         dp[n] = dp[n-1]+dp[n-2]+dp[n-3];
        }
        return dp[N];
    }



      //climbing stairs //memoization
     public int climb(int n,int dp[])
    {
        
        if(n<=1) return dp[n]=1;
        
        if(dp[n]!=0) return dp[n];
        
        return dp[n]=climb(n-1,dp)+climb(n-2,dp);
    }
    
    // climbing stairs // tabulation method
    public int climb_tab(int N,int dp[])
    {
        
       for(int n=0;n<=N;n++)
       {
        
          if(n<=1)
          {    
              dp[n]=1;
             continue;
          }    
        
          
        
          dp[n]=climb(n-1,dp)+climb(n-2,dp);
       } 
        
        return dp[N];
    }

  // min cost for climbing stairs memoization
    public int minCost(int n,int cost[],int dp[])
    {
        if(n<=1)return dp[n]=cost[n];
        
        if(dp[n]!=0)  return dp[n];
        
        
        return dp[n] = Math.min(minCost(n-1,cost,dp),minCost(n-2,cost,dp))+(n==cost.length?0:cost[n]);
        
        
        
    }
    

    //min_cost for climbing to stairs  tabulation method
    public int minCost_tab(int N,int cost[],int dp[])
    {
      for(int n=0;n<=N;n++)
      {
        
        if(n<=1)
        {
            dp[n]=cost[n];
            continue;
        }
        
        
        
         //if(dp[n]!=0)  return dp[n];
        
          dp[n] =Math.min(dp[n-1],dp[n-2])+(n==cost.length?0:cost[n]); 
      }    
                  return dp[N];        
    }








    //----------------------------------------------------

    // longest palindromic subsequence
     public int lps(int i,int j,int dp[][],String str)
    {
        if(i>=j)
        {
            return dp[i][j]=(i>j)?0:1;
        }
        
        if(dp[i][j]!=0) return dp[i][j];
        if(str.charAt(i)==str.charAt(j)) // when the two char are equals
        {
            return dp[i][j]=2+lps(i+1,j-1,dp,str);
        }
        
        else
        {
            return dp[i][j]=Math.max(lps(i+1,j,dp,str),lps(i,j-1,dp,str)); // when taking one char at time
        }
        
    }

    //--------unbounded knapsack--------//

    // rod cutting proble// memoization

    public int cutting(int size[],int price[],int N,int I,int dp[][])
    {
       

       for(int i=0;i<=N;i++)
       {
           for(int n=0;n<=N;n++)
           {
              if(i==0 || n==0)
              {

               dp[i][n] = 0;
               continue;
              } 
        
        
        
            if(size[i-1]<=n)
            {
                dp[i][n]=Math.max(price[i-1]+dp[i][n-size[i-1]],dp[i-1][n]);
            }
        
           else
           {
              dp[i][n]=dp[i-1][n];
           }
           
        }
      
      }
      return dp[I][N];

        
        
    }



    // rod cutting problem iterative

    public int cutting(int size[],int price[],int N,int I,int dp[][])
    {
       

       for(int i=0;i<=N;i++) // for size of array
       {
           for(int n=0;n<=N;n++) // for length of rod
           {
              if(i==0 || n==0)
              {

               dp[i][n] = 0;
               continue;
              } 
        
        
        
            if(size[i-1]<=n)
            {
                dp[i][n]=Math.max(price[i-1]+dp[i][n-size[i-1]],dp[i-1][n]);
            }
        
           else
           {
              dp[i][n]=dp[i-1][n];
           }
           
        }
      
      }
      return dp[I][N];

        
        
    }
}
}
}