to be added
@other types of graph
@dark mode and choice of background color





*)To use-

1. import GraphAyush.*;

    
3.Create an instance of Graph.<type>Graph class.
    
   Graph.<type>Graph object = new Graph.<type>Graph(<parameters>);
   
   To show the graph:      object.show(true);
   To hide the graph:      object.show(false);
    
*) Caution:
obj.repaint() has to be called when array elements have been changed  : not any more
    
    
    show(true) to show the graph
    
*) Constructors:
(x stands for graph type)

1 xGraph(int[] array): to show a graph of given array with default settings.

2. xGraph(int[] array,int wid):  to show a graph of given array , with given width of the bars.

3. xGraph(int[]a,int amp,Color kol):  to show a graph of given array , with given width of the bars and their color.

4. xGraph(int[]a,int amp,Color kol,String lab[]) ;  to show a graph of given array , with given width of the bars, their color and labels below bars.

5. xGraph(): to construct an object from scratch and chenge its properties(characteristics of the graph) through setter functions.
    setter functions should be called in order:  setArray(),setLabel(),setColor(),setWidthOfBars(), with the respective parameters
    
    If values for a certain field are not specified, they will take default values, except the array.
    
setBackgroundColor(Color col)  : sets the background of the panel containing the graph to the specified color object


linegraph
setColorOfPoints(Color obj)
setLineThickness(int t)