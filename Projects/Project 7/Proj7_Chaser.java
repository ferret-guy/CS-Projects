/* Proj7_Chaser
*
* CSc 127A Fall 15, Project 07
*
* Author: Mark O.
* Section: K
*
* ---
*
* Takes mouse input and draws
*/ 

import java.util.Random;

public class Proj7_Chaser {
    public static void main(String[] args) {
        //Draw the window
        StdDraw.setCanvasSize(255,255);
        StdDraw.setScale(0,255);
        StdDraw.setYscale(0,255);
        
        //Initilize random numbers
        Random rand = new Random();
        
        //Wait for the mouse to appear
        while (StdDraw.mouseX()==0.0 && StdDraw.mouseY()==0.0){}
        while (true){
            //Wait for moust press
            if (!StdDraw.mousePressed()){
                //Random Color
                StdDraw.setPenColor(new java.awt.Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
                //Draw the circle
                StdDraw.filledCircle(StdDraw.mouseX(), StdDraw.mouseY(),10);
            }
            else
                StdDraw.clear();
        }
    }
} 