import java.util.*;
import java.io.*;

class main
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        stack stk = new stack();
        while(true)
        {
            System.out.println("MENUE\n1.PUSH\n2.POP\n3.SIZE\n4.IS EMPTY\n5.EXIT\n");
            int option = in.nextInt();
            switch(option)
            {
                case 1:
                System.out.println("Enter element\n");
                int value = in.nextInt();
                stk.push(value);
                break;

                case 2:
                System.out.println(stk.pop());
                break;

                case 3:
                stk.size();
                break;

                case 4:
                stk.isEmpty();
                break;

                default:
                System.exit(0);

            }
        }
    }
}