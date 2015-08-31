import java.util.Arrays;

public class Proj1_ConcCircs
{
    public static void main(String[] args)
    {
        //Initilize Window
        StdDraw.setScale(-100,100);
        StdDraw.clear(StdDraw.WHITE);
  
        //Initilize color (RED,     GREEN,    BLUE,     YELLOW,     CYAN,       MAGENTA,    SILVER,       MAROON,   OLIVE)
        int[][] colors = {{255,0,0},{0,255,0},{0,0,255},{255,255,0},{0,255,255},{255,0,255},{192,192,192},{128,0,0},{128,128,0}};
  
        //Initilize Index
        int i = 0;
  
        //Initilize int args array
        int[] argsInt = new int[args.length];
  
        //Check Args for Sanity
        while ( i < args.length ){
            //Check to see if arg can be converted to an int
            try {Integer.parseInt(args[i].trim());}
            catch(NumberFormatException e){
                System.out.println("Arg "+(++i)+" is not an int!");
                System.exit(1);
            }
   
            //Check to see if arg is negitive or will goo off the screen
            if (Integer.parseInt(args[i].trim()) < 1 || Integer.parseInt(args[i].trim()) > 90){
                System.out.println("Arg "+i+" is negitive or invalid");
                System.exit(1);
            }
   
            //Check to see if more than 4 args
            if (args.length > 9 && args.length > 0){
                System.out.println("To many Args!");
                System.exit(1);
            }
            //Incrment the Index
            argsInt[i] = Integer.parseInt(args[i].trim());
            i++;
        }
  
        //Sort Array for printing
        Arrays.sort(argsInt);
  
        //Reinitilize index
        i = args.length-1;
        
        //Step through args to write them all
        while ( i >= 0 ){
            //Draw circles stepping through colors
            StdDraw.setPenColor(new java.awt.Color(colors[i][0],colors[i][1],colors[i][2]));
   
            //Draw Circle
            StdDraw.filledCircle(0,0, argsInt[i]);
   
            //Write value to side of screen shifting down 20 pixels for every value
            StdDraw.text(-90,(90-(i*10)), ""+args[i]);

            //Incrment the Index
            i--;
        }
    }
}

