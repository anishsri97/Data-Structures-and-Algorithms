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
}