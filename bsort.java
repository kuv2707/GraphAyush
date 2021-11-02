 

import GraphAyush.*;
import java.util.*;
import java.awt.Color;
class bsort extends Thread
{
    static double[] arr;
    static int inloopwait=5,outloopwait=8;

    public static void main()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("( Bubble sort )Enter size of array containing random numbers between 1 to 100");
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
            arr[i]=a.get(i);
        }
        new bsort().start();
    }
    public  void run()
    {
        
        BarGraph ob=new BarGraph(arr,25,new Color(231, 76, 60));
        ob.setBackgroundColor(new Color(118, 215, 196));
        ob.setTitle("Array during bubble sort");
        ob.show(true);
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr.length-1-i;j++)
            {
                //ob.setKey(arr[j]);
                if(arr[j]>arr[j+1])
                {
                    double temp=arr[j];
                    
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    
                }
                try
                {
                    Thread.sleep(inloopwait);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
            }
            try
                {
                    Thread.sleep(outloopwait);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
        }
        ob.setColor(new Color(40, 116, 166));
        System.out.println("Bubble sort completed");
    }
}