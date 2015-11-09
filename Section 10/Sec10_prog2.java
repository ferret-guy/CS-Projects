
/* Sec10_prog2
 *
 * CSc 127A Fall 15, Section Activity 10
 *
 * Author:  Russell Lewis
 * SL Name: n/a
 *
 * ---
 *
 * This program draws 4 bar graphs, by taking thecode from Section 3, and
 * generalizes it into a method.
 */

public class Sec10_prog2
{
        public static void main(String[] args)
        {
                // these are the 4 arrays that we will plot out
                double[] array1 = {10,20};
                double[] array2 = {10, 5,30, 5,50, 5};
                double[] array3 = {90,80,70,60,50,40,30,20,10, 5};
                double[] array4 = {10,10,10,5,5,5,40,40,40};

                // initialize StdDraw.  The version of barGraph() that we use
                // in this section always draws a graph which takes up 100x100,
                // so we allocate a 200x200 graph, large enough for four of
                // them.
                StdDraw.setScale(-100,100);
                StdDraw.clear();

                // each call to this method should draw a single bar graph
                barGraph(array1, -100,   0);
                barGraph(array2,    0,   0);
                barGraph(array3, -100,-100);
                barGraph(array4,    0,-100);
        }

        public static void barGraph(double[] argsDub, int x, int y){
            //Initilize color (RED,      GREEN,    BLUE,     YELLOW,     CYAN,       MAGENTA,    SILVER,       MAROON,   OLIVE)
            int[][] colors = {{255,0,0},{0,255,0},{0,0,255},{255,255,0},{0,255,255},{255,0,255},{192,192,192},{128,0,0},{128,128,0}};
            
            //Check Args for Sanity
            for (int i=0; i < argsDub.length; i++) {   
                //Check to see if arg is negitive or will goo off the screen
                if (argsDub[i] < 1 || argsDub[i] > 90){
                    System.out.println("Arg "+i+" is negitive or invalid");
                    return;
                }
   
            /*//Check to see if more than 9 args
            if (args.length > 9 && args.length >= 0){
                System.out.println("To many/Not enough Args!");
                System.exit(1);
            }*/
            }
            //Sort Array for printing
            //Arrays.sort(argsDub);
            int c=0;
            //Step through args to write them all
            for (int i= argsDub.length-1; i >= 0; i-- ) {
                //Reset color buffer if we are at the end
                if(c>7){c=0;}
                //Draw bars stepping through colors
                StdDraw.setPenColor(new java.awt.Color(0,127,i*(255/argsDub.length)));
                c++;//incrment color buffer
            
                //Draw Bar
                StdDraw.filledRectangle(((100L/argsDub.length)/2L)+((100L/argsDub.length)/2L)*i*2+x
                                            ,argsDub[i]/2+y
                                            ,((100L/argsDub.length)/2L)
                                            ,argsDub[i]/2);
   
                //Write value to side of screen shifting down 20 pixels for every value
                StdDraw.setPenColor(new java.awt.Color(0,0,0));
                StdDraw.text(((100L/argsDub.length)/2L)+((100L/argsDub.length)/2L)*i*2+x
                                 ,argsDub[i]+5+y
                                 , ""+argsDub[i]);
            }
        }
}
