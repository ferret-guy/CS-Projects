/* Proj6_ReadLineTest
*
* CSc 127A Fall 15, Project 06
*
* Author: Mark Omo
* Section: K
*
* ---
*
* Prints every word on a line on a diffrent line
*/

import java.util.Scanner;

public class Proj6_ReadLineTest{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String old = "";
        while (in.hasNext()){
            String input = in.nextLine();
            for (int i=0;i<input.split(" ").length;i++){
                System.out.println(input.split(" ")[i]);
            }
        }
    }
}