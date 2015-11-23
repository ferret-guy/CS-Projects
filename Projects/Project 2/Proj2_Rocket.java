/* Proj2_Rocket
*
* CSc 127A Fall 15, Project 02
*
* Author: Mark O.
* Section: K
*
* ---
*
* This class calculates the performance of a three-stage rocket, using
* extremely inaccurate equations provided by the instructor.
*/ 


public class Proj2_Rocket {
    public static void main(String[] args) {
        //Define input vars
        double[][] input = new double[3][2];//For input vars
        boolean[][] errors = new boolean[3][2];//For failure conditions
        double payload = 0;
        
        //Define tracking vars
        double speed = 0;
        double altitude = 0;
        
        //Check if there are the proper number of args
        if (args.length == 7){
            //Get Payload
            try{payload = Double.parseDouble(args[0]);}
            catch (NumberFormatException e){System.out.println("Invalid Payload");
                return;} 
            
            //Get 1st stage params
            try{input[0][0] = Double.parseDouble(args[1]);}
            catch (NumberFormatException e){System.out.println("Invalid Stage 1 engine count");
                return;} 
            try{input[0][1] = Double.parseDouble(args[2]);}
            catch (NumberFormatException e){System.out.println("Invalid Stage 1 fuel amount");
                return;} 
            
            //Get 2nd stage params
            try{input[1][0] = Double.parseDouble(args[3]);}
            catch (NumberFormatException e){System.out.println("Invalid Stage 2 engine count");
                return;} 
            try{input[1][1] = Double.parseDouble(args[4]);}
            catch (NumberFormatException e){System.out.println("Invalid Stage 2 fuel amount");
                return;} 
            
            //Get 3rd stage params
            try{input[2][0] = Double.parseDouble(args[5]);}
            catch (NumberFormatException e){System.out.println("Invalid Stage 2 engine count");
                return;} 
            try{input[2][1] = Double.parseDouble(args[6]);}
            catch (NumberFormatException e){System.out.println("Invalid Stage 2 fuel amount");
                return;} 
            }

        //If the wrong number of args let them know the right number
        else{
            System.out.println("Invalid args format, usage:\njava Proj2_Rocket <Payload> <Stage 1 engine count> <1 fuel amount (kg)> <Stage 2 engine count> <Stage 2 fuel amount (kg)> <Stage 3 engine count> <Stage 3 fuel amount (kg)> ");
            return;
        }
        
        //Print statments
        System.out.println("Weight of the first stage stack: " +(payload+input[0][0]*100+input[0][1]+input[1][0]*100+input[1][1]+input[2][0]*100+input[2][1]));
        System.out.println("  First stage thrust: " +(input[0][0]*1000));
        System.out.println("Weight of the second stage stack: " +(payload+input[1][0]*100+input[1][1]+input[2][0]*100+input[2][1]));
        System.out.println("  Second stage thrust: " +(input[1][0]*1000));
        System.out.println("Weight of the third stage stack: " +(payload+input[2][0]*100+input[2][1]));
        System.out.println("  Third stage thrust: " +(input[2][0]*1000));
        
        //Insert (odd) required linefeed
        System.out.println();
        
        //Print Stage 1 Header
        System.out.println("After the first stage:");
        //Update tracking vars
        speed = (input[0][0]*1000-(payload+input[0][0]*100+input[0][1]+input[1][0]*100+input[1][1]+input[2][0]*100+input[2][1]))*((input[0][1])/(100*input[0][0]));
        altitude = ((input[0][1])/(100*input[0][0]))* //Burnout time
            ((0+  
              (( /*total thrust*/input[0][0]*1000- /*Stack mass*/ (payload+input[0][0]*100L+input[0][1]+input[1][0]*100L+input[1][1]+input[2][0]*100+input[2][1]) ) * /*Burnout time*/((input[0][1])/(100*input[0][0]))) ) //Delta_v
                 /(2L));
        System.out.println("  Speed: "+speed);
        System.out.println("  Altitude: "+altitude);
        if(speed<=0||altitude<=0){
            if(speed<=0.0){errors[0][0]=true;}
            if(altitude<=0.0){errors[0][1]=true;}
        }
        //Print Stage 2 Header
        System.out.println("After the second stage:");
        //Update tracking vars
        altitude = altitude + ((input[1][1])/(100*input[1][0]))* //Burnout time
            ((2*speed+  
              (( /*total thrust*/input[1][0]*1000- /*Stack mass*/ (payload+input[1][0]*100L+input[1][1]+input[2][0]*100+input[2][1]) ) * /*Burnout time*/((input[1][1])/(100*input[1][0]))) ) //Delta_v
                 /(2L));
        speed = speed+(input[1][0]*1000-(payload+input[1][0]*100+input[1][1]+input[2][0]*100+input[2][1]))*((input[1][1])/(100*input[1][0]));
        System.out.println("  Speed: "+speed);
        System.out.println("  Altitude: "+altitude);
        if(speed<=0||altitude<=0){
            if(speed<=0.0){errors[1][0]=true;}
            if(altitude<=0.0){errors[1][1]=true;}
        }
        
        //Print Stage 3 Header
        System.out.println("After the second stage:");
        //Update tracking vars
        altitude = altitude + ((input[2][1])/(100*input[2][0]))* //Burnout time
            ((2*speed+  
              (( /*total thrust*/input[2][0]*1000- /*Stack mass*/ (payload+input[2][0]*100+input[2][1]) ) * /*Burnout time*/((input[2][1])/(100*input[2][0]))) ) //Delta_v
                 /(2L));
        speed = speed+(input[2][0]*1000-(payload+input[2][0]*100+input[2][1]))*((input[2][1])/(100*input[2][0]));
        System.out.println("  Speed: "+speed);
        System.out.println("  Altitude: "+altitude);
        if(speed<=0||altitude<=0){
            if(speed<=0.0){errors[2][0]=true;}
            if(altitude<=0.0){errors[2][1]=true;}
        }
        
        //Insert (another odd) required linefeed
        System.out.println();
        
        //Print Apogee
        System.out.println("Apogee: "+(altitude+speed*(speed/9.8)-4.9*(speed/9.8)*(speed/9.8)));
        
        //Print errors
        if(errors[0][0]==true){System.out.println("STALL!  The speed after the first stage is <= 0.");}
        if(errors[1][0]==true){System.out.println("STALL!  The speed after the second stage is <= 0.");}
        if(errors[2][0]==true){System.out.println("STALL!  The speed after the third stage is <= 0.");}
        if(errors[0][1]==true){System.out.println("CRASH!  The altitude after the first stage is <= 0.");}
        if(errors[1][1]==true){System.out.println("CRASH!  The altitude after the second stage is <= 0.");}
        if(errors[2][1]==true){System.out.println("CRASH!  The altitude after the third stage is <= 0.");}
    }
} 