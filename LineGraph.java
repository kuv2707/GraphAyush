package GraphAyush;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;


    
public class LineGraph extends Graph
{
    int X;
    
    JFrame frame;
    JPanel pan;
    double[] aa;
     double key=-20;//vertical line that moves during sorting as if scanning
    int LineThickness=20;
     Color col=Color.black;
     Color colpts=new Color(165, 105, 189);
     String[] label;
     double maxElem;
     Color colFondo=new Color(162, 217, 206);
     String title="Bar graph of data";
     public LineGraph()
     {
         frame=new JFrame(title);
        }
    public LineGraph(double[] a)
    {
        aa=a;
        X=aa.length;
        label=new String[X];
        for(int i=0;i<X;i++)
        label[i]=""+(i+1);
        nextSteps(aa);
    }
    public LineGraph(double[]a,int amp)
    {
        aa=a;
        X=aa.length;
        LineThickness=amp;
        label=new String[X];
        for(int i=0;i<X;i++)
        label[i]=""+(i+1);
        nextSteps(aa);
    }
    public LineGraph(double[]a,int amp,Color kol)
    {
        aa=a;
        X=aa.length;
        LineThickness=amp;
        label=new String[X];
        for(int i=0;i<X;i++)
        label[i]=""+(i+1);
        col=kol;
        nextSteps(aa);
        
    }
    public LineGraph(double[]a,int amp,Color kol,String lab[])
    {
        aa=a;
        X=aa.length;
        LineThickness=amp;
        label=new String[X];
        for(int i=0;i<X;i++)
        {
            try
            {
                
                label[i]=lab[i];
            }
            catch(Exception e)
            {
                System.err.println("Insufficient labels for all the bars so the rest will be left blank");
                label[i]=""+(i+1);
            }
        }
        
        
        col=kol;
        nextSteps(aa);
    }
    private void nextSteps(double[] a)
    {
        
        frame=new JFrame("Bar graph of data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(80+60*(X),600);
        
        maxElem=getMax(a);
        
        pan=new Ayush();
        new javax.swing.Timer(15,new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                pan.repaint();
                //System.out.println();
            }
        }).start();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(pan);
        //frame.setVisible(true);
    }
    public void repaint()
    {
        pan.repaint();
    }
    private class Ayush extends JPanel
    {
        public void paint(Graphics gg)
        {
            Graphics2D g=(Graphics2D)gg;
            super.paint(g);
            setBackground(colFondo);
            
            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHints(rh);
            g.draw(new Line2D.Double(30,frame.getHeight()-50,30,00));
            g.draw(new Line2D.Double(30,frame.getHeight()-50,frame.getWidth()-30,frame.getHeight()-50));
            
            
            maxElem=getMax(aa);
            double xl=((frame.getWidth()-120)/(X-1));
            if(xl<1)
            {
                xl=1;
            }
            
            for(int i=1;i<X;i++)
            {
                g.setColor(col);
                double scaleFactored=(((double)((double)frame.getHeight()-60)/(double)maxElem)*((double)aa[i]));  //else it type casted to int and led to screen resolution constraint
                double scaleFactoredf=(((double)((double)frame.getHeight()-60)/(double)maxElem)*((double)aa[i-1]));
                g.setStroke(new BasicStroke(LineThickness));
                g.draw(new Line2D.Double( 60+ (int)(i*xl),frame.getHeight()-50-scaleFactored,60+((i-1)*xl),frame.getHeight()-50-scaleFactoredf));
                g.drawString(""+(int)aa[i],8,frame.getHeight()-50-(int)scaleFactored);
                g.drawString(label[i],60+ (int)(i*xl),frame.getHeight()-40);
                if(aa[i]==key)
                {
                    g.setStroke(new BasicStroke(LineThickness-1.5f));
                    g.setColor(Color.black);
                    g.draw(new Line2D.Double(30,frame.getHeight()-50,60+ (int)(i*xl),frame.getHeight()-50-scaleFactored));
                    //g.draw(new Line2D.Double(60+ (i*xl),0,60+ (i*xl),frame.getHeight()-50));
                }
            }
            for(int i=0;i<X;i++)
            {
                g.setColor(colpts);
                double scaleFactored=(((double)((double)frame.getHeight()-60)/(double)maxElem)*((double)aa[i]));  //else it type casted to int and led to screen resolution constraint
                
                g.setStroke(new BasicStroke(LineThickness+2.5f));
                g.fill(new Ellipse2D.Double( 60+ (int)(i*xl)-LineThickness,frame.getHeight()-50-scaleFactored-LineThickness,LineThickness*2,LineThickness*2));
                
            }
            g.drawString(label[0],60+ (int)(0*xl),frame.getHeight()-40);
            if(aa[0]==key)
                {
                    g.setStroke(new BasicStroke(LineThickness-1.5f));
                    g.setColor(Color.black);
                    double scaleFactored=(((double)((double)frame.getHeight()-60)/(double)maxElem)*((double)aa[0]));
                    g.draw(new Line2D.Double(30,frame.getHeight()-50,60+ (int)(0*xl),frame.getHeight()-50-scaleFactored));
                    //g.draw(new Line2D.Double(60+ (0*xl),0,60+ (0*xl),frame.getHeight()-50));
                }
            //System.out.println((frame.getHeight()-60)+" "+maxElem+" "+(((double)((double)frame.getHeight()-60)/(double)maxElem)*(double)(aa[aa.length-2])));
            }
            
        }
        public void setKey(double val)//key is a variable representing line acting as scanner in bubble sort
        {
            key=val;
        }
        public JFrame getFrame()
        {
            return frame;
        }
        public void setTitle(String s)
        {
            frame.setTitle(s);
        }
    public void show(boolean bool)//part of bargraph wala class
    {
        frame.setVisible(bool);
    }
    public void setArray(double[] a)
    {
        aa=a;
        X=aa.length;
        maxElem=getMax(aa);
        nextSteps(a);
        //this.setLabel(label);//to be on the safe side if user changes the array: but is it required? NO
    }
    public void setColor(Color kool)
    {
        col=kool;
        pan.repaint();
        //nextSteps(aa);
    }
    public void setBackgroundColor(Color rang)
    {
        colFondo=rang;
    }
    public void setLabels(String[] la)
    {
        label=new String[X];
        for(int i=0;i<X;i++)
        {
            try
            {
                
                label[i]=la[i];
            }
            catch(Exception e)
            {
                System.err.println("Insufficient labels for all the bars so the rest will be left blank");
                label[i]=" ";
            }
        }
        //nextSteps(aa);
    }
    public void setLineThickness(int wid)
    {
        LineThickness=wid;
        pan.repaint();
    }
    public void setColorOfPoints(Color pt)
    {
        colpts=pt;
    }
    static double getMax(double[] a)
    {
        double max=a[0];
        for(int y=0;y<a.length;y++)
        {
            if(a[y]>max)
            max=a[y];
        }
        return max;
    }
    
    
}
