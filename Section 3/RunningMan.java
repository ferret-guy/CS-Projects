public class RunningMan
{
        public static void drawStickFigure(double xPos, double yPos, double angle)
        {
                // this little marker exists to show you where the man *ought*
                // to be.  If you make this method work correctly, it should
                // be above, and a little to the left, of his head as he moves
                // around.
                //
                // If you want to remove this marker, you're allowed to, but
                // you can also keep it if you'd like; it's just there to help
                // you.
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledCircle(xPos,yPos+40, 1);

                // this draw the stick figure itself.  Note that this always
                // draws the figure at the same location - you have to change
                // these calls so that he moves around.
                double cos = Math.cos(angle);
                double sin = Math.sin(angle);
                
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledCircle(xPos,yPos+40, 1);
                
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.circle(10+xPos,30+yPos, 4);
                
                int[][] body = {{10,26,10,12},{10,12,  7,1},{10,12, 13,1},{7,1,   5,1},{13,1,  15,1},{10,25,  5,15},{10,25, 15,15}};
                

                for(int i=0;i<=6;i++){
                StdDraw.line  ((cos*(body[i][0])-sin*(body[i][1]))+xPos,(cos*(body[i][1])+sin*(body[i][0]))+yPos, (cos*(body[i][2])-sin*(body[i][3]))+xPos,(cos*(body[i][3])+sin*(body[i][2]))+yPos);
                }
                
        }



        public static void main(String[] args){
                StdDraw.setScale(0,200);

                double xPos = 0;
                double yPos = 0;
                double xVel = 1;
                double yVel = 0;
                double angle = 0;

                boolean simStarted = false;
                while (xPos < 185){
                        //Reset window
                        StdDraw.clear();

                        //Draw obstacles
                        StdDraw.setPenColor(StdDraw.GRAY);
                        StdDraw.filledSquare(50,7, 7);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.line(100,0, 200, 50);

                        //Draw stick figure
                        drawStickFigure(xPos, yPos, angle);
                        angle = 0;

                        //Pause for anamation
                        StdDraw.show(20);

                        //If we havent started see if we have!
                        if ( ! simStarted && StdDraw.isKeyPressed(' ')){
                            simStarted = true;
                        }
                        
                        //When it is not started draw the propmt text
                        else if ( ! simStarted){
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.text(100,100, "Press SPACE to start running!");
                            StdDraw.show(100);
                            continue;
                        }


                        //Incrment the position
                        xPos += xVel;
                        yPos += yVel;

                        //If we are after the start then move at .5 speed
                        if (yPos > 0)
                                yVel -= .5;

                        //If we are at the origin then we are stopped
                        if (yPos < 0){
                                yPos = 0;
                                yVel = 0;
                        }

                        //If we are at the box then we are on top of it
                        if (xPos >= 50-7-(10+5) && xPos <= 50+7+(10-5) && yPos < 14){
                                yPos = 14;
                                yVel = 0;
                        }

                        //If we are climbing then we are ging up
                        if (xPos > 100-(10+5) && yPos < (xPos-100+10+5)*.5){
                                yPos = (xPos-100+10+5)*.5;
                                yVel = 0;
                                xVel = .5;
                                angle = 0.464257581;
                        }

                        //Jump if near the box
                        if (xPos > 20 && xPos < 25 && yVel == 0)
                                yVel = 5;
                }
        }
}