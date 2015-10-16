import java.util.Scanner;

public class HasNext1{
    public static void main(String[] args){
        String[] words = new String[3];
        String[] prompts = {"Fisrst","Second","Third"};
        System.out.println("STARTING...");
        Scanner in = new Scanner(System.in);
        for (int i=0;i < 3;i++){
            System.out.print("Enter the "+prompts[i]+" word: ");
                words[i] = in.nextLine();
        }
        System.out.print("\nYour Three words were: ");
        for (int i=0;i<3;i++){
            System.out.print(words[i]+" ");
        }
        System.out.print("\n Your Three words in reverse order: ");
        for (int i=2;i>-1;i--){
            System.out.print(words[i]+" ");
        }
    }
}
