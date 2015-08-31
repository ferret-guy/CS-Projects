public class Proj1_ConcCircs
{
    public static void main(String[] args)
    {
        //Initilize Window
        StdDraw.setScale(-100,100);
        StdDraw.clear(StdDraw.WHITE);
		
		//Initilize colors(RED,     GREEN,    BLUE,     YELLOW)
		int[][] colors = {{255,0,0},{0,255,0},{0,0,255},{255,255,0}};
		
		//Initilize Index
		int i = 0;
		
		//Check Args for Sanity
		while ( i < args.length ){
			//Check to see if arg can be converted to an int
			try {Integer.parseInt(args[i].trim());}
			catch(NumberFormatException e){
				System.out.println("Arg "+i+" is not an int!");
				System.exit(1);
			}
			
			//Check to see if arg is negitive or will goo off the screen
			if (Integer.parseInt(args[i].trim()) < 1 || Integer.parseInt(args[i].trim()) > 90){
				System.out.println("Arg "+i+" is negitive or invalid");
				System.exit(1);
			}
			
			//Check to see if more than 4 args
			if (args.length < 4){
				System.out.println("To many Args!");
				System.exit(1);
			}
			//Incrment the Index
			i++;
		}
		
		//Sort Array for printing
		Arrays.sort(args);
		
		//Reinitilize index
		i = 0;
        while ( i < args.length ){
			//Draw circles stepping through colors
			StdDraw.setPenColor(new Color(colors[i][0],colors[i][1],colors[i][3]));
			
			//Draw Circle
			StdDraw.filledCircle(0,0, Integer.parseInt(args[i].trim()));
			
			//Write value to side of screen shifting down 20 pixels for every value
			StdDraw.text(-90,(90-(i*10)), ""+args[i]);

			//Incrment the Index
			i++;
		}
    }
}

