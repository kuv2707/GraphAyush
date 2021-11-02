package GraphAyush;

import GraphAyush.*;
import java.util.*;
import java.awt.Color;
class ssort extends Thread
{
    static double arr[];
    static int inloopwait=5,outloopwait=8;
    public static void main()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("( Selection sort )Enter size of array containing random numbers between 1 to 100");
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
        new ssort().start();
    }
    public  void run()
    {
        
        LineGraph ob=new LineGraph(arr,5,new Color(231, 76, 60));
        ob.setBackgroundColor(new Color(118, 215, 196));
                ob.setTitle("Array during selection sort");

        ob.show(true);
        
        for(int i=0;i<arr.length-1;i++)
        {
            int min=i;
            
            for(int j=i+1;j<arr.length;j++)
            {
                ob.setKey(arr[j]);
                if(arr[min]>arr[j])
                {
                    min=j;
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
            double temp=arr[i];
                    ob.setKey(arr[min]);
                    arr[i]=arr[min];
                    arr[min]=temp;
                    
            try
                {
                    Thread.sleep(outloopwait+1);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
                
        }
        int n = arr.length;
        /*
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
  
            // Swap the found minimum element with the first
            // element
            double temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }*/
        ob.setColor(new Color(40, 116, 166));
                System.out.println("Selection sort completed");

    }
}
