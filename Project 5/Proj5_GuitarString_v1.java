/* Proj5_GuitarString_V1
*
* CSc 127A Fall 15, Project 05
*
* Author: Mark O.
* Section: K
*
* ---
*
* This class shows a random line in a window
*/ 


public class Proj5_GuitarString {
    public static void main(String[] args) {
        double[] g_string = new double[255];
        StdDraw.setCanvasSize(255,255);
        StdDraw.setScale(0,255);
        for (int i=0;i<g_string.length;i++){
            g_string[i]=Math.random()*255 ;
        }
        for (int i=1;i<g_string.length;i++){
            StdDraw.line((double) i-1, g_string[i-1],(double) i, g_string[i]);
        }
    }
} 