




public int findElement(int low,int high,int arr[], int tar) // recursive binary search
{
    if(low<=high)
    {
        int mid = low+(high-low)/2;   // dividing the array

        if(arr[mid]==tar) return mid;

         if(arr[mid]<tar)
        {
            return findElement(low,mid-1,arr,tar);  // left half
        }

        else
        {
              return findElement(mid+1,high,arr,tar); // right half
        }
    }

    return -1;
}

int left=-1;
int right=-1;

// iterative approach


public int findElement(int low,int high,int arr[], int tar) // recursive binary search
{
    while(low<=high)
    {
        int mid = low+(high-low)/2;   // dividing the array

        if(arr[mid]==tar)
        {
              int lhigh = mid-1;
              int l = low;   
              while(l<=lhigh)    // finding the leftmost index
              {
                  int  m = (low+lhigh)/2;


                  if(arr[m]==tar)
                  {
                      left=m;
                      lhigh=m-1;
                  }

                  else if(arr[m]<tar)
                  {
                      l=m+1;
                  }
                  else
                  {
                      lhigh=m-1;
                  }
              }
         
             int ll = low;
             int hh = mid+1;

             while(ll<=hh)  // finding the rightmost index
              {
                  int  m = (ll+hh)/2;


                  if(arr[m]==tar)
                  {
                      right=m;
                      ll=m+1;
                  }

                  else if(arr[m]<tar)
                  {
                      ll=m+1;
                  }
                  else
                  {
                      hh=m-1;
                  }
              }

              break;
              


        }

         if(arr[mid]<tar)
        {
            return findElement(low,mid-1,arr,tar);  // left half
        }

        else
        {
              return findElement(mid+1,high,arr,tar); // right half
        }
    }

    return -1;
}



// search in rotated sorted array


 public int search1(int low,int high,int tar,int arr[])
    {
       if(low<=high)
       {
           int mid = low+(high-low)/2;
           
           if(arr[mid]==tar) return mid;
           
           if(arr[low]<=arr[mid])
           {
               if(tar>=arr[low] && tar<=arr[mid]) return search1(low,mid-1,tar,arr);
               else return search1(mid+1,high,tar,arr);
           }
           else
           {
               if(tar>arr[mid] && tar<=arr[high]) return search1(mid+1,high,tar,arr);
               else return search1(low,mid-1,tar,arr);
           }
               
           
       }
        
        return -1;
    }


