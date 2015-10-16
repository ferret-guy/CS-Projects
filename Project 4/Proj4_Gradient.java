public class Proj4_Gradient{
    public static void main(String[] args){
        int b =0;
        //Check args for sanity
        if (args.length == 0)
            b = 0;
        else
            try{b = Integer.parseInt(args[0]);}
            catch (NumberFormatException e){System.out.println("Invalid Blue Value");
                return;} 
        //Set window up
        StdDraw.setCanvasSize(255,255);
        StdDraw.setScale(0,255);
        StdDraw.show(0); 
        
        //Run main logic
        for (int r=0;r!=255;r++){
            for (int g=0;g!=255;g++){
                StdDraw.setPenColor(new java.awt.Color(r,g,b));
                StdDraw.point((double) r,(double) g);
            }
        }
        StdDraw.show(0); 
    }
}