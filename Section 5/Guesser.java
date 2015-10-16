import java.util.Scanner;

public class Guesser{
    public static void main(String[] args){
        int target = Integer.parseInt(args[0]);
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String word = in.next();
            try{
                if (Integer.parseInt(word) > target)
                    System.out.println("Guess was too high!");
                else if (Integer.parseInt(word) < target)
                    System.out.println("Guess was too low!");
                else {
                    System.out.println("You Win!");
                    return;
                }
            }
            catch (NumberFormatException e) {
                System.out.println(word+ " is not an int! try again!");}
        }
    }
}