package lambda_functional_programming01;

import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamOlusturma {
    public static void main(String[] args) {




        Stream<Object> liste=IntStream.range(0, 20).mapToObj(i -> "x");//"x" dizesinin 20 kopyasından oluşan bir stream elde etmek için
        Object sonEleman=liste.reduce((a, b) -> b)
                .orElseThrow(() -> new IllegalStateException("no last element"));
        System.out.println(liste);
        System.out.println(sonEleman);

        Stream<String> list=Collections.nCopies(5, "ce").stream();//  n adet "ce" den olusan bir koleksiyon oluşturmak ve ardından stream yapmaktır
        String sonEleman2=list.reduce((a, b) -> b)
                .orElseThrow(() -> new IllegalStateException("no last element"));
        System.out.println(sonEleman2);
        System.out.println(list);

    }
}
