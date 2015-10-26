/* Proj5_GuitarString V2
*
* CSc 127A Fall 15, Project 05
*
* Author: Mark O.
* Section: K
*
* ---
*
* random string settels to 0
*/ 


public class Proj5_GuitarString {
    public static void main(String[] args) {
        double[] g_string = new double[255];//Initilize gutar string
        double[] v_string = new double[255];//Initilize Velocody of the sting
        
        //Draw the window
        StdDraw.setCanvasSize(255,255);
        StdDraw.setScale(0,255);
        StdDraw.setYscale(-127,127);
        
        //Initilize with random values
        for (int i=0;i<g_string.length;i++)
            g_string[i]=(Math.random()*50)-25 ;
        //First and last value are anchored at 0
        g_string[0]=0;
        g_string[254]=0;
        //Run the anamation
        while (true){
            StdDraw.clear();
            if (StdDraw.mousePressed() &&  ((StdDraw.mouseX()+.5)>0 && (StdDraw.mouseX()+.5)<255))
                g_string[(int)(StdDraw.mouseX()+.5)]=StdDraw.mouseY()
            for (int i=1;i<g_string.length-1;i++){
                v_string[i]=v_string[i]+0.01*((g_string[i-1])+(g_string[i+1])-2*g_string[i]);
                g_string[i]=.999*g_string[i]-v_string[i];
                StdDraw.line((double) i-1, g_string[i-1],(double) i, g_string[i]);
            }
            StdDraw.show(0);
        }
    }
} 