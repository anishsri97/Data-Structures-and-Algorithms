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
}