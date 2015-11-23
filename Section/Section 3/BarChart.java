import java.util.Arrays;

public class BarChart{
    public static void main(String[] args){
        //Initilize window
        StdDraw.setScale(0,100);
        StdDraw.clear(StdDraw.WHITE);
        
        //Initilize color (RED,      GREEN,    BLUE,     YELLOW,     CYAN,       MAGENTA,    SILVER,       MAROON,   OLIVE)
        int[][] colors = {{255,0,0},{0,255,0},{0,0,255},{255,255,0},{0,255,255},{255,0,255},{192,192,192},{128,0,0},{128,128,0}};
  
        //Initilize int args array
        double[] argsDub = new double[args.length];
        
        //Check Args for Sanity
        for (int i=0; i < args.length; i++) {
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
   
            /*//Check to see if more than 9 args
            if (args.length > 9 && args.length >= 0){
                System.out.println("To many/Not enough Args!");
                System.exit(1);
            }*/
            argsDub[i] = Integer.parseInt(args[i].trim());
        }
        //Sort Array for printing
        Arrays.sort(argsDub);
        int c=0;
        //Step through args to write them all
        for (int i= args.length-1; i >= 0; i-- ) {
            //Reset color buffer if we are at the end
            if(c>7){c=0;}
            //Draw bars stepping through colors
            StdDraw.setPenColor(new java.awt.Color(colors[c][0],colors[c][1],colors[c][2]));
            c++;//incrment color buffer
            
            //Draw Bar
            StdDraw.filledRectangle(((100L/args.length)/2L)+((100L/args.length)/2L)*i*2,argsDub[i]/2, ((100L/args.length)/2L),argsDub[i]/2);
   
            //Write value to side of screen shifting down 20 pixels for every value
            StdDraw.setPenColor(new java.awt.Color(0,0,0));
            StdDraw.text(((100L/args.length)/2L)+((100L/args.length)/2L)*i*2,argsDub[i]+5, ""+argsDub[i]);
        }
    }
}