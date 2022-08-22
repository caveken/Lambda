package lambda_functional_programming01;

public class Utils {
    public static void ayniSatirdaBosluklaYazdir(Object obj){

        System.out.print(obj+" ");

    }

    public static boolean ciftElemaniSec(int x){

        return x%2==0;

    }

    public static boolean tekElemaniSec(int x){

        return x%2!=0;

    }

    public static int karesinAl(int x){

        return x*x;
    }

    public static int kupunuAl(int x){

        return x*x*x;
    }

    public static int toplam(int x,int y){
        return x+y;
    }

    public static int carpim(int x, int y) {
        return x*y;
    }

    public static boolean yedidenBuyuguSec( int x) {
        return x>7;
    }
    public static boolean besdenBuyuguSec( int x) {
        return x>5;
    }

    public static double yarisiniAl(int x) {
        return x/2.0;
    }

    public static char sonKarakteriAl(String str){
        return (char) str.lastIndexOf(str);
    }

    public static char  ilkKarakteriAl(String s) {
        return s.charAt(0);
    }
    public static int rakamlarToplaminiAl(int x) {

        int toplam = 0;

        while (x > 0) {
            toplam += x % 10;
            x /= 10;

        }
        return toplam;

    }
}
