package GraphAyush;


import java.util.*;
import java.awt.Color;
class compare extends Thread
{
    static double[] arr;
    public static void main()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter size of array containing random numbers between 1 to 100");
        int siz=in.nextInt();
        if(siz==0)
        System.exit(0);
         arr=new double[siz];
        
        /*
        for(int i=0;i<arr.length;i++)
        {
            System.out.println("Enter element number "+(i+1));
            try
            {
                arr[i]=in.nextInt();
            }
            catch (Exception ioe)
            {
                ioe.printStackTrace();
            }
        }
        */
        int co=0;
        ArrayList<Double> a=new ArrayList<Double>();
        while(a.size()<=arr.length)
        {
            Double ra=Math.random()*100;
            if(a.contains(ra)){}
            else
            {
                a.add(ra);
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=(double)a.get(i);
        }
        double arr2[]=new double[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            arr2[i]=arr[i];
        }
        bsort.arr=arr;
        ssort.arr=arr2;
        int ilw=0;
        int olw=80;
        bsort.inloopwait=ilw;
        ssort.inloopwait=ilw;
        bsort.outloopwait=olw;
        ssort.outloopwait=olw;

        new ssort().start();
        new bsort().start();
    }
    
}
