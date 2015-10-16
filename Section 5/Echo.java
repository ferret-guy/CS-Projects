import java.util.Scanner;

public class Echo{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String old = "";
        while (in.hasNext()){
            String input = in.nextLine();
            for (int i=0;i<input.split(" ");i++){
                System.out.println(input.split(" ")[i]);
            }
        }
    }
}