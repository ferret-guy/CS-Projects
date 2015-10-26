public class Proj7_Watcher {
    static void drawEye(double x, double y, double rad){
        //Pupil radious
        int p_rad = 15;
        StdDraw.circle(x, y, rad);
        //If were in the circle draw ontop of the pointer
        if(rad-p_rad>=calcDist(StdDraw.mouseX(), StdDraw.mouseY(), x ,y ))
            StdDraw.filledCircle(StdDraw.mouseX(), StdDraw.mouseY(),p_rad);
        //If not draw pointed the right direction
        else{
                double ang = Angle(x,y,StdDraw.mouseX(), StdDraw.mouseY());
                StdDraw.filledCircle(x+(rad-p_rad)*Math.cos(ang), y+(rad-p_rad)*Math.sin(ang),p_rad);
        }
        
    }
    static double Angle(double x1, double y1, double x2, double y2){
        //Cacualtes angle between points
        return Math.atan2(y2-y1,x2-x1);
    }
    static double calcDist(double x1, double y1, double x2, double y2){
        //Calcuates distance to a point
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));}
    
    public static void main(String[] args){
        //Initilize window
        StdDraw.setCanvasSize(510,255);
        StdDraw.setScale(0,510);
        StdDraw.setYscale(0,255);
        //Draw eyes
        while (true){
            StdDraw.clear();
            drawEye(127.5,127.5,100);
            drawEye(382.5,127.5,100);
            StdDraw.show(0);
        }
    }
}