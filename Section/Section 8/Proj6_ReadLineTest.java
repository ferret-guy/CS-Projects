import java.util.Scanner;
import java.util.ArrayList;

public class Proj6_ReadLineTest{
    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        String old = "";
        outerloop:
        while (in.hasNext()){
            String input = in.nextLine();
            for (int i=0;i<input.split(" +").length;i++){
                if (input.split(" +")[i].equals("END"))
                    break outerloop;
                if (args.length==1){
                    if (input.split(" +")[i].compareTo(args[0])>0){
                        System.out.println("Good Word");
                        words.add(input.split(" +")[i]);
                    }
                }
                else{
                System.out.println(input.split(" +")[i]);
                System.out.println(input.split(" +")[i].length());
                System.out.println(input.split(" +")[i].split("")[1]);
                System.out.println(""+input.split(" +")[i].split("")[2]+input.split(" +")[i].split("")[3]+input.split(" +")[i].split("")[4]);
                words.add(input.split(" +")[i]);
                }
            }
        }
        System.out.println(words);
    }
}