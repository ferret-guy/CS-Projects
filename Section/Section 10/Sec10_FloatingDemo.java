
/* Sec10_FloatingDemo
 *
 * CSc 127A Fall 15, Section Activity 10
 *
 * Author:  Russell Lewis
 * SL Name: n/a
 *
 * ---
 *
 * A final demo of the barGraph() method, which does the guitar string
 * simulation - but in a barGraph(), and with a subwindow that floats
 * around the main window!
 */

public class Sec10_FloatingDemo
{
        public static void main(String[] args)
        {
                final double  SPRING_FACTOR = 0.01;
                final double DAMPING_FACTOR = 0.001;

                StdDraw.setScale(-100, 100);

                double[] values     = new double[101];
                double[] velocities = new double[101];

                // only initialize the positions, *NOT* the velocities.
                for (int i=1; i<values.length-1; i++)
                        values[i] = Math.random()*10-5;

                // the barGraph() method probably isn't smart about what to do
                // with negative numbers.  So we have a mirror array, which we
                // fill in every pass of the loop (sigh), which has everything
                // lower-bounded at zero.
                double[] values_copy = new double[values.length];


                // this represents the position of the *BAR GRAPH* in the
                // larger window.  We randomly select the initial position,
                // but the velocity always start at +1,+1
                double graphPosX = Math.random()*100-100;
                double graphPosY = Math.random()*100-100;
                double graphVelX = .05;
                double graphVelY = .05;

                while (true)
                {
                        // make the duplicate of the values[] array, with
                        // everything having a lower bound of zero.
                        for (int i=0; i<values_copy.length; i++)
                        {
                                if (values[i] < -50)
                                        values_copy[i] = 0;
                                else
                                        values_copy[i] = values[i]+50;
                        }

                        // draw the screen.
                        StdDraw.clear();
                          barGraph(values_copy, (int)graphPosX,(int)graphPosY);
                        StdDraw.show(3);

                        
                        // update the position of the floating graph.  Account
                        // for the possibility of hitting walls.
                        graphPosX += graphVelX;
                        graphPosY += graphVelY;
                        if (graphPosX < -100 || graphPosX > 0)
                                graphVelX *= -1;
                        if (graphPosY < -100 || graphPosY > 0)
                                graphVelY *= -1;


                        // update the guitar string itself.
                        for (int i=1; i<values.length-1; i++)
                        {
                                velocities[i] += SPRING_FACTOR * (values[i+1]+values[i-1] - 2*values[i]);
                        }

                        for (int i=1; i<values.length-1; i++)
                        {
                                values[i] += velocities[i];
                                values[i] -= values[i]*DAMPING_FACTOR;
                        }

                        
                        // check for clicks - but we have to offset everything
                        // because the graph can float!
                        if (StdDraw.mousePressed())
                        {
                                int mouseX = (int)(StdDraw.mouseX()-graphPosX+.5);
                                if (mouseX > 0 && mouseX < values.length-1)
                                        values[mouseX] = StdDraw.mouseY()-graphPosY;
                        }
                }
        }

        public static void barGraph(double[] argsDub, int x, int y){
            //Initilize color (RED,      GREEN,    BLUE,     YELLOW,     CYAN,       MAGENTA,    SILVER,       MAROON,   OLIVE)
            int[][] colors = {{255,0,0},{0,255,0},{0,0,255},{255,255,0},{0,255,255},{255,0,255},{192,192,192},{128,0,0},{128,128,0}};
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
                //StdDraw.setPenColor(new java.awt.Color(0,0,0));
                //StdDraw.text(((100L/argsDub.length)/2L)+((100L/argsDub.length)/2L)*i*2+x
                                 //,argsDub[i]+5+y
                                 //, ""+argsDub[i]);
            }
        }
}
