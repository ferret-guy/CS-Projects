public class Section2{
    public static void main(String[] args){
        int i=Integer.parseInt(args[0]); 
        double d = Double.parseDouble(args[1]);
        int iSquared = (int) Math.pow(i,(double) 2);
        double dSquared = Math.pow(d,(double) 2);
        double sum = i+d;
        double prod = i*d;
            
        System.out.println("i:"+i);
        System.out.println("d:"+d);
        System.out.println("iSquared:"+iSquared);
        System.out.println("dSquared:"+dSquared);
        System.out.println("sum:"+sum);
        System.out.println("prod:"+prod);
        
    }
}