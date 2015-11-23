import java.util.Scanner;
public class section_12{
    public static String fuzzyNum(long val){
        if (val < 0)
            return "-"+fuzzyNum(-val);
        final long ONE_THOUSAND = 1000L;
        final long ONE_MILLION = 1000000L;
        final long ONE_BILLION = 1000000000L;
        final long ONE_TRILLION = 1000000000000L;
        final long ONE_QUADRILLION = 1000000000000000L;
        final long ONE_QUINTILLION = 1000000000000000000L;
        if (val < ONE_THOUSAND)
            return ""+val;
        if (val < ONE_MILLION)
            return val/ONE_THOUSAND+" thousand";
        if (val < ONE_BILLION)
            return val/ONE_MILLION+" million";
        if (val < ONE_TRILLION)
            return val/ONE_TRILLION+"TRILLION";
        if (val < ONE_QUADRILLION)
            return val/ONE_QUADRILLION+"QUADRILLION";
        if (val < ONE_QUINTILLION)
            return val/ONE_QUINTILLION+"QUINTILLION";
        return "gazillions";
    } 
    public static void main(String[] args){
        byte b = 1;
        short s = 1;
        int i = 1;
        long l = 1;
        
        Scanner in = new Scanner(System.in);
        
        while (in.hasNextLine()){
            in.nextLine();
            b *= 2;
            s *=2;
            i *=2;
            l *=2;
            
            System.out.printf("%d %d %s %s \\ %d \n", b, s, fuzzyNum(i), fuzzyNum(l), ((byte) l));
        }
    }
}