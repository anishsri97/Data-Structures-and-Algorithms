import java.util.*;

//Implementaion of priority queue (Heap Sort)

class maxHeap
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n  = in .nextInt();
        List<Integer> list = new ArrayList<>();
        while(n-->0)
        {
            addElement(list);
        }

        System.out.println(list);
        List<Integer> sort = new ArrayList<>();
        while(list.size()!=0)
        {
            sort.add(deleteElement(list));
        } 

        System.out.println(sort);



    }

   //building heap
    public static void addElement(List<Integer> list)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter element");
        int value = in.nextInt();
        list.add(value);
        int i = list.size()-1;

        while(i!=0)
        {
            int indx= (i-1)/2;
            if(list.get(indx)>list.get(i))
            {
                break;
            }
            else{
                int temp = list.get(i);
                list.set(i,list.get(indx));
                list.set(indx,temp);
            }
            i=indx;
        }
    }

    // deletion in heap


    public static int deleteElement(List<Integer> list)
    {
        if(list.size()==0) return -1;

        int ans=list.get(0);
        list.set(0,list.get(list.size()-1));
        list.remove(list.size()-1);

        heapify(list,0);

        return ans;
    }


 // heapify the heap
    public static void heapify(List<Integer> list,int l)
    {
        if(list.size()==0) return;

        int larg =  l;
        int left = (2*l+1);
        int right = (2*l+2);

        if(left<list.size() && list.get(larg)<list.get(left))
        {
            larg=left;
        }

        if(right<list.size() && list.get(larg)<list.get(right))
        {
            larg=right;
        }

        if(larg!=l)
        {
            int temp = list.get(l);
            list.set(l,list.get(larg));
            list.set(larg,temp);
            heapify(list,larg);
        }


    }
}