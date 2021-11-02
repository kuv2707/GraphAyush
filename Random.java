import java.util.*;
import java.awt.*;
class Random
{
    public static void main()
    {
        Color[] cols=new Color[]{Color.cyan,Color.blue,Color.green,Color.red};
        double arr[]=new double[(int)(10+20*Math.random())];
        BarGraph bg=new BarGraph(arr,25,Color.orange);
        bg.setArray(arr);
        bg.show(true);
        while(true)
        {
            try
            {
                Thread.sleep(15);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
            
            for(int i=0;i<arr.length-3;i++)
            {
                arr[i]=50*Math.random();
            }
            bg.setColor(cols[(int)(Math.random()*cols.length)]);
        }
    }
}