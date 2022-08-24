package LambdaPractise01;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Lambda01 {//okul projesinde listele vb lamda expression ile yapiniz
    static ArrayList<String> names = new ArrayList<>(
            Arrays.asList("Tulay", "zekeriya", "hasan", "ismail", "osman", "fatih","Ersin","Mevlit"));
    static List<Integer> numbers=new ArrayList<>(Arrays.asList(25,65,-56,55,98,-89,65,55,21,-54,9,35,35,34));
    /* TASK :
     * Input olarak verilen listteki isimlerden
     * icinde ‘a’ harfi bulunanlari silen bir code create ediniz.
     *
     * INPUT : list1={"Ali","Veli","Ayse","Fatma","Omer"}
     * OUTPUT : [Veli,Omer]
     */
    public static void aHarfleriSilenGerisiniYazdiran(ArrayList<String> isimler){
//        System.out.println(isimler.stream()//akiisa alindi
//                .map(m -> m.toLowerCase())//hepsi kucuk harffe cevrilfi
//                .filter(m -> !m.contains("a"))//a harfi olmayanlar filtrelendi
//                .collect(Collectors.toList()));//lisste atildi
//      2.yol
//        System.out.println(isimler.stream()//akiisa alindi
//                .filter(m -> !m.contains("a") && !m.contains("A"))//a harfi olmayanlar filtrelendi
//                .collect(Collectors.toList()));//lisste atildi
//3.yol
        isimler.removeIf(t->t.contains("a") || t.contains("A"));
        System.out.println(names);
    }
    //en buyyk elemani bulun
    public static void maxElemanBul(List<Integer> sayi){
        Optional<Integer> maxSayi=
                sayi.stream().
                        reduce(Math::max);
        System.out.println("maxSayi = " + maxSayi);
        //2.yol
        System.out.println("sayi.stream().reduce(Integer::max) = " + sayi.
                stream().
                reduce(Integer::max));//spesifik bir method cagirirsani daha hizli yani alirsinz
//        reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
//                kullanımı yaygındır pratiktir.
//        Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
//        bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
//                reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
//                reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
//        İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
    }
    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...
    public static void elemanlariTopla(List<Integer> sayilar){
        System.out.println("sayilar.stream().reduce(0,(a,b)-> a+b) = " +
                sayilar.stream()
                        .reduce(0, (a, b) -> a + b));
        System.out.println("sayilar.stream().reduce(Integer::sum) = " + sayilar.stream().
                reduce(Integer::sum).get());//spesifik methoda daha hizlidir
    }
    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void elemanlariCarp(List<Integer> sayilar){
        //lambda expression ile
        System.out.println(
                sayilar.stream()
                        .filter(Methodlarim::ciftElemaniBul)//method ref kullanildi kendi class imizda
                        // create ettigimiz seed methodu kulandik
                        .reduce(1, (a, b) -> a * b));
        //method referans ile
        System.out.println(sayilar.stream().filter(Methodlarim::ciftElemaniBul)
                .reduce(Math::multiplyExact).get());
    }
    public static void teklerinKareBuyuktenKucuge(List<Integer> sayi) {
        sayi.stream().filter(t->t%2!=0).
                map(t->t*t).
                sorted(Comparator.reverseOrder()).
                forEach(Methodlarim::yazdir);
        System.out.println();
    }
    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfabetikBuyukHarfTekrarsiz(List<String> yemek) {
    }
    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void strKarakterSayisiYazdir(List<String> yemek) {
    }
    public static void sonHarfeGoreTersSira(List<String> yemek) {
        yemek.stream().
                sorted(Comparator.
                        comparing(t->t.toString().
                                charAt(t.toString().length()-1)).
                        reversed()).
                forEach(Methodlarim::yazdir);
        System.out.println();
    }
    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz
    // buyukten kucuge sirali  print ediniz..
    public static void karakterCiftKareBuyuktenKucuge(List<String> yemek) {
    }
    public static void karakterSayiYedidenBuyuk(List<String> yemek) {
        boolean kontrol=yemek.stream().allMatch(t->t.length()<=7);
        if (kontrol){
            System.out.println("list elemanları 7 ve az harften olusmus");
        }else System.out.println("bazi elemanlar 7 den buyuk");

        //lambda ile cözüm
        System.out.println(yemek.stream().
                allMatch(t->t.length()<=7)?
                "list elemanları 7 ve az harften olusmus":
                "bazi elemanlar 7 den buyuk");
    }
    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void basHarfiWIleBaslayan(List<String> yemek) {
    }
    // TODO Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBitenEleman(List<String> yemek) {
    }
    // TODO Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karkterEnFazla(List<String> yemek) {
        System.out.println(yemek.stream().
                sorted(Comparator.
                        comparing(t -> t.toString().length()).
                        reversed()).
                findFirst().get());
    //2. yol
        yemek.stream().
                sorted(Comparator.comparing(t->t.toString().
                        length()).reversed()).
                limit(1).forEach(Methodlarim::yazdir);
        System.out.println();
        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.
    }
    /*
TRİCK : •    Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz.
Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
•  Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray()));
kullanılabilir.
*/
    //TODO Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void sonHarfeGoreSiralaIlkHaricElmanlariYaz(List<String> yemek) {
    }

}
