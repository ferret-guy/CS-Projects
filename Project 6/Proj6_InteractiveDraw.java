/* Proj6_InteractiveDraw
*
* CSc 127A Fall 15, Project 06
*
* Author: Mark Omo
* Section: K
*
* ---
*
* Draws random shapes based on color and shape
*/

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Proj6_InteractiveDraw{
    public static void main(String[] args){
        //Initilize
        Scanner in = new Scanner(System.in);
        StdDraw.setScale(-100,100);
        StdDraw.clear(StdDraw.WHITE);
        Random rand = new Random();
        String[] color_names = {"red","green","blue","yellow","cyan","magenta","silver","maroon","olive","white","black"};
        int[][] colors = {{255,0,0},{0,255,0},{0,0,255},{255,255,0},{0,255,255},{255,0,255},{192,192,192},{128,0,0},{128,128,0},{0,0,0},{255,255,255}};
        String[] shape_names = {"square", "rectangle", "circle"};

        while (in.hasNext()){
            //Lowercase string to better match shapes
            String input = in.nextLine().toLowerCase();
            //Check if we match all paramaters if not print an error message telling us how to use the progam
            if ((input.split(" +").length != 2)||!(Arrays.asList(color_names).contains(input.split(" +")[0]))||!(Arrays.asList(shape_names).contains(input.split(" +")[1]))){
                System.out.println("Usage:\n     <Color> <Shape>\nColors:red, green, blue, yellow, cyan, magenta, silver, maroon, olive, white, black\nShapes:square, rectangle, circle");}
            //If all the paramater checks are sucessfull then draw the shapes
            else{
                //c is the color index (used to keep the next line from being super duper long
                int c=Arrays.asList(color_names).indexOf(input.split(" +")[0]);
                //Set the color to the propr color index
                StdDraw.setPenColor(new java.awt.Color(colors[c][0],colors[c][1],colors[c][2]));
                //USe the proper shape hander based on the shape index
                switch(Arrays.asList(shape_names).indexOf(input.split(" +")[1])){
                    case 0: {StdDraw.square(0,0,(rand.nextInt((90-10)+1)+10));
                             break;}
                    case 1: {StdDraw.rectangle(0,0,(rand.nextInt((90-10)+1)+10),(rand.nextInt((90-10)+1)+10));
                             break;}
                    case 2: {StdDraw.circle(0,0,(rand.nextInt((90-10)+1)+10));
                             break;}
                }
            }
            }
            }
        }
    