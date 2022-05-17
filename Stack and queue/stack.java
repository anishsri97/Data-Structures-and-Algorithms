

 //Stack class implementation
class stack
{
    
   node top;


   stack()
   {
       this.top=null;
   }


   // pushing element into the stack
   public void push(int data)
   {
       if(top==null) 
       {
           top=new node(data);
           return;
       }
       else
       {
           node temp= new node(data);
           temp.next=top;
           top=temp;
           
       }
   }

   //popping element into the stack

   public int pop()
   {
       if(top==null) return -1;
       int x=top.data;
       top=top.next;
       return x;

   }

   // size of the stack

   public int size()
   {
        if(top==null)return 0;
        int length=0;
        node temp=top;
       
         while(temp!=null)
         {
            length++;
            temp=temp.next;
         }
         return length;
   }

   // is Empty

   public boolean isEmpty()
   {
       if(top==null) return true;
       return false;
   }

   





}