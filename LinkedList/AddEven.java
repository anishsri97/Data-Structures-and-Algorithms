import java.util.*;

class AddEven
{
    public static void main(String args[])
    {
            Scanner in = new Scanner(System.in);
        
            
            int n = in.nextInt();
            
            list head=null;
            for(int i=0;i<n;i++)
            {    
                System.out.println("Enter value you want to insert\n");
                int value = in.nextInt();
                head=add(head,value);
                
            }

          list middle = getMiddle(head);
          list nlist = middle.next;
          middle.next=null;

          list cur = nlist,prev=null;

          while(cur!=null)
          {
              list nxt = cur.next;
              cur.next=prev;
              prev=cur;
              cur=nxt;
          }

          nlist=prev;
          int sum=0;
          while(head!=null)
          {
             System.out.println((head.data)+(nlist.data));
             head=head.next;
             nlist=nlist.next;
          }
                
        // System.out.println(sum);
            
        
        
    }


  // getting middle list from linkedlist
    public static list getMiddle(list head)
    {
        if(head==null && head.next==null) return head;

        list slow=head,fast=head;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

        }

        return slow;
    }
   // adding node in the linkedlist 
    public static list add(list node,int value)
    {
        list temp = node;
        list nnode = new list(value);
        if(node==null) 
        {
           return node=nnode;
        }
        else
        {
        
          while(temp.next!=null)
          {
              temp=temp.next;
          }
          temp.next=nnode;
          return node;

        }
    }

    // remove duplicates from sorted list
     public static ListNode removeDuplicates(ListNode head) 
    {
        if(head==null || head.next==null) return head;
        
        ListNode back=head,fast=head.next;
        
        while(fast!=null)
        {
            if(fast.val==back.val)
            {
                fast=fast.next;
            }
            else
            {
                back.next=fast;
                back=fast;
                fast=fast.next;
            }
        }
        back.next=null;
        
        return head;
    }


    // sorting of linkedlist using merge sort
     public ListNode sortList(ListNode head) 
    {
        if(head==null || head.next==null) return head;  
        ListNode middle  = findMid(head);
        ListNode middleNext = middle.next;
        middle.next=null;
        ListNode first = sortList(head);
        ListNode second = sortList(middleNext);
        first=merge(first,second);
        return first;
        
        
    }
    
    
    // divivde linkedlist
    
    public ListNode divide(ListNode head)
    {
        if(head.next==null) return head;
        
            ListNode mid = findMid(head);
            ListNode midNext = mid.next;
            mid.next=null;
            ListNode left =divide(head);
            ListNode right=divide(midNext);
            ListNode h = merge(left,right);
            return h;
            
        
    }
    
    // merging two linkedlist using recursion
    public ListNode merge(ListNode a,ListNode b)
    {
        if(a==null) return b;
        
        if(b==null) return a;
        
        ListNode result = null;    
        
        if(a.val<b.val)
        {
          a.next=merge(a.next,b);
          result=a;  
        }
        else
        {
           b.next=merge(a,b.next);
            result=b;
        }
        return result;
    }
    // finding mid element in linkedlist
    public ListNode findMid(ListNode head)
    {
        ListNode fast=head;
        ListNode slow=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    // merge two list using iterative approach

    public ListNode mergetwoList(ListNode a ,ListNode b)
    {
        if(a==null || b==null) return a==null? b:a;

        ListNode dummy   = new ListNode(-1);
        ListNode prev=dummy;

         
        while(a!=null && b!=null)
        {
              if(a.val<=b.val)
              {
                  prev.next=a;
                  a=a.next;
              }
              else{
                  prev.next=b;
                  b=b.next;
              }
              prev=prev.next;
        }
        prev.next=   (a==null)?b:a;
        return dummy.next;
    }

   // brute force for merging k sorted list TC = (kll)
    public ListNode mergeKlistbruteforce(Listnode lists[])
    {
        ListNode ans = null;
        for(ListNode list:lists)
        {
            ans = mergetwoList(ans,list);
        }
        return ans;
    }

    // merging k sorted lists  TC = N(log(k))
    public ListNode mergek(int low,int high,ListNode[] lists)
    {
        if(low>=high) return lists[low];
        
        int mid = (low+high)/2;
        
        ListNode left = mergek(low,mid,lists);
        ListNode right = mergek(mid+1,high,lists);
        left = mergetwoList(left,right);
      //  System.out.println("hello1");
       // printList(left);
        return left;
    }

      // reverse node in k groups
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        int length = count(head); 
        
        int times = length/k;
        ListNode dummy = new ListNode(-1);
        ListNode newhead=dummy,cur=head,prevhead=cur,prev=null;
        for(int i=1;i<=times;i++)
        {
            prevhead=cur;
            int j=0;
            while(j<k)
            {
                prev=cur;
                cur=cur.next;
                j++;
            }
            prev.next=null;
            dummy.next=reverse(prevhead);
            dummy=prevhead;
        }
        dummy.next=cur;
        return newhead.next;
    }
}