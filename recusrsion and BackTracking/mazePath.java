import java.util.*;


class mazePath
{
    
    public static int path(int sr,int sc,int er,int ec,int dir[][],String dirx[],String pf)
    {
        if((sr==er) && (sc==ec)) // base condition
        {
            System.out.println(pf);
            return 1;
        }

        int count=0;

        for(int d=0;d<dir.length;d++)
        {
            int nxtRow = sr+dir[d][0]; // taking move in row
            int nxtCol = sc+dir[d][1]; //  taking move in col

            if((nxtRow>=0 && nxtRow<=er) && (nxtCol>=0 && nxtCol<=ec)) // checking for boundary conditions
            {
                count+=path(nxtRow,nxtCol,er,ec,dir,dirx,pf+dirx[d]); // countting paths for each move
            }
        }
        return count;
    }
    
    public static void main(String args[])
    {
         int dir[][] = {{0,1},{1,0},{1,1}}; // direction array
         String dirx[] = {"H","V","D"};   // path direction
         System.out.println(path(0,0,1,1,dir,dirx,"")); // printing count 
    }
}