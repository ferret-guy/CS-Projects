import java.util.Arrays;
import java.util.Scanner;

public class Section_11{
    public static int[] arrayExtend(int[] arr){
        int x = arr.length;
        arr = Arrays.copyOf(arr, x*2);
        return arr;
    }
    
    public static String[] arrayExtend(String[] arr){
        int x = arr.length;
        arr = Arrays.copyOf(arr, x*2);
        return arr;
    }
    
    public static String[] arrayAppend(String[] arr, String i) { 
        int x = arr.length;
        arr = Arrays.copyOf(arr, x + 1);
        arr[x] = i;
        return arr;
    } 
    
    public static int[] arrayAppend(int[] arr, int i) { 
        int x = arr.length;
        arr = Arrays.copyOf(arr, x + 1);
        arr[x] = i;
        return arr;
    }
    
    public static String[] concatArrays(String[] a, String[] b) {
        int aLen = a.length;
        int bLen = b.length;
        String[] c= new String[aLen+bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    public static int[] concatArrays(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int[] c= new int[aLen+bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }
    
    public static void dumpArray(int[] arr){
        System.out.println(Arrays.toString(arr));}
    
    public static void dumpArray(String[] arr){
        System.out.println(Arrays.toString(arr));}
    
    public static void dumpArray(String[] arr, int i){
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, i)));}
    
    public static void dumpArray(int[] arr, int i){
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, i)));}

    
    public static void main(String[] args){
        int[] arri = {0};
        String[] arrs = {};
        int[] arri2 = {1,2,3,4,5,6,7,8,9,10};
        String[] arrs2 = {"lol1","lol2","lol3","lol4"};
        dumpArray(arrayExtend(arri2));
        dumpArray(arrayExtend(arrs2));
        dumpArray(concatArrays(arrayExtend(arri2),arri2));
        dumpArray(concatArrays(arrayExtend(arrs2),arrs2));
        
        arri[0]=1;
        dumpArray(arri);
        arri = arrayExtend(arri);
        dumpArray(arri);
        arri[1]=1;
        dumpArray(arri);
        arri = arrayExtend(arri);
        dumpArray(arri);
        arri[2]=1;
        dumpArray(arri);
        arri[3]=1;
        dumpArray(arri);
        
        
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String input = in.next();
            try{
                arri = arrayAppend(arri,Integer.parseInt(input));
                dumpArray(arri);
            }
            catch (NumberFormatException e){
                arrs = arrayAppend(arrs,input);
                dumpArray(arrs);
            }
                
        }
    }
}